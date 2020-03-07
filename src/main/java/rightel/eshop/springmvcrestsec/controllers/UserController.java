package rightel.eshop.springmvcrestsec.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rightel.eshop.springmvcrestsec.model.User;
import rightel.eshop.springmvcrestsec.services.UserService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/users";

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

//    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

//    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

//    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @PutMapping("/{id}")
//    public User updateUser(@RequestBody User user, @PathVariable Long id){
//        return userService.updateUser(user, id);
//    }

//     @GetMapping("/{name}")
//    public List<User> getUserByName(@PathVariable String name){
//        return userService.findUserByName(name);
//    }

}
