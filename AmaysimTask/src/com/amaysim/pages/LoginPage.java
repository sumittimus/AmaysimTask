package com.amaysim.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;
	
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy (how=How.XPATH,using="//input[@id='username']")
	WebElement userName;
	
	@FindBy (how=How.ID,using="password")
	WebElement passWord;
	
	@FindBy (how=How.XPATH,using="//button[@class='arrow-next']")
	WebElement nextButton;
	
	@FindBy (how=How.LINK_TEXT,using="mobile plan")
	WebElement lnk_mobilePlan;
	
	public void login(String uname, String pwd) throws IOException{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		userName.sendKeys(uname);
		passWord.sendKeys(pwd);
		nextButton.click();
		
	}
	
}
