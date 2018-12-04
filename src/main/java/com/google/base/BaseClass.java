package com.google.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public BaseClass(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\eclipse-workspace\\Gmail_Automation\\src\\main\\java\\com\\google\\config\\config.properties");
			prop.load(ip);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browserName");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
				System.setProperty("webdriver.firefox.marionette.driver", "C:\\Python27\\Scripts\\geckodriver");
				driver = new FirefoxDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
