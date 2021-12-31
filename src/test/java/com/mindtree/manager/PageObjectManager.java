package com.mindtree.manager;

import com.mindtree.pageobject.FlightPage;
import com.mindtree.pageobject.HomePage;
import com.mindtree.pageobject.LoginPage;

/** This class is to manage the objects of different pages
 
 *
 */
public class PageObjectManager extends WebDriverManager{
	private HomePage homePage;
	private FlightPage flightPage;
	private LoginPage loginPage;
	
	/** Creates an instance of homepage
	 * @return homepage object
	
	 */
	public HomePage getHomePage() {
		return(homePage==null) ? homePage = new HomePage():homePage;
	}
	/** Creates an instance of flightpage
	 * @return flightpage object
	
	 */
	public FlightPage getFlightPage() {
		return(flightPage==null)?flightPage = new FlightPage() : flightPage;
	}
	/** Creates an instance of loginpage
	 * @return loginpage object
	
	 */
	public LoginPage getLoginPage() {
		return(loginPage==null)?loginPage=new LoginPage():loginPage;
	}
}
