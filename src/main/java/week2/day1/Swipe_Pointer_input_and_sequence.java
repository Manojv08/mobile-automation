package week2.day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Swipe_Pointer_input_and_sequence {

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

		// Get screen size
		Dimension size = driver.manage().window().getSize();
		System.out.println("Dimensions : " + size);

		int width = size.getWidth();
		int height = size.getHeight();

		System.out.println("Width : " + width);
		System.out.println("height : " + height);

		// Swipe Right function
		// Find the start x & y and end x & y positions on where you need to touch
		int startX = (int) (width * 0.1);
		int endX = (int) (width * 0.9);

		int StartY = (int) (height * 0.5);
		int endY = (int) (height * 0.5);

		// Let's do some actions on mobile using Pointer Input
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence dragNdrop = new Sequence(finger, 1);

		dragNdrop.addAction(
				finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, StartY));
		dragNdrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		dragNdrop.addAction(
				finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
		dragNdrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Arrays.asList(dragNdrop));

	}

}
