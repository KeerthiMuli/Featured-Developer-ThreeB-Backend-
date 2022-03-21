package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.test.context.ContextConfiguration;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Suite.class)
@ContextConfiguration
@Suite.SuiteClasses({
  DeveloperControllerTests.class,
  // NewTestSuite.class
})
// @RunWith(SpringRunner.class)
// @SpringBootTest
public class FeatureddevelopersthreebTests {

  @Test
  public void contextLoads() {}
}
