package fa.training.srumanagementg4.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
    @GetMapping("/error")
    public String renderErrorPage(final HttpServletRequest httpRequest) {
        String errorMsg = "";
        String errorCode = "";
        final int httpErrorCode = getErrorCode(httpRequest);

        switch (httpErrorCode) {
            case 400: {
                errorCode = "400";
                errorMsg = "Bad Request";
                break;
            }
            case 401: {
                errorCode = "401";
                errorMsg = "Unauthorized";
                break;
            }
            case 403: {
                errorCode = "403";
                errorMsg = "Forbidden";
                break;
            }
            case 404: {
                errorCode = "404";
                errorMsg = "Page Not Found";
                break;
            }
            case 405: {
                errorCode = "405";
                errorMsg = "Method Not Allowed";
                break;
            }
            case 500: {
                errorCode = "500";
                errorMsg = "Internal Server Error";
                break;
            }
            default: {
                break;
            }
        }
        httpRequest.setAttribute("errorCode", errorCode);
        httpRequest.setAttribute("errorMsg", errorMsg);
        return "error/errors";
    }

    private int getErrorCode(final HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }
}
