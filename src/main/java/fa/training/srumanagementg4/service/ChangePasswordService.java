package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.ChangePassword;
import org.springframework.security.core.Authentication;

public interface ChangePasswordService {

    boolean changePassword(ChangePassword changePassword, Authentication authentication);
    boolean forgotPassword(ChangePassword changePassword, String email);
}
