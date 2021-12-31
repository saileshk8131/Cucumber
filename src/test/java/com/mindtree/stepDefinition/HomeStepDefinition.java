package com.mindtree.stepDefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.mindtree.exceptions.PageException;
import com.mindtree.manager.PageObjectManager;
import com.mindtree.pageobject.FlightPage;
import com.mindtree.pageobject.HomePage;
import com.mindtree.utility.Logs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


/** This class has stepdefinition for homepage feature file
 
 *
 */

public class HomeStepDefinition {
	PageObjectManager pageManager;
	HomePage homepage;
	FlightPage flightPage;
	Logs loggerUtil;
	Logger log;

	/** Verify user is on homepage
	
	 */
	@Given("^I am on the home page$")
	public void i_am_on_the_home_page() {
		loggerUtil = new Logs();
		log = loggerUtil.createLog("HomeStepDefinition.class");
		log.debug("Verifying title");
		pageManager = new PageObjectManager();
		homepage = pageManager.getHomePage();
		String title = homepage.verifyTitle();
		Assert.assertEquals("AirAsia India - Book Your Flights and Explore India", title);
		log.info("Title verified");
	}

	/** Click on flight button
	
	 */
	@When("^I click on flight$")
	public void i_click_on_flight() {
		try {
			log.debug("Clicking on flights button");
			homepage.clickOnFlights();
		} catch (PageException e) {
			log.error(e.getLocalizedMessage());
		}

	}

	/** Verify title
	 
	 */
	@Then("^I should be redirected to the flight booking page$")
	public void i_should_be_redirected_to_the_flight_booking_page() {
		log.debug("Verifying title");
		String title = homepage.verifyTitle();
		Assert.assertEquals("Book Flights, Hotels & Activities Online | AirAsia", title);
		log.info("Title verified");
	}

	/** Enter origin and destination cities
	 * @param origin
	 * @param destination
	 */
	@Then("^I should be able to enter origin \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_should_be_able_to_enter_origin_and(String origin, String destination) {
		try {
			log.debug("Entering origin and destination");
			homepage.enterOriginDestination(origin, destination);
		} catch (PageException e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/** Enter departure date
	 
	 * @param date
	 */
	@Then("^I should be able to enter depart date \"([^\"]*)\"$")
	public void i_should_be_able_to_enter_depart_date(String date) {
		try {
			log.debug("Entering departure date");
			homepage.selectDepartDate(date);
		} catch (PageException e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/** Verify cities
	 
	 */
//	@Then("^I should be able to book flight$")
//	public void i_should_be_able_to_book_flight() {
//
//		
//	}
	
	@Then("^I should be able to book flight from \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_should_be_able_to_book_flight_from_and(String origin, String destination) {
		flightPage = pageManager.getFlightPage();
		try {
			log.debug("Clicking on search");
			homepage.clickOnSearch();
			log.debug("Verifying the cities");
			String city = flightPage.checkCity();
			Assert.assertEquals(origin+" to "+destination, city);
			log.info("Cities matched");
		} catch (PageException e) {
			log.error(e.getLocalizedMessage());
		}
	}
}
