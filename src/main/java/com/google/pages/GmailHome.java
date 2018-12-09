package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath="//div[@class='T-I J-J5-Ji T-I-KE L3']")
	public WebElement compose;
	
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
	
	// compose mail web elements
	
	@FindBy(xpath="//td//img[2]") //css=img[id=':mz']
	public WebElement fullScreen;
	
	@FindBy(xpath="//img[@id=':p1']") //css=textarea[id=':qd']
	public WebElement minimize;
	
	@FindBy(xpath="//td//img[3]")
	public WebElement saveAndClose;
	
	@FindBy(className="vO")
	public WebElement recipients; 
	
	@FindBy(className="aoT")
	public WebElement subject;
	
	@FindBy(css=".Am.Al.editable.LW-avf") 
	public WebElement msgBody;
	
	@FindBy(xpath="//div[text()='Send']")
	public WebElement send;
	
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
	
	// this method will compose mail and send it to recipients
	public Mail composeMail() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(compose));
		
		compose.click();
		fullScreen.click();
		recipients.sendKeys("paliwal.sumit31@gmail.com");
		subject.sendKeys("Gmail_Automation - Demo Mail");
		msgBody.click();
		msgBody.sendKeys("This is test mail");
		
//		driver.findElement(By.cssSelector(".Am.Al.editable.LW-avf")).click();
//		driver.findElement(By.cssSelector(".Am.Al.editable.LW-avf")).sendKeys("This is an auto-generated mail");
		
		send.click();
		
		Thread.sleep(60000);
		
		return new Mail();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
