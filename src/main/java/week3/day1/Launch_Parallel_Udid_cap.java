package week3.day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import base_functions.Base_methods;
import io.appium.java_client.android.AndroidDriver;

public class Launch_Parallel_Udid_cap {

	@Test
	public static void learn_udid_capability() throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("deviceName", "Redmi Note 7 Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("udid", "192.168.1.2:5555");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Base_methods common = new Base_methods(driver);

		boolean appInstalled = driver.isAppInstalled("com.testleaf.leaforg");
		System.out.println("LeafOrg App is installed? : " + appInstalled);

		common.fill("xpath", "//android.widget.EditText[not(@text='Password')]", "rajkumar@testleaf.com");
		common.fill("xpath", "//android.widget.EditText[@text='Password']", "Leaf@123");
		common.click("xpath", "//android.widget.Button[@text='LOGIN']");
	
	}

}