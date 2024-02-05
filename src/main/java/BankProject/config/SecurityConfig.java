package BankProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        x -> x
                                .requestMatchers(HttpMethod.GET, "/user/all").permitAll()
                                .requestMatchers(HttpMethod.GET, "/user/{username}").authenticated()
                                .requestMatchers(HttpMethod.POST, "/user").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/user/{username}").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/user/{username}").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.GET, "/account/all").permitAll()
                                .requestMatchers(HttpMethod.GET, "/account/{id}").authenticated()
                                .requestMatchers(HttpMethod.POST, "/account").hasRole("CLIENT")
                                .requestMatchers(HttpMethod.PUT, "/account/{id}").hasRole("CLIENT")
                                .requestMatchers(HttpMethod.DELETE, "/account/{id}").authenticated()
                                .requestMatchers(HttpMethod.GET, "/manager/all").permitAll()
                                .requestMatchers(HttpMethod.GET, "/manager/{id}").authenticated()
                                .requestMatchers(HttpMethod.POST, "/manager").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/manager/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/manager/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/product/all").permitAll()
                                .requestMatchers(HttpMethod.GET, "/product/{id}").hasAnyRole("MANAGER", "ADMIN")
                                .requestMatchers(HttpMethod.POST, "/product").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/product/{id}").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/product/{id}").hasRole("ADMIN")
                                .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }
}
