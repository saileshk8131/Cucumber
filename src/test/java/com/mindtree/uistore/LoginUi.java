package com.mindtree.uistore;

import org.openqa.selenium.By;

public class LoginUi {
	
	public static By username = By.xpath("//input[@id='sso-login-email-input']");
	public static By password = By.xpath("//input[@id='sso-login-password-input']");
	public static By signin = By.xpath("//button[@class='sso-button']");
	public static By text = By.xpath("//div[contains(text(),'Your log in attempts has been unsuccessful. As a security measure, we’ve locked your account and you’re required to ')]");

}
