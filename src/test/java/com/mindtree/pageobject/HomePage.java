package com.mindtree.pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.PageException;
import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.manager.WebDriverManager;
import com.mindtree.reusable.WebDriverHelper;
import com.mindtree.uistore.HomeUi;
import com.mindtree.utility.Logs;

/**
 * This class has all the keywords for homepage functionalities
 * 
 * @since 29/12/2021
 */

public class HomePage extends WebDriverManager {
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	public HomePage() {
		helper = new WebDriverHelper();
		loggerUtil = new Logs();
	}

	/**
	 * Verify the title of page
	 * 
	 * @return title
	 */
	public String verifyTitle() {
		log = loggerUtil.createLog("HomePage.java");
		log.debug("Verifying title");
		return driver.getTitle();
	}

	/**
	 * Click on flight button
	 * 
	 * @throws PageException
	 */
	public void clickOnFlights() throws PageException {
		try {
			log.debug("Waiting for flight button");
			helper.explicitWaitForVisibility(10, HomeUi.findFlights);
			log.debug("Clicking on flight button");
			helper.clickButton(HomeUi.findFlights);
		} catch (WebDriverHelperException e) {
			throw new PageException(e);
		}
	}

	/**
	 * Enter origin and destination
	 * 
	 * @param origin
	 * @param destination
	 * @throws PageException
	 */
	public void enterOriginDestination(String origin, String destination) throws PageException {
		try {
			helper.implicitWait(60);
			log.debug("Click on origin");
			helper.clickButton(HomeUi.origin);
			log.debug("Send origin city");
			helper.sendText(HomeUi.origin, origin);
			log.debug("Click enter key");
			helper.enterKey(HomeUi.origin);
			helper.applicationWait(500);
			log.debug("Click on destination");
			helper.clickButton(HomeUi.destination);
			log.debug("Send destination city");
			helper.sendText(HomeUi.destination, destination);
			helper.applicationWait(500);
			log.debug("Click on enter");
			helper.enterKey(HomeUi.destination);
		} catch (WebDriverHelperException e) {
			throw new PageException(e);
		}
	}

	/**
	 * Enter departure date and select one-way flight
	 * 
	 * @param date
	 * @throws PageException
	 */
	public void selectDepartDate(String date) throws PageException {
		try {
			helper.explicitWaitForVisibility(20, HomeUi.departDate);
			log.debug("Click on departure date");
			helper.clickButton(HomeUi.departDate);
			helper.clearText(HomeUi.departDate);
			log.debug("Set departure date");
			helper.sendText(HomeUi.departDate, date);
			log.debug("Click on one-way");
			helper.clickButton(HomeUi.oneway);
			log.debug("Click on confirm");
			helper.clickButton(HomeUi.confirm);
		} catch (WebDriverHelperException e) {
			throw new PageException(e);
		}
	}

	/**
	 * Click on search button
	 * 
	 * @throws PageException
	 */
	public void clickOnSearch() throws PageException {
		String city = "";

		try {
			helper.explicitWaitForVisibility(30, HomeUi.search);
			log.debug("Click on search");
			helper.clickButton(HomeUi.search);
		} catch (WebDriverHelperException e) {
			throw new PageException(e);
		}
	}

	/**
	 * Click on login
	 * 
	 * @throws PageException
	 */
	public void clickOnLogin() throws PageException {
		try {
			helper.explicitWaitForVisibility(10, HomeUi.login);
			log.debug("Click on login");
			helper.clickButton(HomeUi.login);
		} catch (WebDriverHelperException e) {
			throw new PageException(e);
		}
	}

}
