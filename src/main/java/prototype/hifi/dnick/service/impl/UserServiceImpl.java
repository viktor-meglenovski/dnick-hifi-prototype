package prototype.hifi.dnick.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import prototype.hifi.dnick.model.User;
import prototype.hifi.dnick.model.enumerations.Role;
import prototype.hifi.dnick.model.exceptions.InvalidUsernameOrPasswordException;
import prototype.hifi.dnick.model.exceptions.PasswordsDoNotMatchException;
import prototype.hifi.dnick.model.exceptions.UserDoesNotExistException;
import prototype.hifi.dnick.model.exceptions.UsernameAlreadyExistsException;
import prototype.hifi.dnick.repository.UserRepository;
import prototype.hifi.dnick.service.TestResultService;
import prototype.hifi.dnick.service.TopicService;
import prototype.hifi.dnick.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TopicService topicService;
    private final TestResultService testResultService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, TopicService topicService, TestResultService testResultService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.topicService = topicService;
        this.testResultService = testResultService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));
    }


    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role userRole) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username,passwordEncoder.encode(password),name,surname,userRole);
        userRepository.save(user);
        //todo: da se stavat site temi kako nezavrseni i da se vnesat 3 rezultati kako 0 poeni
        topicService.setAllTopicsAsNotCompletedForUser(user);
        testResultService.initResultsForUser(user);


        return user;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(UserDoesNotExistException::new);
    }
}
