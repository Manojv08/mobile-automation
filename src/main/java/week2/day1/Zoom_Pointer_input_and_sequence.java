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
import io.appium.java_client.android.AndroidDriver;

public class Zoom_Pointer_input_and_sequence {

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

		// Zoom in function using two fingers
		// Find the start x & y and end x & y positions on where you need to touch
		int startX1 = (int) (width * 0.5);
		int endX1 = (int) (width * 0.9);

		int StartY1 = (int) (height * 0.5);
		int endY1 = (int) (height * 0.1);

		// Let's do some actions on mobile using Pointer Input

		// action 1
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence dragNdrop1 = new Sequence(finger1, 1);

		dragNdrop1.addAction(
				finger1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX1, StartY1));
		dragNdrop1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		dragNdrop1.addAction(
				finger1.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX1, endY1));
		dragNdrop1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		
		int startX2 = (int) (width * 0.5);
		int endX2 = (int) (width * 0.1);

		int StartY2 = (int) (height * 0.5);
		int endY2 = (int) (height * 0.9);

		// action 2
		PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
		Sequence dragNdrop2 = new Sequence(finger2, 2);

		dragNdrop2.addAction(
				finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX2, StartY2));
		dragNdrop2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		dragNdrop2.addAction(
				finger2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX2, endY2));
		dragNdrop2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Arrays.asList(dragNdrop1, dragNdrop2));

	}

}
