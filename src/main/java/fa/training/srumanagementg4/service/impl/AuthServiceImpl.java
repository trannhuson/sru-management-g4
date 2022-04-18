package fa.training.srumanagementg4.service.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfo;
import fa.training.srumanagementg4.dto.Auth2DTO;
import fa.training.srumanagementg4.dto.LoginRequest;
import fa.training.srumanagementg4.entities.Users;
import fa.training.srumanagementg4.exceptions.MissingUserRoleException;
import fa.training.srumanagementg4.exceptions.UserDoesNotExistException;
import fa.training.srumanagementg4.jwt.JwtProvider;
import fa.training.srumanagementg4.repository.UserRepository;
import fa.training.srumanagementg4.security.service.UserPrinciple;
import fa.training.srumanagementg4.service.AuthService;
import fa.training.srumanagementg4.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Auth2DTO loginGoogle(String accessToken) {
        GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
        Oauth2 oauth2 = new Oauth2.Builder(new NetHttpTransport(), new JacksonFactory(), credential).setApplicationName(
                "Oauth2").build();

        Userinfo userinfo = null;
        try {
            userinfo = oauth2.userinfo().get().execute();
        } catch (IOException e) {
            logger.error("GG_ERROR_OAUTH2LOGIN: {}", e.getMessage());
            throw new MissingUserRoleException(null, "login scrum");
        }

        Optional<Users> users = userRepository.findByEmail(userinfo.getEmail());
        if(users == null) {
            logger.error("User entered invalid email: " + userinfo.getEmail());
            throw new UserDoesNotExistException(userinfo.getEmail());
        }

        UserPrinciple userPrinciple = UserPrinciple.build(users.get());
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) userPrinciple.getAuthorities();
        OAuth2User user = new DefaultOAuth2User(authorities, userinfo, "email");
        OAuth2AuthenticationToken authentication = new OAuth2AuthenticationToken(user, authorities, "email");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateJwtToken(user.getName());
        return new Auth2DTO(token, authorities);
    }
}
