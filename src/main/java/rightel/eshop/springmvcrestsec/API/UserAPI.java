package rightel.eshop.springmvcrestsec.API;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rightel.eshop.springmvcrestsec.model.User;
import rightel.eshop.springmvcrestsec.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserAPI {


    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        Optional<User> foundUser = userService.findUserById(id);
        if (!foundUser.isPresent()){
            log.error("Id" + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(foundUser.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@Valid @RequestBody User userToUpdate, @PathVariable Long id){
        if (!userService.findUserById(id).isPresent()){
            log.error("Id" + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.uodateUser(userToUpdate, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        if (!userService.findUserById(id).isPresent()){
            log.error("Id" + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}

