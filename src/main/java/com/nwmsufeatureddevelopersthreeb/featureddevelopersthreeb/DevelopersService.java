/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;


/**
 *
 * @author s541906
 */

@Service
@Transactional
public class DevelopersService {
	@Autowired
	private DevelopersRepository devlopersRepository;
	Set<Developers> dev = new HashSet<Developers>();
	public Developers dee;
     public Developers  findRandom() {
		
		return devlopersRepository.random();
		
	}

	public List<Developers>listAll(){
		return devlopersRepository.findAll();
	}
    public Developers save(Developers developer) {
		 return devlopersRepository.save(developer);
	}


}
