package week2.homework;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import base_functions.Base_methods;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class TC015_WheelPicker_VodQA {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("deviceName", "Redmi Note 7 Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "com.vodqareactnative");
		dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Base_methods common = new Base_methods(driver);

		boolean appInstalled = driver.isAppInstalled("com.vodqareactnative");
		System.out.println("vodQA App is installed? : " + appInstalled);

		common.clear_and_fill("accessibility id", "username", "admin");
		common.clear_and_fill("accessibility id", "password", "admin");
		common.click("accessibility id", "login");

//		Need to check for id which is not working
		common.click("xpath", "//android.widget.TextView[@content-desc='wheelPicker']");
		
		WebElement longpressele = common.waitForElement("accessibility id", "longpress");
		
		new TouchAction<>(driver)
		.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(longpressele)).withDuration(Duration.ofSeconds(2)))
		.perform();	
					
		String successmsg = common.fetch_text("id", "android:id/message");
		
		System.out.println(successmsg);
	}

}