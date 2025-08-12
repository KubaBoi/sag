package cz.kuba.sas.sag.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // TODO nastavit security
        http
                .csrf(AbstractHttpConfigurer::disable) // vypnutí CSRF pro pohodlí při vývoji
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // všechny endpointy veřejné
                .httpBasic(AbstractHttpConfigurer::disable) // vypnutí Basic Auth
                .formLogin(AbstractHttpConfigurer::disable); // vypnutí formulářového loginu

        return http.build();
    }
}
