package prototype.hifi.dnick.service;

import prototype.hifi.dnick.model.User;

public interface AuthService {
    User login(String username, String password);
}