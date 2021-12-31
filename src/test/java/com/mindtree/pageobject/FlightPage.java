package com.mindtree.pageobject;

import org.apache.log4j.Logger;

import com.mindtree.exceptions.PageException;
import com.mindtree.exceptions.WebDriverHelperException;
import com.mindtree.reusable.WebDriverHelper;
import com.mindtree.uistore.FlightUi;
import com.mindtree.utility.Logs;

/** This class has all the keywords for flightpage functionalities

 * @since 29/12/2021
 */
public class FlightPage {
	WebDriverHelper helper;
	Logs loggerUtil;
	Logger log;
	public FlightPage() {
		helper = new WebDriverHelper();
		loggerUtil = new Logs();
	}
	
	/** Verify the cities selected in homepage
	 * @return city names
	 * @throws PageException
	 */
	public String checkCity() throws PageException {
		log = loggerUtil.createLog("FlightPage.java");
		String city;
		try {
			log.debug("Getting City names for confirmation");
			city = helper.getText(FlightUi.selectedCity);
		} catch (WebDriverHelperException e) {
			throw new PageException(e);
		}
		return city;
	}

}
