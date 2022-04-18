package fa.training.srumanagementg4.service.impl;

import com.fasterxml.classmate.Annotations;
import fa.training.srumanagementg4.dto.ChangePassword;
import fa.training.srumanagementg4.entities.Users;
import fa.training.srumanagementg4.repository.UserRepository;
import fa.training.srumanagementg4.security.service.UserPrinciple;
import fa.training.srumanagementg4.service.ChangePasswordService;
import fa.training.srumanagementg4.utils.Constant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * @author SonTN9
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ChangePasswordServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private ChangePasswordService changePasswordService;

    @Captor
    ArgumentCaptor<Users> captor;

    @MockBean
    MailService mailService;

    @MockBean
    Authentication authentication;

    /**
     * @author SonTN9
     *
     */
    @Test
    void forgotPasswordSuccess() {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setPasswordOld("abcd");
        changePassword.setRePasswordNew("abcd");

        Users user = new Users();
        user.setAccount("SonTN9");
        user.setEmail("son.trannhu.dev@gmail.com");
        user.setPassword("abc");
        Optional<Users> users = Optional.of(user);
        when(userRepository.findByEmail(anyString())).thenReturn(users);
        boolean check = changePasswordService.forgotPassword(changePassword, user.getEmail());
        Mockito.verify(userRepository).save(captor.capture());
        Mockito.verify(mailService).sendEmail(users.get().getEmail(), Constant.CHANGE_PASSWORD_SUCCESS);
        Users saveUsers = captor.getValue();
        assertEquals(user.getEmail(), saveUsers.getEmail());
        assertEquals(true, check);
    }

    /**
     * @author SonTN9
     *
     */
    @Test
    void forgotPasswordFail() {
        Users user = new Users();
        user.setAccount("SonTN9");
        user.setPassword("abc");
        Optional<Users> users = Optional.of(user);
        when(userRepository.findByEmail(anyString())).thenReturn(users);
        boolean check = changePasswordService.forgotPassword(new ChangePassword(), user.getEmail());
        Mockito.verify(userRepository, never()).save(any(Users.class));
        assertEquals(false, check);
    }


    /**
     * @author SonTN9
     *
     */
    @Test
    void changePasswordSuccess() {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setPasswordOld("abc");
        changePassword.setRePasswordNew("abc");
        Users user = new Users();
        user.setAccount("SonTN9");
        user.setEmail("son.trannhu.dev@gmail.com");
        user.setPassword("$2a$10$3mj7QFkKO7Ozt8CsXojJIupeCWE32IQBVwnnGqiv/w4pP3j.byW2i");
        Optional<Users> users = Optional.of(user);
        UserPrinciple userPrinciple = new UserPrinciple(user.getEmail());
        when(authentication.getPrincipal()).thenReturn(userPrinciple);
        when(userRepository.findByEmail(anyString())).thenReturn(users);
        boolean check = changePasswordService.changePassword(changePassword, authentication);
        Mockito.verify(userRepository).save(captor.capture());
        Mockito.verify(mailService).sendEmail(users.get().getEmail(), Constant.CHANGE_PASSWORD_SUCCESS);
        Users saveUsers = captor.getValue();
        assertEquals(user.getEmail(), saveUsers.getEmail());
        assertEquals(user.getAccount(), saveUsers.getAccount());
        assertEquals(true, check);
    }

    /**
     * @author SonTN9
     *
     */
    @Test
    void changePasswordFail() {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setPasswordOld("abcd");
        changePassword.setRePasswordNew("abcd");
        Users user = new Users();
        user.setAccount("SonTN9");
        user.setEmail("son.trannhu.dev@gmail.com");
        user.setPassword("$2a$10$3mj7QFkKO7Ozt8CsXojJIupeCWE32IQBVwnnGqiv/w4pP3j.byW2i");
        Optional<Users> users = Optional.of(user);
        UserPrinciple userPrinciple = new UserPrinciple(user.getEmail());
        when(authentication.getPrincipal()).thenReturn(userPrinciple);
        when(userRepository.findByEmail(anyString())).thenReturn(users);
        boolean check = changePasswordService.changePassword(changePassword, authentication);
        Mockito.verify(userRepository, never()).save(any(Users.class));
        assertEquals(false, check);
    }
}
