/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
 

/**
 *
 * @author s541906
 */
@CrossOrigin
@RestController
public class DevelopersController {

   @Autowired
    private DevelopersService service;
   //To get one Developer Randomly
 
 @GetMapping("/developers/random")
   public Developers random() {
    return service.findRandom() ;
}
 //  @GetMapping("/developers/random2")
 //  public Developers random2() {
	   
 // return service.findRandom2();
//}
      
 // To get list of all of developers
 @GetMapping("/developers/getall")
 public List<Developers> getall(){
	 return service.listAll();
 }
 
    //To get list of developers by Id

   @GetMapping("/developers/getbyId/{developerId}")
public ResponseEntity<Developers> getbyId(@PathVariable String developerId) {
    try {   
        Developers developers = service.get(developerId);
        return new ResponseEntity<Developers>(developers, HttpStatus.OK);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<Developers>(HttpStatus.NOT_FOUND);
    }      
} 
// Create developers

@PostMapping("/developers/create")

public void create(@RequestBody Developers developer) {
    service.save(developer);
}
// Update developers

@PutMapping("/developers/update/{developerid}")
public ResponseEntity<?> update(@RequestBody Developers developers, @PathVariable String developerId) {
    try {
        Developers existDevelopers = service.get(developerId);
        service.save(developers);
        return new ResponseEntity<>(HttpStatus.OK);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }         
}
// Delete Developers

@DeleteMapping("/developers/delete/{developerId}")
public void delete(@PathVariable String developerId) {
    service.delete(developerId);
}

}
