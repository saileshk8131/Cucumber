package com.mindtree.uistore;

import org.openqa.selenium.By;

public class HomeUi {

	public static By findFlights = By.xpath("//*[@id=\"flight-search-widget-super-div\"]/div/div[1]/div[2]/div/div/div[1]/div/div[2]/div[1]");
	public static By origin = By.xpath("//input[@id='home-origin-autocomplete-heatmap']");
	public static By destination = By.xpath("//input[@id='home-destination-autocomplete-heatmap']");
	public static By departDate = By.xpath("//input[@id='home-depart-date-heatmap']");
	public static By search = By.xpath("//button[contains(text(),' Search ')]");
	public static By oneway = By.xpath("(//div[@class='radiobuttons'])[2]/child::label[contains(text(),'One way')]");
	public static By confirm = By.xpath("//button[@class='calendar-button']");
	public static By login = By.xpath("//span[@id='loginModal']");
	
}
