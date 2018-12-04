package com.google.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.base.BaseClass;

public class LoginGmail extends BaseClass {
	
	/**
	 * Google login web elements
	 */

	@FindBy(linkText="Gmail")
	public WebElement gamilLink;
	
	@FindBy(linkText="Sign in")
	public WebElement signInLink;
	
	@FindBy(xpath="//input[@type='email']")
	public WebElement email;
	
	@FindBy(id="identifierNext")
	public WebElement nextButton;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(id="passwordNext")
	public WebElement nextSubmit;
	
	//initiate web elements
	public LoginGmail(){
		PageFactory.initElements(driver, this);
	}
	
	
	//login method
	
	public GmailHome login() {
		signInLink.click();
		email.sendKeys("sumitpaliwal318");
		nextButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(password)));
		
		password.sendKeys("19938109597386");
		nextSubmit.click();
		
		return new GmailHome();
	}
}
