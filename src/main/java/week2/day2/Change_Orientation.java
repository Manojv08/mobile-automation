package week2.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import base_functions.Base_methods;
import io.appium.java_client.android.AndroidDriver;

public class Change_Orientation {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("deviceName", "Redmi Note 7 Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Base_methods common = new Base_methods(driver);

		ScreenOrientation orientation = driver.getOrientation();
		System.out.println("Orientation : " + orientation);
		
		String mode = orientation.toString();
		System.out.println("Orientation mode : " + mode);
		
		driver.rotate(ScreenOrientation.LANDSCAPE);
		
		common.fill("xpath", "//android.widget.EditText[not(@text='Password')]", "rajkumar@testleaf.com");
		common.fill("xpath", "//android.widget.EditText[@text='Password']", "Leaf@123");
		common.click("xpath", "//android.widget.Button[@text='LOGIN']");
	
	}

}