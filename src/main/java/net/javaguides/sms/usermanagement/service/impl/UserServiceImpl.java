package net.javaguides.sms.usermanagement.service.impl;

import net.javaguides.sms.usermanagement.entity.User;
import net.javaguides.sms.usermanagement.repository.UserRepository;
import net.javaguides.sms.usermanagement.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    // Constructor Based Dependency Injection
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
       return userRepository.findAll();
    }
}
