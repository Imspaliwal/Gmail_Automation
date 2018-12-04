package com.google.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.base.BaseClass;
import com.google.pages.LoginGmail;

public class LoginTest extends BaseClass{
	
	LoginGmail loginGmail;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginGmail = new LoginGmail();
	}
	
	@Test
	public void loginGmailTest(){
		loginGmail.login();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}

}
