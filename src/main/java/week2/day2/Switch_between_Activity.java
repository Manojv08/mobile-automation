package week2.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import base_functions.Base_methods;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class Switch_between_Activity {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		// if App is already installed, 3 capabilities needs to set
					// appPackage
					// appActivity
					// deviceName
		//optional
					//platform

		dc.setCapability("appPackage", "com.whatsapp");
		dc.setCapability("appActivity", "com.whatsapp.HomeActivity");
		dc.setCapability("deviceName", "Redmi Note 7 Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);
		dc.setCapability("automationName", "UiAutomator2");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Base_methods common = new Base_methods(driver);
		
		common.click("xpath", "//android.widget.TextView[@text='RJ']");
		
		common.fill("id", "com.whatsapp:id/entry", "Via Program - Manoj");
		
		// Switch to Another App using Activity
		Activity act = new Activity("com.android.mms", "com.android.mms.ui.MmsTabActivity");
		driver.startActivity(act);
		
		common.click("xpath", "(//android.view.ViewGroup)[2]");
		
//		Need to research on this one and update
		act.setStopApp(true);
		
		// Switch back to Whatsapp
		
		Activity act1 = new Activity("com.whatsapp", "com.whatsapp.HomeActivity");
		driver.startActivity(act1);
	}

}
