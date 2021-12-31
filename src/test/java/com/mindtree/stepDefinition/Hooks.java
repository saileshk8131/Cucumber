package com.mindtree.stepDefinition;

import org.apache.log4j.Logger;

import com.mindtree.manager.WebDriverManager;
import com.mindtree.utility.Logs;

import io.cucumber.java.After;
import io.cucumber.java.Before;


/**This a class to implement hooks, it is executed before and after each scenario

 *
 */
public class Hooks extends WebDriverManager{
  WebDriverManager driverManager;
  Logs loggerUtil;
	Logger log;
	/**This method is called before each scenario, used to start driver
	 
	 */
	@Before
	public void startUp() {
		loggerUtil = new Logs();
		log = loggerUtil.createLog("Hooks.class");
		log.debug("Opening driver");
		driverManager = new WebDriverManager();
		driverManager.getDriver();
		log.info("Driver opened");
		driver.get(properties.getProperty("url"));
		log.debug("Opening URL");
	}
	
	/**This method is called after each scenario, used to close the driver
	 
	 */
	@After
	public void tearDown() {
		log.info("Driver closed");
		driver.close();
	}

}
