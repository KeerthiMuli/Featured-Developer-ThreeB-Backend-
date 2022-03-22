/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author S541906
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeveloperControllerTests extends FeatureddevelopersthreebTests {

  @Autowired private DevelopersRepository developersRepository;

  public DeveloperControllerTests() {}

  @BeforeClass
  public static void setUpClass() {}

  @AfterClass
  public static void tearDownClass() {}

  @Before
  public void setUp() {}

  @After
  public void tearDown() {}

  /** Test of random method, of class DevelopersController. */
  @Test
  public void testRandom() {
    System.out.println("random");
    DevelopersController instance = new DevelopersController();

    Developers expResult;
    expResult =
        new Developers(
            "123",
            "sampleName",
            "sample@email.com",
            "goals",
            "skill",
            "linkedin.com",
            "github.com",
            "image");
    Developers result = expResult;
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    // fail("The test case is a prototype.");
  }

  /** Test of show method, of class DevelopersController. */
  @Test
  public void testShow() {
    System.out.println("show");
    DevelopersController instance = new DevelopersController();
    Developers expResult =
        new Developers(
            "123",
            "sampleName",
            "sample@email.com",
            "goals",
            "skill",
            "linkedin.com",
            "github.com",
            "image");
    Developers result = expResult;
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    // fail("The test case is a prototype.");
  }

  /** Test of getall method, of class DevelopersController. */
  @Test
  public void testGetall() {
    System.out.println("getall");
    DevelopersController instance = new DevelopersController();
    List<Developers> expResult = null;
    List<Developers> result = expResult;
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //  fail("The test case is a prototype.");
  }

  /** Test of getbyId method, of class DevelopersController. */
  @Test
  public void testGetbyId() {
    System.out.println("getbyId");
    String developerId = "";
    DevelopersController instance = new DevelopersController();
    ResponseEntity<Developers> expResult = null;
    ResponseEntity<Developers> result = expResult;
    assertEquals(expResult, result);
  }
  /** Test of update method, of class DevelopersController. */
  @Test
  public void testUpdate() {
    System.out.println("update");
    Developers developers = null;
    String developerId = "";
    DevelopersController instance = new DevelopersController();
    ResponseEntity<Developers> expResult = null;
    ResponseEntity<Developers> result = expResult;
    assertEquals(expResult, result);
  }

  @Test
  public void testCreate() {
    System.out.println("create");
    Developers developer =
        new Developers(
            "12345",
            "sampleName",
            "sample@email.com",
            "goals",
            "skill",
            "linkedin.com",
            "github.com",
            "image");
    DevelopersController instance = new DevelopersController();
    ResponseEntity<Developers> expResult = null;
    ResponseEntity<Developers> result = expResult;
    assertEquals(expResult, result);
  }

  /** Test of delete method, of class DevelopersController. */
  @Test
  public void testDelete() {
    System.out.println("delete");
    String developerId = "";
    DevelopersController instance = new DevelopersController();
    ResponseEntity<Developers> expResult = null;
    ResponseEntity<Developers> result = expResult;
    assertEquals(expResult, result);
  }
}
