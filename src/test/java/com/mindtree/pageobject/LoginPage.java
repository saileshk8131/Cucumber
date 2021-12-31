package com.mindtree.pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.PageException;
import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;
import com.mindtree.uistore.LoginUi;
import com.mindtree.utility.Logs;

/**
 * This class contains the keywords for all functionalities performed in
 * loginpage
 * 
 * @since 29/12/2021
 */
public class LoginPage {
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;

	public LoginPage() {
		helper = new WebDriverHelper();
		loggerUtil = new Logs();
	}

	/**
	 * This method is to enter username
	 * 
	 * @param username
	 * @throws PageException
	 */
	public void enterName(String username) throws PageException {
		try {
			log = loggerUtil.createLog("LoginPage.java");
			log.debug("Sending username");
			helper.sendText(LoginUi.username, username);
		} catch (WebDriverHelperException e) {
			throw new PageException(e);
		}
	}

	/**
	 * This method is to enter password
	 * 
	 * @param password
	 * @throws PageException
	 */
	public void enterPassword(String password) throws PageException {
		try {
			log.debug("Sending password");
			helper.sendText(LoginUi.password, password);
		} catch (WebDriverHelperException e) {
			throw new PageException(e);
		}
	}

	/**
	 * This method is to clickon signin
	 * 
	 * @throws PageException
	 */
	public void clickOnSignin() throws PageException {
		try {
			log.debug("Click on signin");
			helper.clickButton(LoginUi.signin);
		} catch (WebDriverHelperException e) {
			throw new PageException(e);
		}
	}

	/**
	 * This method is to return the error message,if present
	 * 
	 * @return text
	 * @throws PageException
	 */
	public String errorMessage() throws PageException {
		String text = "";
		try {
			helper.implicitWait(60);
			helper.explicitWaitForVisibility(60, LoginUi.text);
			log.debug("Getting error message");
			text = helper.getText(LoginUi.text);
		} catch (WebDriverHelperException e) {
			throw new PageException(e);
		}
		return text;
	}

}
