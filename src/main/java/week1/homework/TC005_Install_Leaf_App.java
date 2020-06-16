package week1.homework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TC005_Install_Leaf_App {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();

		// if App is not already installed, 2 capabilities needs to set
		// deviceName
		// App
		// optional
		// platform

		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("platformVersion", "9.0");
// 		for installing app alone
		dc.setCapability("app", "/Users/manoj.v/Documents/Appium/Materials/leaforg.apk");
		dc.setCapability("udid", "emulator-5554");
//		dc.setCapability("appPackage", "com.testleaf.leaforg");
//		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);

		boolean appInstalled = driver.isAppInstalled("com.testleaf.leaforg");
		System.out.println("LeafOrg App is installed? : " + appInstalled);

		WebElement email = driver.findElementByXPath("(//android.widget.EditText)[1]");
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys("rajkumar@testleaf.com");
		
		WebElement password = driver.findElementByXPath("(//android.widget.EditText)[2]");
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("Leaf@123");
		
		driver.findElementByXPath("//android.widget.Button[@text='LOGIN']").click();
		
	}

}
