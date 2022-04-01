package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;
import io.swagger.v3.oas.annotations.Operation;
import java.util.Base64;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserController {
	 @Autowired
	    UserService service	; 
         @Operation(
      summary = "To get the user registered",
      description = "This will allow the users to get registered")
    	 // User Registration
	 @RequestMapping(value = "/users/register", method = RequestMethod.POST)
	    public UserStatus registerUser(@Valid @RequestBody User newUser) {
	       List<User> users = service.listAll();
	       String encodedString = Base64.getEncoder().encodeToString(newUser.getPassword().getBytes());
	       newUser.setPassword(encodedString);
	       String encodedString2 = Base64.getEncoder().encodeToString(newUser.getConfirmPassword().getBytes());
	       newUser.setConfirmPassword(encodedString2);
	        System.out.println("New user: " + newUser.toString());
	        for (User user : users) {     	
	            System.out.println("Registered user: " + newUser.toString());          
	            if (user.getUsername().equals(newUser.getUsername())) {
	                System.out.println("User Already exists!");
	                return UserStatus.USER_ALREADY_EXISTS;
	            }    
	        }
	if (!(newUser.getPassword().equals(newUser.getConfirmPassword()))) {
	     return UserStatus.PASSWORD_DOES_NOT_MATCH;
	      }
	            service.save(newUser);
		        return UserStatus.SUCCESS;
}
               @Operation(
      summary = "To get the user login",
      description = "This will allow the users to get login")
	//User Login
	    @PostMapping("/users/login")
	    public UserStatus loginUser(@Valid @RequestBody User user) {
	        List<User> users = service.listAll();
	        String encodedString = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
	  	      user.setPassword(encodedString);
	        for (User other : users) {
	       	 if (other.getUsername().equals(user.getUsername())&& (other.getPassword().equals(user.getPassword()))) {
	                user.setLoggedIn(true);
	                service.save(user);
	                return UserStatus.SUCCESS;
	            }
	        }

	        return UserStatus.FAILURE;
	    }
               @Operation(
      summary = "To get the user logout",
      description = "This will allow the users to logout")
	 // User Logout
	    @PostMapping("/users/logout")
	    public UserStatus logUserOut(@Valid @RequestBody User user) {
	        List<User> users = service.listAll();
	       String encodedString = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
	  	    user.setPassword(encodedString);
	        for (User other : users) {
	            if (other.equals(user)) {
	                user.setLoggedIn(false);
	                service.save(user);
	                return UserStatus.SUCCESS;
	            }
	        }
	        return UserStatus.FAILURE;
	    }      
         
}
