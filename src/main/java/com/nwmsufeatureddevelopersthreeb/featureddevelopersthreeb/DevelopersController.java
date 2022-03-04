/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

/**
 * @author s541906
 */
@CrossOrigin //(origins = "https://featureddevelopers3bfrontend.herokuapp.com/#/")
@RestController
public class DevelopersController {
  @Autowired private DevelopersService service;

  @Operation(
      summary = "To get one Developer randomly",
      description = "This display developers details on a random basis")
  // To get one Developer details Randomly
  @Scheduled(cron = "0 0 10 * * *", zone = "CST")
  @GetMapping("/developers/random")
  public Developers random() {
    return service.display();
  }

  @Operation(
      summary = "To get one Developer per day randomly",
      description =
          "This display developers details randomly once per day returned from /developers/random")
  // To get one developer details randomly once per day
   @GetMapping("/developers/randomshow")
 // @RequestMapping(value = "/developers/randomshow", method = RequestMethod.GET)
  public Developers show() {
    return service.getDee();
  }

  @Operation(
      summary = "To get list of all of Developers details",
      description = "This display list of all developers details")
  // To get list of all of Developers details
  @GetMapping("/developers/getall")
  public List<Developers> getall() {
    return service.listAll();
  }

  @Operation(
      summary = "To add developer details",
      description = "This will add list of all developers details")
  // To create new developers

  @PostMapping("/developers/create")
  public void create(@RequestBody Developers developer) {
    service.save(developer);
  }
   @Operation(
      summary = "To get list of all of Developers details by Id",
      description = "This display developers details by Id")
// To get developer details by Id

	// @GetMapping("/developers/getbyId/{developerId}")
	@RequestMapping(value = "/developers/getbyId/{developerId}", method = RequestMethod.GET)
	public ResponseEntity<Developers> getbyId(@PathVariable String developerId) {
		try {
			Developers developers = service.get(developerId);
			return new ResponseEntity<Developers>(developers, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Developers>(HttpStatus.NOT_FOUND);
		}
	}


  @Operation(
      summary = "To delete developer details",
      description = "This will delete list of all developers details")
  // To Delete Developers
  @DeleteMapping("/developers/delete/{developerId}")
  public void delete(@PathVariable String developerId) {
    service.delete(developerId);
  }

  @Operation(
      summary = "To update developer details",
      description = "This will update list of all developers details")
  // To update developers details

  @PutMapping("/developers/update/{developerId}")
  public ResponseEntity<Developers> update(
      @RequestBody Developers developers, @PathVariable String developerId) {
    try {
      Developers existDevelopers = service.get(developerId);
      if (developers.getDeveloperId() != null)
        existDevelopers.setDeveloperId(developers.getDeveloperId());
      service.save(existDevelopers);
      if (developers.getEmailaddress() != null)
        existDevelopers.setEmailaddress(developers.getEmailaddress());
      service.save(existDevelopers);
      if (developers.getFullName() != null) existDevelopers.setFullName(developers.getFullName());
      service.save(existDevelopers);
      if (developers.getGithuburl() != null)
        existDevelopers.setGithuburl(developers.getGithuburl());
      service.save(existDevelopers);
      if (developers.getGoals() != null) existDevelopers.setGoals(developers.getGoals());
      service.save(existDevelopers);
      if (developers.getImage() != null) existDevelopers.setImage(developers.getImage());
      service.save(existDevelopers);
      if (developers.getLinkedinurl() != null)
        existDevelopers.setLinkedinurl(developers.getLinkedinurl());
      service.save(existDevelopers);
      if (developers.getSkills() != null) existDevelopers.setSkills(developers.getSkills());
      service.save(existDevelopers);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
