package com.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CapabilitiesPages {
public static WebDriver driver;
	
	public CapabilitiesPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(id ="doc-os-trigger")
	WebElement os;
	
	@FindBy(linkText = "Android")
	WebElement android;
	
	
	
	public void clickOSDropDown() {
		clickWhenReady(os, 10);
		
	}
	
	public void selectAndroidOption() {
		clickWhenReady(android, 10);
	}
	
	public static void clickWhenReady(WebElement locator, int timeout) {
		try {
			WebElement element = null;
			System.out.println("Waiting for max:: " + timeout + " seconds for element to be clickable");
			
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(
					ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("Element clicked on the web page");	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}









