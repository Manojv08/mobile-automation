package week3.day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import base_functions.Base_methods;
import io.appium.java_client.android.AndroidDriver;

public class Context_Handles {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();

		// if App is not already installed, 2 capabilities needs to set
		// deviceName
		// App
		// optional
		// platform

		dc.setCapability("deviceName", "Redmi Note 7 Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Base_methods common = new Base_methods(driver);

		boolean appInstalled = driver.isAppInstalled("com.testleaf.leaforg");
		System.out.println("LeafOrg App is installed? : " + appInstalled);
		
		String currentContext = driver.getContext();
		System.out.println("Current Context: " + currentContext);
		
		Set<String> allContext = driver.getContextHandles();
		System.out.println("All Context : " + allContext);
		
		switchContext(driver);
		
		System.out.println("Current Context: " + driver.getContext());
		
		common.fill("xpath", "//input[@placeholder='Email']", "rajkumar@testleaf.com");
		common.fill("xpath", "//input[@placeholder='Password']", "Leaf@123");
		common.click("xpath", "//span[text()='Login']");

	}
	
	public static void switchContext(AndroidDriver<WebElement> driver) {
		
		Set<String> allContext = driver.getContextHandles();
		
		for (String eachContext : allContext) {
			if(eachContext.toLowerCase().trim().contains("webview"))
				driver.context(eachContext);
		}
		
	}

}