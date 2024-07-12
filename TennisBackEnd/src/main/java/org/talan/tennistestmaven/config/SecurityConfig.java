package org.talan.tennistestmaven.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String API_PLAYER_ENDPOINT = "/api/player";
    private static final String API_REFEREE_ENDPOINT = "/api/referee";
    private static final String API_MATCH_ENDPOINT = "/api/match";

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(HttpMethod.POST, "/api/login").permitAll()
                        .requestMatchers(HttpMethod.POST, API_PLAYER_ENDPOINT).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, API_PLAYER_ENDPOINT + "/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, API_PLAYER_ENDPOINT + "/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, API_PLAYER_ENDPOINT + "/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, API_REFEREE_ENDPOINT).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, API_REFEREE_ENDPOINT + "/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, API_REFEREE_ENDPOINT + "/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, API_REFEREE_ENDPOINT + "/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, API_MATCH_ENDPOINT).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, API_MATCH_ENDPOINT + "/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, API_MATCH_ENDPOINT + "/score").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic();

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("TennisCounter1."))// Définir le mot de passe pour user
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("elodie")
                .password(passwordEncoder().encode("NebulotAdmin69."))// Définir le mot de passe pour user
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
