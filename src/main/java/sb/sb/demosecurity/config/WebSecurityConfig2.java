package sb.sb.demosecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ：lixiangyu
 * @title: WebSecurityConfig
 * @projectName demo-security
 * @description：TODO
 * @date ：2023-02-15 22:28
 */
//@Configuration
public class WebSecurityConfig2 extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return username -> {
            String pw = passwordEncoder().encode("654321");
            return new User("kyxx", pw, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,user"));
        };
    }
}
