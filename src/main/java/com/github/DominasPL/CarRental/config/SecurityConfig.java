package com.github.DominasPL.CarRental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT username, password, true FROM users WHERE username = ?") // pobieranie pól z bazy danych które wykorzystywane są w procesie logowania
                .authoritiesByUsernameQuery("SELECT username, role FROM users\n" +
                        "JOIN users_roles ON users.id = users_roles.user_id\n" +
                        "JOIN roles ON roles.id = users_roles.role_id\n" +
                        "WHERE username = ?;");

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //tak jak w bolku try catch od najbardziej szczegółowych do najmniej
                    .antMatchers("/register").anonymous() // dostep dla niezalogowanych
                    .antMatchers("/login").anonymous() // dostep dla niezalogowanych
                    .antMatchers("/").anonymous() // dostep dla niezalogowanych
                    .antMatchers("/admin", "/admin/**").hasRole("ADMIN") // tylko dla adminow
                    .antMatchers("/user", "/user/**").hasRole("USER") // tylko dla userow
//                    .antMatchers("/media/**").permitAll()//dostep do folderu media dla wszystkich
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/check-role") // domyślna strona po zalogowaniu
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/") // strona po wylogowaniu
                    .and()
                .csrf()
                    .disable();

    }
}
