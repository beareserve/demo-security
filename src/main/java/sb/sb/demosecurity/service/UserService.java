package sb.sb.demosecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import sb.sb.demosecurity.entity.User;

public interface UserService extends UserDetailsService {

    User getByUsername(String username);

}
