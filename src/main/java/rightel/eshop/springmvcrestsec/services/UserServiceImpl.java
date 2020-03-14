package rightel.eshop.springmvcrestsec.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rightel.eshop.springmvcrestsec.model.User;
import rightel.eshop.springmvcrestsec.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        log.error("Getting the user with given id:" + id);
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        User userToSave;
        try {
            log.info("Saving user...");
            userToSave = userRepository.save(user);
            return userToSave;
        }catch (Exception e){
            log.error("An error occured during saveing" + e.getMessage());
        }
        return new User();
    }

    @Override
    public void deleteUserById(Long id) {
        try{
            userRepository.deleteById(id);
        }catch (Exception e){
            log.error("An error occured during deleting: Id:" + id + " is not existed" + e.getMessage());
        }
    }

    @Override
    public User uodateUser(Long id, User userToUpdate) {

        User foundUser = userRepository.findById(id).get();
        try{
            foundUser.setUserName(userToUpdate.getUserName());
            foundUser.setUserEmail(userToUpdate.getUserEmail());
            //foundUser.setUpdateAt(Date);
            return userRepository.save(foundUser);
        }catch (Exception e){
            log.error("An error occured during update: Id:" + id + " is not existed" + e.getMessage());
        }
        return userToUpdate;

    }

}
