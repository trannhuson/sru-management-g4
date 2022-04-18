package fa.training.srumanagementg4.service;

import fa.training.srumanagementg4.dto.Auth2DTO;

public interface AuthService {
    Auth2DTO loginGoogle(String accessToken);
}
