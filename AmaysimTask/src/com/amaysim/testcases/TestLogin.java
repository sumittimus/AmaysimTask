package com.amaysim.testcases;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amaysim.pages.LandingPage;
import com.amaysim.pages.LoginPage;
import com.amaysim.pages.SettingsPage;
import com.amaysim.utils.UtilsLibrary;


public class TestLogin {

	static Properties prop;
	UtilsLibrary obj = new UtilsLibrary();
	
	
	@Test
	public void checkLogin() throws IOException{
		WebDriver driver = UtilsLibrary.launchBrowser("Firefox", "https://accounts.amaysim.com.au/");
		
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		SettingsPage settingsPage = PageFactory.initElements(driver, SettingsPage.class);
		
		loginPage.login("0468827174", "theHoff34");	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String pageTitle = driver.getTitle();
		
		if(pageTitle.equals("My amaysim")){
			
			Assert.assertTrue(true, "My Amaysim Landing page displayed");
		}else{
			
			Assert.fail("Incorrect Browser Loaded");;
		}
		
		
		landingPage.navigateToSettings();
		//Verify if the user name is correct
		landingPage.verifyUserName("D-Test1");
		
		settingsPage.verifyPaymentMode("Prepaid, BPay");
		
	}
	
}
