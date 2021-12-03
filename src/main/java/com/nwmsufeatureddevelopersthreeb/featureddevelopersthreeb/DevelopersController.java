/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
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
	
	 // To get one Developer Randomly
		@Scheduled(cron = "0 0/15 10 * * *", zone = "CST")
	      @GetMapping("/developers/random")
		public Developers random() {
			return service.display();
		}
        // To get one developer per day randomly
        @RequestMapping(value = "/developers/randomshow", method = RequestMethod.GET)
	public Developers show() {
		return service.getDee();

	}
	// To get list of all of Developers
	@GetMapping("/developers/getall")
	public List<Developers> getall() {
		return service.listAll();
	}

}
