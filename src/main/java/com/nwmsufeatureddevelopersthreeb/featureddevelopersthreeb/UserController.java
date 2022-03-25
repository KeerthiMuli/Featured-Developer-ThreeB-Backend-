package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;

import java.util.Base64;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
  @Autowired UserService service;

  // User Registration
  @RequestMapping(value = "/users/register", method = RequestMethod.POST)
  public UserStatus registerUser(@Valid @RequestBody User newUser) {
    List<User> users = service.listAll();
    String encodedString = Base64.getEncoder().encodeToString(newUser.getPassword().getBytes());
    newUser.setPassword(encodedString);
    String encodedString2 =
        Base64.getEncoder().encodeToString(newUser.getConfirmPassword().getBytes());
    newUser.setConfirmPassword(encodedString2);
    //  System.out.println("New user: " + newUser.toString());
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
}
