package rightel.eshop.springmvcrestsec.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rightel.eshop.springmvcrestsec.model.User;
import rightel.eshop.springmvcrestsec.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


//    @Override
//    public List<User> findUserByName(String name) {
//       return userRepository.findByUserName(name);
//    }
}
