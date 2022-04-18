package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.ChangePassword;
import fa.training.srumanagementg4.dto.LoginRequest;
import fa.training.srumanagementg4.entities.Role;
import fa.training.srumanagementg4.entities.Users;
import fa.training.srumanagementg4.enums.RoleName;
import fa.training.srumanagementg4.jwt.JwtProvider;
import fa.training.srumanagementg4.repository.RoleRepository;
import fa.training.srumanagementg4.repository.UserRepository;
import fa.training.srumanagementg4.security.service.UserPrinciple;
import fa.training.srumanagementg4.service.AuthService;
import fa.training.srumanagementg4.service.ChangePasswordService;
import fa.training.srumanagementg4.service.impl.AuthServiceImpl;
import fa.training.srumanagementg4.utils.Constant;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.CookieManager;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ChangePasswordService changePasswordService;

    @Autowired
    AuthService authService;

    @GetMapping(value={"/login", "/home", "/"})
    public String loginView(ModelMap theModel) {
        theModel.addAttribute("loginRequest", new LoginRequest());
        theModel.addAttribute("messageLogin", Constant.MESSAGE_LOGIN);
        if (!Constant.ACCESS_TOKEN.equals("")) {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("https://accounts.google.com/o/oauth2/revoke?token="+Constant.ACCESS_TOKEN);
            try {
                HttpResponse res = client.execute(post);
            } catch (IOException e) {
                logger.error("LOGIN FAIL", e.getMessage());
                e.printStackTrace();
            }
        }
        return "login";
    }

    @PostMapping("/login-user")
    public String authenticateUser(@Validated @ModelAttribute("loginRequest") LoginRequest loginRequest, HttpServletResponse response) {

        Constant.ACCESS_TOKEN = "";
        Authentication authentication = null;
        try{
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );
        }catch (Exception exception) {
            logger.error("LOGIN FAIL WITH EMAIL: {}", loginRequest.getEmail());
            Constant.MESSAGE_LOGIN = Constant.LOGIN_FAIL;
            return "redirect:/login";
        }
        Constant.MESSAGE_LOGIN = "";
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        Cookie cookie = new Cookie("access_token", jwt);
        cookie.setMaxAge(864000000);
        response.addCookie(cookie);
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> roles = userPrincipal.getAuthorities();
        if (("ROLE_TRAINEE").equals(roles.toArray()[0].toString())) {
            return "redirect:/trainee/attendance/get-trainee";
        } else if (("ROLE_TRAINER").equals(roles.toArray()[0].toString())) {
            return "redirect:/trainer/get-subject";
        }
        return "redirect:/chart";
    }

    @RequestMapping(value = "/logout-user", method = RequestMethod.GET)
    public String logoutAuthenticationToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

        for (Cookie cookie : request.getCookies()) {
            cookie.setValue("");
            cookie.setMaxAge(0);
            cookie.setPath("/");

            response.addCookie(cookie);
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, null, null);
        }
        if (!Constant.ACCESS_TOKEN.equals("")) {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("https://accounts.google.com/o/oauth2/revoke?token="+Constant.ACCESS_TOKEN);
            org.apache.http.HttpResponse res = client.execute(post);
        }
        return "redirect:/login";
    }

    @GetMapping("/change-password")
    public String formChangePassword(ModelMap theModel) {
        theModel.addAttribute("changePassword", new ChangePassword());
        return "change-password";
    }
    @PostMapping("/change-password")
    public String changePassword(@Validated @ModelAttribute("changePassword") ChangePassword changePassword, Authentication authentication) {
        changePasswordService.changePassword(changePassword, authentication);
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> roles = userPrincipal.getAuthorities();
        if (("ROLE_TRAINEE").equals(roles.toArray()[0].toString())) {
            return "redirect:/trainee/attendance/get-trainee";
        } else if (("ROLE_TRAINER").equals(roles.toArray()[0].toString())) {
            return "redirect:/trainer/get-subject";
        }
        return "redirect:/chart";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody LoginRequest userReadable) {
        if(userRepository.existsByAccount(userReadable.getUsername())) {
            return new ResponseEntity<>("Fail -> Username is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(userReadable.getEmail())) {
            return new ResponseEntity<>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Users user = new Users();
        modelMapper.map(userReadable,user);
        user.setPassword(encoder.encode(userReadable.getPassword()));
        Set<String> strRoles = userReadable.getRoles();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch(role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(adminRole);

                    break;
                case "trainee":
                    Role traineeRole = roleRepository.findByName(RoleName.ROLE_TRAINEE)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(traineeRole);

                    break;
                case "trainer":
                    Role trainerRole = roleRepository.findByName(RoleName.ROLE_TRAINER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(trainerRole);
                    break;
            }
        });

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok().body("User registered successfully!");
    }
}
