package rightel.eshop.springmvcrestsec.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rightel.eshop.springmvcrestsec.model.User;
import rightel.eshop.springmvcrestsec.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping("/{name}")
    public List<User> getUserByName(@PathVariable String name){
        return userService.findUserByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
