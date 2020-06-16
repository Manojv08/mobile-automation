package week2.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import base_functions.Base_methods;
import io.appium.java_client.android.AndroidDriver;

public class Mobile_Browser_launch {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("deviceName", "Redmi Note 7 Pro");
		dc.setCapability("browserName", "chrome");
		dc.setCapability("noReset", true);

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Base_methods common = new Base_methods(driver);
		
		driver.get("http://www.leafground.com/");
		
		common.click("xpath", "//*[@id=\"post-153\"]/div[2]/div/ul/li[5]/a");
		
		Select dd = new Select(common.waitForElement("xpath", "//select[@id='dropdown1']"));
		dd.selectByVisibleText("Selenium");
	
	}

}