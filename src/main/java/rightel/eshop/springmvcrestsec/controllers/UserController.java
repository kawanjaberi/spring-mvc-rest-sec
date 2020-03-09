package rightel.eshop.springmvcrestsec.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String list(){
        return "users";
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
