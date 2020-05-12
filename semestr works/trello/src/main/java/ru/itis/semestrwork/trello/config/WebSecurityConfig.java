package ru.itis.semestrwork.trello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import ru.itis.semestrwork.trello.security.JwtFilter;
import ru.itis.semestrwork.trello.security.JwtTokenProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtFilter jwtFilter;
    private final JwtTokenProvider jwtTokenProvider;

    public WebSecurityConfig(@Lazy JwtFilter jwtFilter, JwtTokenProvider jwtTokenProvider) {
        this.jwtFilter = jwtFilter;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.formLogin().disable();
        http.logout().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, BasicAuthenticationFilter.class);

        http.authorizeRequests()
                .antMatchers("/api/trello/signUp").permitAll()
                .antMatchers("/api/trello/signIn").permitAll()
                .antMatchers("/api/trello/admin").hasAuthority("ADMIN")
                .antMatchers("/api/trello/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .logout().permitAll();

    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api/trello/signIn", "/api/trello/signUp");
    }

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(jwtTokenProvider);
    }

}
