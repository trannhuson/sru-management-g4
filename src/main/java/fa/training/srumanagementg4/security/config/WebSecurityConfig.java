package fa.training.srumanagementg4.security.config;

import fa.training.srumanagementg4.jwt.CustomAccessDeniedHandler;
import fa.training.srumanagementg4.jwt.JwtAuthEntryPoint;
import fa.training.srumanagementg4.jwt.JwtAuthTokenFilter;
import fa.training.srumanagementg4.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtAuthEntryPoint unauthorizedHandler;

    @Bean
    public JwtAuthTokenFilter authenticationJwtTokenFilter() {
        return new JwtAuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().
                authorizeRequests()
                //                .anyRequest().authenticated()
                .antMatchers("/login", "/login-google", "/logout", "/get-email", "/number-validate", "forgot-password", "/resources/css/**", "/resources/js/**").permitAll()
                .antMatchers(HttpMethod.GET, "/chart/**").hasAnyRole("ADMIN", "TRAINER", "TRAINEE")
                .antMatchers(HttpMethod.GET, "/change-password/**").authenticated()
                .antMatchers(HttpMethod.POST, "/change-password/**").authenticated()
                .antMatchers(HttpMethod.GET, "/trainee/**").authenticated()
                .antMatchers(HttpMethod.GET,"/trainee/**").hasRole("TRAINEE")
                .antMatchers(HttpMethod.POST,"/trainee/**").hasRole("TRAINEE")
                .antMatchers(HttpMethod.GET,"/trainee/feed-back/**").hasRole("TRAINEE")
                .antMatchers(HttpMethod.GET, "/admin/**").authenticated()
                .antMatchers(HttpMethod.GET,"/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/admin/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/admin/get-all-class**").hasAnyRole("ADMIN", "TRAINER", "TRAINEE")
                .antMatchers(HttpMethod.GET, "/trainer/**").authenticated()
                .antMatchers(HttpMethod.GET,"/trainer/**").hasRole("TRAINER")
                .antMatchers(HttpMethod.POST, "/trainer/**").hasRole("TRAINER")
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler()).and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }
}

