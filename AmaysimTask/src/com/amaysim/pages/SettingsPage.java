package com.amaysim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class SettingsPage {

	WebDriver driver;
	
	public SettingsPage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(how=How.LINK_TEXT,using="Prepaid, BPay")
	WebElement paymentType;
	
	
	public void verifyPaymentMode(String mode){
		String actualMode = paymentType.getText();
		if(actualMode.equals(mode)){
			Assert.assertTrue(true);
		}else{
			Assert.fail("Payment Mode different");
		}
		
	}
}
