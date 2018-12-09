package com.google.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.base.BaseClass;
import com.google.pages.GmailHome;
import com.google.pages.LoginGmail;
import com.google.pages.Mail;

public class ComposeMailTest extends BaseClass{
	
	LoginGmail loginGmail;
	GmailHome gmailHome;
	Mail mail;
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginGmail = new LoginGmail();
		gmailHome = new GmailHome();
		mail = new Mail();
	}
	
//	@Test
//	public void loginGmailTest(){
//		loginGmail.login();
//		String actual = gmailHome.verifyGoogleAcc();
//		String expected = "Google Account: Sumit Paliwal  \n" + "(sumitpaliwal318@gmail.com)";
//		Assert.assertEquals(actual, expected, "Login again, you logged-in with invalid user");
//	}
	
	@Test
	public void composeMailTest() throws InterruptedException{
		loginGmail.login();
		gmailHome.composeMail();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}

}
