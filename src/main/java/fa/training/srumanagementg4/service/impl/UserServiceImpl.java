package fa.training.srumanagementg4.service.impl;
import fa.training.srumanagementg4.entities.Users;
import fa.training.srumanagementg4.repository.UserRepository;
import fa.training.srumanagementg4.service.UserService;
import fa.training.srumanagementg4.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    MailService mailService;

    @Override
    public Users findByAccount(String account) {
        Users byAccount = userRepository.getByAccount(account);

        return byAccount;
    }

    @Override
    public String getNumberValidatedByEmail(String email) {
        Optional<Users> users = userRepository.findByEmail(email);
        if (!users.isPresent()) {
            return null;
        }
        String numberValidate = Constant.getRandomNumberString();
        String content = "<h1>Hi, <span style='color: red'>" + users.get().getAccount() + "</span></h1>"
                        +"<br>"
                        +"<h1>The activation code to retrieve your password is: " + numberValidate + "</h1>"
                        +"<br>"
                        +"<br>"
                        +"<br>"
                        +"<h1>Please follow the instructions</h1>";
        mailService.sendEmail(users.get().getEmail(), content);
        return numberValidate;
    }

    @Override
    public boolean checkEmailExist(String email) {
        Optional<Users> users = userRepository.findByEmail(email);
        return false;
    }
}
