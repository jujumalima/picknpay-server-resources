/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */

@RequestMapping("/user")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*" )
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all-users", method = RequestMethod.GET)
    public List<User> getUsers(){
        
        return userService.getAllUsers();
    }
    
    
    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
    
        userService.saveUser(user);
        
        return "User saved successfully!!";
    }
    
    @RequestMapping(value = "/user-by-username/{userName}", method = RequestMethod.GET)
    public User getByUserName(@PathVariable String userName){
    
        return userService.getByUserName(userName);
    }
}
