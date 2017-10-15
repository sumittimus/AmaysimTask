package com.amaysim.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LandingPage {

	WebDriver driver;
	public LandingPage(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy (how=How.XPATH,using="//a[@class='close-reveal-modal']")
	WebElement PopUpWelcomeToAmaysim;
	
	@FindBy (how=How.XPATH,using="//div[@class='service-primary-heading']")
	WebElement UserName;
	
	@FindBy (how=How.XPATH,using="//span[contains(text(),'Settings')]")
	WebElement lnk_Settings;
	
	public void navigateToSettings(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Alert a = driver.switchTo().alert();
		//a.dismiss();
		//PopUpWelcomeToAmaysim.sendKeys(Keys.ESCAPE);
		UserName.click();
		lnk_Settings.click();
		
	}
	
	public void verifyUserName(String userDisplayName){
		String actualUserName = UserName.getText();
		if(actualUserName.equals(userDisplayName)){
			//System.out.println("User Loaded");
			Assert.assertTrue(true, "User Loaded");
		}else{
			System.out.println("Another User Loaded");
			Assert.fail("User Incorrect");
		}
	}
}
