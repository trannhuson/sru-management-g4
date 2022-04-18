package fa.training.srumanagementg4.service.impl;

import fa.training.srumanagementg4.dto.ChangePassword;
import fa.training.srumanagementg4.entities.Users;
import fa.training.srumanagementg4.repository.UserRepository;
import fa.training.srumanagementg4.security.service.UserPrinciple;
import fa.training.srumanagementg4.service.ChangePasswordService;
import fa.training.srumanagementg4.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MailService mailService;

    @Override
    public boolean changePassword(ChangePassword changePassword, Authentication authentication) {
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        Optional<Users> users = userRepository.findByEmail(userPrincipal.getEmail());

        if (passwordEncoder.matches(changePassword.getPasswordOld(), users.get().getPassword())) {
            users.get().setPassword(passwordEncoder.encode(changePassword.getRePasswordNew()));
            userRepository.save(users.get());
            mailService.sendEmail(users.get().getEmail(), Constant.CHANGE_PASSWORD_SUCCESS);
            return true;
        };

        return false;
    }

    @Override
    public boolean forgotPassword(ChangePassword changePassword, String email) {
        Optional<Users> users = userRepository.findByEmail(email);
        if (!users.isPresent()) {
            return false;
        }
        users.get().setPassword(passwordEncoder.encode(changePassword.getRePasswordNew()));
        userRepository.save(users.get());
        mailService.sendEmail(users.get().getEmail(), Constant.CHANGE_PASSWORD_SUCCESS);
        return true;
    }
}
