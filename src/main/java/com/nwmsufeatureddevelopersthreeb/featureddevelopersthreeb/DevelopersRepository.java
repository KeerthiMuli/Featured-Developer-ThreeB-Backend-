/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

/**
 *
 * @author s541906
 */
@Repository
public interface DevelopersRepository extends JpaRepository<Developers, String> {
     @Query(value ="SELECT * FROM Developers ORDER BY random() LIMIT 1", nativeQuery=true)
     public  Developers random();  

}
