/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*; 
import org.springframework.web.bind.annotation.*;
 

/**
 *
 * @author s541906
 */
@RestController
public class DevelopersController {
   @Autowired
    private DevelopersService service;
   //to get all the list of developers
   @CrossOrigin
   @GetMapping("/developers")
    public List<Developers> list() {
   return service.listAll();
}
    //To get list of developers by Id
   @GetMapping("/developers/{developerid}")
public ResponseEntity<Developers> get(@PathVariable String developerid) {
    try {   
        Developers developers = service.get(developerid);
        return new ResponseEntity<Developers>(developers, HttpStatus.OK);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<Developers>(HttpStatus.NOT_FOUND);
    }      
} 
// Create developers
  @CrossOrigin
@PostMapping("/developers")
public void add(@RequestBody Developers developer) {
    service.save(developer);
}
// Update developers
@PutMapping("/developers/{developerid}")
public ResponseEntity<?> update(@RequestBody Developers developers, @PathVariable String developerid) {
    try {
        Developers existDevelopers = service.get(developerid);
        service.save(developers);
        return new ResponseEntity<>(HttpStatus.OK);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }         
}
// Delete Developers
@DeleteMapping("/products/{developerid}")
public void delete(@PathVariable String developerid) {
    service.delete(developerid);
}

}
