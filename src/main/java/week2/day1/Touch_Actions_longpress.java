package week2.day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base_functions.Base_methods;
import io.appium.java_client.MobileSelector;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Touch_Actions_longpress {

	public static void main(String[] args) throws MalformedURLException {
		// Learn touch actions

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("appPackage", "com.whatsapp");
		dc.setCapability("appActivity", "com.whatsapp.HomeActivity");
		dc.setCapability("deviceName", "Redmi Note 7 Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);
		dc.setCapability("automationName", "UiAutomator2");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Base_methods common = new Base_methods(driver);

		// Get screen size
		Dimension size = driver.manage().window().getSize();
		System.out.println("Dimensions : " + size);

		int width = size.getWidth();
		int height = size.getHeight();

		System.out.println("Width : " + width);
		System.out.println("height : " + height);
		
		common.click("xpath", "//android.widget.TextView[@text='RJ']");
		
		List<WebElement> msgsectionlist = driver.findElementsByClassName("android.view.ViewGroup");
		WebElement lastmsgsection = msgsectionlist.get(msgsectionlist.size()-1);
		
		TouchAction<?> action = new TouchAction<>(driver)
				.longPress(LongPressOptions.longPressOptions()
						.withElement(ElementOption.element(lastmsgsection))
						.withDuration(Duration.ofSeconds(2)))
				.release()
				.perform();
		
		common.click("accessibility id", "Call");
		
	}

}
