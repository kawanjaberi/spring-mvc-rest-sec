package rightel.eshop.springmvcrestsec.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import rightel.eshop.springmvcrestsec.model.User;
import rightel.eshop.springmvcrestsec.services.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {

//    @GetMapping("/")
//    public String list(){
//        return "users";
//    }

    private final UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/users/add")
    public String createUser(Model model){
        model.addAttribute("user", new User());
        return "edit";
    }

    @PostMapping(path = "users")
    public String saveUser(User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(path = "/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAllUsers());
        return "users";
    }

    @GetMapping(path = "/users/edit/{id}")
    public String editUser(Model model, @PathVariable(value ="id") Long id){
        model.addAttribute("user", userService.findUserById(id));
        return "edit";
    }

//    @RequestMapping(path = "/{id}", method = RequestMethod.GET)


//    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)


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
