package rightel.eshop.springmvcrestsec.services;

import org.springframework.stereotype.Service;
import rightel.eshop.springmvcrestsec.model.User;
import rightel.eshop.springmvcrestsec.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findUserByName(String name) {
       return userRepository.findByUserName(name);
    }
}
