package com.browserstack.testcase;


import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.browserstack.pages.CapabilitiesPages;



public class BrowserstackTestCase {

	public static WebDriver driver;
	CapabilitiesPages cp;
	
	@BeforeClass
	public void setup() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aksanyal\\Documents\\Automation Setup 9 oct\\Automation Setup 9 oct\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.browserstack.com/automate/capabilities");

		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	@Parameters({"osname", "devicename"})
	public void tc1(String osname, String devicename) {
		cp = new CapabilitiesPages(driver);
		cp.clickOSDropDown();
		if(osname.equalsIgnoreCase("ios")) {
			
		}
		
		if(osname.equalsIgnoreCase("android")) {
			
			cp.selectAndroidOption();
		}
		
		
		List<WebElement> ls = driver.findElements(By.tagName("a"));
		
		Iterator<WebElement>itr = ls.iterator();
		

		
		while(itr.hasNext()) {
		
			try {
				
				if(itr.next().getAttribute("data-device-name").equalsIgnoreCase(devicename)) {
					itr.next().click();
				}
			}
			 catch (Exception e) {
				// TODO: handle exception
			}
	}
	
	}
	
}
