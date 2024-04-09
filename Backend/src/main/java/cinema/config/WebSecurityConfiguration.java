package cinema.config;

import cinema.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration // kết hợp với @Bean để tạo thành 1 bean trong spring IOC
@EnableWebSecurity
public class WebSecurityConfiguration {
    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(accountService)
                .passwordEncoder(passwordEncoder);
        return builder.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                .requestMatchers("/api/not-authenticated", "/api/v1/account/create", "/api/v1/auth/login-basic-v2"
                        , "/api/v1/auth/login-jwt", "/api/v1/room/get-all").permitAll()
                .requestMatchers("/api/admin-or-user", "/api/v1/food/get-all", "/api/v1/food/*", "/api/v1/food/search"
                        ,"/api/v1/food/find-by-food-type", "/api/v1/foodtype/get-all" ,"/api/v1/account/update")
                .hasAnyAuthority("ADMIN", "USER")
                .anyRequest().authenticated());
        http.httpBasic(config -> {})
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(sessionManagement ->
                sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/swagger-ui/**", "/swagger-resources/**", "/v3/api-docs/**");
    }
}
