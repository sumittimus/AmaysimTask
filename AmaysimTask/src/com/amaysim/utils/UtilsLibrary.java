package com.amaysim.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.amaysim.resources.constants;



public class UtilsLibrary {

	static Properties prop;
	
	
	public static String fetchProperty(String propName) throws IOException{
		
		String propValue;
		try {
			FileInputStream fs = new FileInputStream(constants.PROPERTIES_FILE);
			prop.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		propValue = prop.getProperty(propName);
		
		return propValue;
	}
	
	// Function for launching browser 
	public static WebDriver launchBrowser(String brwName, String url){
		WebDriver driver = null;
		
		if(brwName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", constants.GECKO_PATH);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else if(brwName.equals("Chrome")){
			//Chrome not implemented
			driver = new ChromeDriver();
		}else if(brwName.equals("IE")){
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		
		return driver;
	}
	
}
