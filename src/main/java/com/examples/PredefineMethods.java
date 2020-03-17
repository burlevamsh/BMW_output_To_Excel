package com.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PredefineMethods {
	WebDriver driver;
	
	public PredefineMethods(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	WebElement usernameElement;
	@FindBy(name = "password")
	WebElement passwordElement;
	@FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")
	WebElement btnElement;
	
	
	public void setUserName(String userName) {
		usernameElement.sendKeys(userName);
	}

	public void setPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void submitLoginForm() {
		btnElement.submit();
	}

	
	
	
}
