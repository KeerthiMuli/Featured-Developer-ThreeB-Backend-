package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
public class UserController {
	 @Autowired
	    UserRepository userRepository;
	 // User Registration
	 @RequestMapping(value = "/users/register", method = RequestMethod.POST)
	 //   @GetMapping("/users/register")
	    public UserStatus registerUser(@Valid @RequestBody User newUser) {
	        List<User> users = userRepository.findAll();

	        System.out.println("New user: " + newUser.toString());

	        for (User user : users) {
	            System.out.println("Registered user: " + newUser.toString());

	            if (user.equals(newUser)) {
	                System.out.println("User Already exists!");
	                return UserStatus.USER_ALREADY_EXISTS;
	            }
	        }

	        userRepository.save(newUser);
	        return UserStatus.SUCCESS;
	    }
	//User Login
	    @PostMapping("/users/login")
	    public UserStatus loginUser(@Valid @RequestBody User user) {
	        List<User> users = userRepository.findAll();

	        for (User other : users) {
	            if (other.equals(user)) {
	                user.setLoggedIn(true);
	                userRepository.save(user);
	                return UserStatus.SUCCESS;
	            }
	        }

	        return UserStatus.FAILURE;
	    }
	 // User Logout
	    @PostMapping("/users/logout")
	    public UserStatus logUserOut(@Valid @RequestBody User user) {
	        List<User> users = userRepository.findAll();

	        for (User other : users) {
	            if (other.equals(user)) {
	                user.setLoggedIn(false);
	                userRepository.save(user);
	                return UserStatus.SUCCESS;
	            }
	        }

	        return UserStatus.FAILURE;
	    }

}
