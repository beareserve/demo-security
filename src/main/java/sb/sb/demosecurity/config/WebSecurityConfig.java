package sb.sb.demosecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sb.sb.demosecurity.service.UserService;

import javax.annotation.Resource;

/**
 * @author ：lixiangyu
 * @title: WebSecurityConfig
 * @projectName demo-security
 * @description：TODO
 * @date ：2023-02-15 22:28
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin() //表单提交
                .loginPage("/login.html") //自定义登录页面
                .loginProcessingUrl("/user/login") //登录访问路径，必须和表单提交接口一样
                //.defaultSuccessUrl("/admin/index") //认证成功之后跳转的路径
                .successForwardUrl("/main") //认证成功之后转发的路径,必须是Post请求
                .failureForwardUrl("/toerror") //认证失败之后转发的路径,必须是Post请求

                .and().authorizeRequests()
                //设置哪些路径可以直接访问，不需要认证
                .antMatchers("/user/login","/login.html").permitAll()
                .anyRequest().authenticated() //需要认证
                .and().csrf().disable(); //关闭csrf防护
    }

    protected void configure1(AuthenticationManagerBuilder auth) throws Exception {
        String password = passwordEncoder().encode("654321");
        auth
            // 使用基于内存的 InMemoryUserDetailsManager
            .inMemoryAuthentication()
            // 配置用户
            .withUser("kyxx").password(password).roles("admin")
            // 再配置个用户
            .and()
            .withUser("kyx").password(password).roles("user");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
}
