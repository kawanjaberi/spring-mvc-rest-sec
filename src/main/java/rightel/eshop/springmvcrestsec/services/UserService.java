package rightel.eshop.springmvcrestsec.services;

import rightel.eshop.springmvcrestsec.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUsers();

    Optional<User> findUserById(Long id);

    User saveUser(User user);

    void deleteUserById(Long id);

    //List<User> findUserByName(String name);
}
