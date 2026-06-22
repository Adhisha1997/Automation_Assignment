package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.constant.ENV;

public class browserUtility {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = loggerUtility.getLogger(this.getClass());
	WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();

	}

	public browserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
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

		if (browserName.equalsIgnoreCase("chrome")) {
			if (isHeadless) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--headless=old");
				option.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(option));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			}
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else {
			System.err.print("Enter valid browser name !!!!!!! Enter Chrome or Edge..........");
		}
	}

	public void goToWebsite(String url) {
		logger.info("Launching the website");
		driver.get().get(url);
		logger.info("Website launched successfully");
	}

	public void manageWindow() {
		driver.get().manage().window().maximize();
	}

	public void click(By locator) {
		logger.info("Finding the element to be clicked" + locator);
		// WebElement element =driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		logger.info("Element clicked successfully" + locator);
	}

	public void radiobox_click(By locator) {
		logger.info("Finding the element to be clicked" + locator);
		// WebElement element =driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
		logger.info("Element clicked successfully" + locator);
	}
	
	public void clickElement(WebElement element) {
		logger.info("Finding the element to be clicked");

		element.click();
		logger.info("Element clicked successfully");
	}

	public void sendKeys(By locator, String text_to_Send) {
		logger.info("Finding the element to send key" + locator);

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(text_to_Send);
		logger.info("Element found and values added into the field successfully" + text_to_Send);
	}

	public void sendSpecialKeys(By locator, Keys specialKeys) {
		logger.info("Finding the element to send specialkey");
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		element.sendKeys(specialKeys);
		logger.info("Element found and special key entered successfully");
	}

	public void selectdropdown(By locator, String vissibleValue) {
		logger.info("Finding the element of dropdown" + locator);
		// WebElement element =new WebDriverWait(driver.get(),
		// Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Select select = new Select(element);
		select.selectByValue(vissibleValue);
		logger.info("Dropdown click and value selected :" + vissibleValue);
	}

	public String getVissibleText(By locator) {
		logger.info("Finding element for vissible text");
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}

	public List<String> getListOfVissibleText(By locator) {

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

		logger.info("Finding list of element for vissible text");
		List<WebElement> elements = driver.get().findElements(locator);
		List<String> VissibleTextList = new ArrayList<String>();
		for (WebElement webElement : elements) {
			VissibleTextList.add(webElement.getText());
		}
		logger.info("Found all the vissible text");
		return VissibleTextList;
	}

	public List<WebElement> getListOfElements(By locator) {

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

		logger.info("Finding list of all element");
		List<WebElement> allVissibleelements = driver.get().findElements(locator);
		logger.info("Found all the vissible elements");
		return allVissibleelements;
	}

	public boolean containAtLeastOneWord(String productName, String searchTextEntered) {
		String[] searchWord = searchTextEntered.toLowerCase().split("\\s+");
		logger.info("Entered search text is splited into words");
		for (String word : searchWord) {
			logger.info(
					"Checking if the product conatins any word that is present in the search text user have entered");
			if (productName.toLowerCase().contains(word)) {
				logger.info("Product contains atleast one word from the entered text");
				return true;
			}
		}
		logger.info("Product doesnot contains atleast one word from the entered text");
		return false;
	}

	public String properties(ENV env) {
		File fileprop = new File(
				System.getProperty("user.dir") + File.separator + "Config" + File.separator + env + ".properties");
		FileReader filereader = null;
		Properties prop = new Properties();
		try {
			filereader = new FileReader(fileprop);
			prop.load(filereader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String urlValue = prop.getProperty("URL");
		return urlValue;

	}

	public static String takeScreenshot(String name) {
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + name + "_"
				+ timestamp + ".png";
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
