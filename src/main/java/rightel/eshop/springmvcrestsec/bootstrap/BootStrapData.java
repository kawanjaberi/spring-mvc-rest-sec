package rightel.eshop.springmvcrestsec.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rightel.eshop.springmvcrestsec.repositories.UserRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final UserRepository userRepository;

    public BootStrapData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading User Data");

        /*
        User u1 = new User();
        u1.setUserName("test1");
        u1.setUserEmail("test1@rightel.ir");
        userRepository.save(u1);

        User u2 = new User();
        u2.setUserName("test2");
        u2.setUserEmail("test2@rightel.ir");
        userRepository.save(u2);

        User u3 = new User();
        u3.setUserName("test3");
        u3.setUserEmail("test3@rightel.ir");
        userRepository.save(u3);

        System.out.println("Users Saved: " + userRepository.count());

         */

        System.out.println("Project is Running:  -------------    [OK]    -------------");



    }
}
