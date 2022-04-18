package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.UserDTO;
import fa.training.srumanagementg4.entities.Users;

public interface UserService {

    Users findByAccount(String account);
    String getNumberValidatedByEmail(String email);
    boolean checkEmailExist(String email);
}
