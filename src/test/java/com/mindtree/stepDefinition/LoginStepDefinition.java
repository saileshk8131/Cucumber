package com.mindtree.stepDefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import com.mindtree.exceptions.PageException;
import com.mindtree.manager.PageObjectManager;
import com.mindtree.pageobject.HomePage;
import com.mindtree.pageobject.LoginPage;
import com.mindtree.utility.Logs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


/**
 * This is the implementation of login feature file having definition of all the
 * steps
 
 */
public class LoginStepDefinition {
	PageObjectManager pageManager;
	HomePage homePage;
	LoginPage loginPage;
	Logs loggerUtil;
	Logger log;

	/**
	 * This method is a step definition to click on loginpage
	 
	 */
	@When("^I click on login$")
	public void i_click_on_login() {
		pageManager = new PageObjectManager();
		loggerUtil = new Logs();
		log = loggerUtil.createLog("LoginStepDefinition.class");
		log.debug("Clicking on login");
		homePage = pageManager.getHomePage();
		try {
			homePage.clickOnLogin();
		} catch (PageException e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * This method is to enter username
	
	 * @param username
	 */
	@Then("^I should be able to enter username \"([^\"]*)\"$")
	public void i_should_be_able_to_enter_username(String username) {
		loginPage = pageManager.getLoginPage();
		try {
			log.debug("Entering username");
			loginPage.enterName(username);
		} catch (PageException e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * This method is to enter password
	
	 * @param password
	 */
	@Then("^I should be able to enter password \"([^\"]*)\"$")
	public void i_should_be_able_to_enter_password(String password) {
		try {
			log.debug("Entering password");
			loginPage.enterPassword(password);
		} catch (PageException e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * This method is to click on signin button
	 */
	@Then("^I should be able to click on signin$")
	public void i_should_be_able_to_click_on_signin() {
		try {
			log.debug("Clicking on signin");
			loginPage.clickOnSignin();
		} catch (PageException e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * This method is to verify the error message
	 * @since 21/09/2019
	 */
	@Then("^I should be able to login$")
	public void i_should_be_able_to_login() {
		String message = "";
		try {
			message = loginPage.errorMessage();
		} catch (PageException e) {
			log.error(e.getLocalizedMessage());
		}
		Assert.assertEquals("Your log in attempts has been unsuccessful. "
				+ "As a security measure, we’ve locked your account and" + " you’re required to reset your password.",
				message);
	}

}
