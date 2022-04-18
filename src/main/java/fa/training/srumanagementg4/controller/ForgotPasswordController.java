package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.ChangePassword;
import fa.training.srumanagementg4.jwt.JwtProvider;
import fa.training.srumanagementg4.security.service.UserPrinciple;
import fa.training.srumanagementg4.service.ChangePasswordService;
import fa.training.srumanagementg4.service.UserService;
import fa.training.srumanagementg4.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@Controller
public class ForgotPasswordController {

    @Autowired
    UserService userService;

    @Autowired
    ChangePasswordService changePasswordService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @GetMapping("/get-email")
    public String getEmail(ModelMap theModel) {
        theModel.addAttribute("email", null);
        return "enter-email-forgot-password";
    }

    String emailStr = "";
    String numberSendToEmail = "";

    @PostMapping("/get-email")
    public String getInforEmail(@RequestParam("email") String email, ModelMap theModel) {
        String number = userService.getNumberValidatedByEmail(email);
        if (number == null) {
            theModel.addAttribute("message", Constant.EMAIL_NOT_EXIST);
            theModel.addAttribute("email", "");
            return "enter-email-forgot-password";
        }
        numberSendToEmail = number;
        emailStr = email;
        return "redirect:/number-validate";
    }

    @GetMapping("/number-validate")
    public String formValidateNumber(ModelMap theModel) {
        theModel.addAttribute("number", "");
        return "enter-number-validate";
    }

    @PostMapping("/number-validate")
    public String validateNumber(@RequestParam("number") String number, ModelMap theModel) {
        if (!numberSendToEmail.equals(number)) {
            theModel.addAttribute("message", Constant.EMAIL_NOT_EXIST);
            theModel.addAttribute("number", "");
            return "enter-number-validate";
        }
        return "redirect:/forgot-password";
    }

    @GetMapping("/forgot-password")
    public String formForgotPassword(ModelMap theModel) {
        theModel.addAttribute("changePassword", new ChangePassword());
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@Validated @ModelAttribute("changePassword") ChangePassword changePassword,
                                 HttpServletResponse response) {
        boolean checkForgotPassword = changePasswordService.forgotPassword(changePassword, emailStr);
        if (!checkForgotPassword) {
            return "redirect:/login";
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        emailStr,
                        changePassword.getRePasswordNew()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        Cookie cookie = new Cookie("access_token", jwt);
        cookie.setMaxAge(86400000);
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
}
