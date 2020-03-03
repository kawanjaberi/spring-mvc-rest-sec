package rightel.eshop.springmvcrestsec.services;

import rightel.eshop.springmvcrestsec.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserById(Long id);

    List<User> findAllUsers();

    User saveUser(User user);

    List<User> findUserByName(String name);
}
