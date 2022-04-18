package fa.training.srumanagementg4.controller;

import fa.training.srumanagementg4.dto.Auth2DTO;
import fa.training.srumanagementg4.dto.LoginRequest;
import fa.training.srumanagementg4.entities.Attendance;
import fa.training.srumanagementg4.service.AuthService;
import fa.training.srumanagementg4.service.impl.AuthServiceImpl;
import fa.training.srumanagementg4.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class OAuth2LoginController {

    private Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    private AuthService authService;

    @PostMapping("/login-google")
    public String loginGoogle(@RequestParam("access_token") String accessToken, HttpServletResponse response) {
        Constant.ACCESS_TOKEN = accessToken;
        Auth2DTO auth2DTO;
        try {
            auth2DTO = authService.loginGoogle(Constant.ACCESS_TOKEN);
        } catch (Exception exception) {
            logger.error("LOGIN FAIL WITH ACCESSTOKEN: {}", Constant.ACCESS_TOKEN);
            Constant.MESSAGE_LOGIN = Constant.LOGIN_GOOGLE_FAIL;
            return "redirect:/login";
        }
        Cookie cookie = new Cookie("access_token", auth2DTO.getAccessToken());
        cookie.setMaxAge(86400000);
        response.addCookie(cookie);

        if (("ROLE_TRAINEE").equals(auth2DTO.getAuthorities().toArray()[0].toString())) {
            return "redirect:/trainee/attendance/get-trainee";
        } else if (("ROLE_TRAINER").equals(auth2DTO.getAuthorities().toArray()[0].toString())) {
            return "redirect:/trainer/get-subject";
        }
        return "redirect:/chart";
    }
}
