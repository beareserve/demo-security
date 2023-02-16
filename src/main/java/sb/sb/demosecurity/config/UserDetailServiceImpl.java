package sb.sb.demosecurity.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：lixiangyu
 * @title: UserDetailServiceImpl
 * @projectName demo-security
 * @description：TODO
 * @date ：2023-02-15 22:19
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //UserDetails userDetails = User.withUsername("kyxx").password("{noop}654321").authorities("admin").build();
        //UserDetails userDetails = User.withUsername("kyxx").password("654321").authorities("admin").build();
        String hashPwd = passwordEncoder.encode("654321");
        UserDetails userDetails = User.withUsername("kyxx").password(hashPwd).authorities("admin").build();
        return userDetails;
    }
}
