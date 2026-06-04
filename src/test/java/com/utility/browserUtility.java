package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.constant.ENV;

public  class browserUtility {

	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}


	public browserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); 
	}
	
//	public browserUtility(String browserName) {
//		if(browserName.equalsIgnoreCase("chrome")) {
//			driver.set(new ChromeDriver());
//		} else if(browserName.equalsIgnoreCase("edge")) {
//			driver.set(new EdgeDriver());
//		}else {
//			System.err.print("Enter valid browser name !!!!!!! Enter Chrome or Edge..........");
//		}
//	}
	
	
	public browserUtility(String browserName, boolean isHeadless) {
		if(browserName.equalsIgnoreCase("chrome")) {
			if(isHeadless) {
			ChromeOptions option = new  ChromeOptions();
			option.addArguments("--headless=old");
			option.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(option));
			}
			else {
			driver.set(new ChromeDriver());
			}
		} 
		
		else if(browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}else {
			System.err.print("Enter valid browser name !!!!!!! Enter Chrome or Edge..........");
		}
	}
	
	public void goToWebsite(String url) {
		driver.get().get(url);
	}
	
	public void manageWindow() {
		driver.get().manage().window().maximize();
	}
	
	public void click(By locator) {
		WebElement element =driver.get().findElement(locator);
		element.click();
	}
	
	public void sendKeys(By locator,String text_to_Send) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text_to_Send);
	}
	
	public String getVissibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}
	
	
	public String properties(ENV env)  {
		File fileprop = new File(System.getProperty("user.dir")+"\\Config\\"+env+".properties");
		FileReader filereader = null;
		Properties prop = new Properties();
		try {
			filereader = new FileReader(fileprop);
			prop.load(filereader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String urlValue=prop.getProperty("URL");
		return urlValue;
		
	}
	
	public static String takeScreenshot(String name) {
	String timestamp= LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
		
		
		
		TakesScreenshot screenshot = (TakesScreenshot)driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"//Screenshots//"+name+"_"+timestamp+".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
