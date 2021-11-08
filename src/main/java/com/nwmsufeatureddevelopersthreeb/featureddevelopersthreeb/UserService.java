package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	 @Autowired
	UserRepository userRepository;
	public List<User>listAll(){
		return userRepository.findAll();
	}
	
   public User save(User user) {
	   return this.userRepository.save(user);
   }
	
   


}
