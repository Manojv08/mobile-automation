package week1.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TC004_Launch_Emulator_App {

	public static void main(String[] args) throws MalformedURLException {
		// Set Desired Capabilities
		DesiredCapabilities dc = new DesiredCapabilities();
		// if app already installed, 3 capabilities needs to set
				// appPackage
				// appActivity
				// deviceName
		// optional
				// platform

		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9.0");
		dc.setCapability("automationName", "UiAutomator2");
//		dc.setCapability("noReset", true);

//		dc.setCapability("appPackage", "com.google.android.apps.messaging");
//		dc.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
		
		dc.setCapability("appPackage", "com.google.android.apps.photos");
		dc.setCapability("appActivity", "com.google.android.apps.photos.home.HomeActivity");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		WebElement firstphoto = driver.findElementByAccessibilityId("Photo taken on May 31, 2020 3:32:16 PM");
		wait.until(ExpectedConditions.visibilityOf(firstphoto));
		firstphoto.click();

	}

}
