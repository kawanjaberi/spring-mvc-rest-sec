package rightel.eshop.springmvcrestsec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rightel.eshop.springmvcrestsec.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.userName='name'")
    public List<User> findByUserName(String name);
}
