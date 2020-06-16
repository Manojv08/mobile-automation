package week2.day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Touch_Actions_scroll {

	public static void main(String[] args) throws MalformedURLException {
		// Learn touch actions

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("deviceName", "Redmi Note 7 Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Scroll Down function
		// Get screen size
		Dimension size = driver.manage().window().getSize();
		System.out.println("Dimensions : " + size);

		int width = size.getWidth();
		int height = size.getHeight();

		System.out.println("Width : " + width);
		System.out.println("height : " + height);

		// Find the start x & y and end x & y positions on where you need to touch
		int startX = (int) (width * 0.5);
		int endX = (int) (width * 0.5);

		int StartY = (int) (height * 0.2);
		int endY = (int) (height * 0.8);

		// Let's do some actions on mobile
		TouchAction<?> action = new TouchAction<>(driver).press(PointOption.point(startX, StartY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(PointOption.point(endX, endY))
				.release().perform();

		// Scroll up function
		// Find the start x & y and end x & y positions on where you need to touch
		int startXup = (int) (width * 0.5);
		int endXup = (int) (width * 0.5);

		int StartYup = (int) (height * 0.8);
		int endYup = (int) (height * 0.2);

		// Let's do some actions on mobile
		TouchAction<?> action1 = new TouchAction<>(driver).press(PointOption.point(startXup, StartYup))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(PointOption.point(endXup, endYup))
				.release().perform();

	}

}
