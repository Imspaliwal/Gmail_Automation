package com.google.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.base.BaseClass;

public class GmailHome extends BaseClass{
	
	/**
	 * Web elements represents Gmail Home
	 */
	
	@FindBy(xpath="//a[@class='gb_b gb_fb gb_R']")
	public WebElement googleAcc;
	
	@FindBy(id="gb_71")
	public WebElement signOut;
	
	@FindBy(className="gb_za gb_cg gb_0e gb_Hb")
	public WebElement addAcc;
	
	@FindBy(className="T-I J-J5-Ji T-I-KE L3")
	public WebElement composeMail;
	
	@FindBy(xpath="//div[contains(@class,'TN bzz aHS-bnt')]")
	public WebElement inbox;
	
	@FindBy(xpath="//div[contains(@class,'TN bzz aHS-bnu')]")
	public WebElement sent;	

	@FindBy(xpath="//div[@class='aAy J-KU-KO aIf-aLe']")
	public WebElement primary;
	
	@FindBy(xpath="//div[@class='aAy aKe-aLe aE2']")
	public WebElement social;
	
	@FindBy(xpath="//div[@class='aAy aJi-aLe aE2']")
	public WebElement promotions;
	
	
	//Initialize web elements 
	public GmailHome(){
		PageFactory.initElements(driver, this);
	}
	
	// method to verify user is available in Gmail Home
	public String verifyGoogleAcc(){
		
		Actions account = new Actions(driver);
		account.moveToElement(googleAcc).build().perform();
		
		String accInfo = googleAcc.getAttribute("aria-label");

		return accInfo;
	}
}
	
