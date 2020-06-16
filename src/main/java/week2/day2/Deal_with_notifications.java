package week2.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import base_functions.Base_methods;
import io.appium.java_client.android.AndroidDriver;

public class Deal_with_notifications {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("appPackage", "com.miui.home");
		dc.setCapability("appActivity", "com.miui.home.launcher.Launcher");
		dc.setCapability("deviceName", "Redmi Note 7 Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);
		dc.setCapability("automationName", "UiAutomator2");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Base_methods common = new Base_methods(driver);

		// to open notifications bar in android phone
		driver.openNotifications();
		
		// To click first notification
		common.click("xpath", "(//android.widget.ScrollView/*)[1]");

		common.fill("id", "com.whatsapp:id/entry", "Via Program - Manoj");

		common.click("accessibility id", "Send");

	}

}
