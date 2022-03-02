/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

/**
 * @author s541906
 */
@CrossOrigin
@RestController
public class DevelopersController {
  @Autowired private DevelopersService service;

  @Operation(
      summary = "To get one Developer randomly",
      description = "This display developers details on a random basis")
  // To get one Developer details Randomly
  @Scheduled(cron = "0 25 12 ? * *", zone = "CST")
  @GetMapping("/developers/random")
  public Developers random() {
    return service.display();
  }

  @Operation(
      summary = "To get one Developer per day randomly",
      description =
          "This display developers details randomly once per day returned from /developers/random")
  // To get one developer details randomly once per day
  @RequestMapping(value = "/developers/randomshow", method = RequestMethod.GET)
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
}
