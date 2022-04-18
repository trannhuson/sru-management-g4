package fa.training.srumanagementg4.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class Auth2DTO {

    private String accessToken;
    private Collection<? extends GrantedAuthority> authorities;

    public Auth2DTO() {
    }

    public Auth2DTO(String accessToken, Collection<? extends GrantedAuthority> authorities) {
        this.accessToken = accessToken;
        this.authorities = authorities;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
