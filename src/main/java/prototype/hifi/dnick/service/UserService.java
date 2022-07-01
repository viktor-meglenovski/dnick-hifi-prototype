package prototype.hifi.dnick.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import prototype.hifi.dnick.model.User;
import prototype.hifi.dnick.model.enumerations.Role;


public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
    User findByUsername(String username);
}
