package week1.homework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base_functions.Base_methods;
import io.appium.java_client.android.AndroidDriver;

public class TC006_Add_batch {

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

		common.fill("xpath", "//android.widget.EditText[not(@text='Password')]", "rajkumar@testleaf.com");
		common.fill("xpath", "//android.widget.EditText[@text='Password']", "Leaf@123");
		common.click("xpath", "//android.widget.Button[@text='LOGIN']");

//		Need to check for id which is not working
		common.click("xpath", "//android.view.View[@resource-id='tab-t0-2']");

//		Need to check for right arrow working
		common.click("xpath", "//android.view.View[@text='Batches']");
	
	}

}