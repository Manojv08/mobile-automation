package week2.homework;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import base_functions.Base_methods;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TC010_Slider_VodQA {

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
		common.click("xpath", "//android.widget.TextView[@content-desc='slider1']");

		WebElement sliderele = common.waitForElement("accessibility id", "slider");
		Point location = sliderele.getLocation();
		int x = location.getX();
		int y = location.getY();

		System.out.println(location + "\n" + x + "\n" + y);
//		To get bounds attribute values
//		[el.getLocation().getX(), el.getLocation().getY()] // first [x,y]
//		[el.getLocation().getX() +el.getSize().getWidth(), el.getLocation().getY()+el.getSize().getHeight()] // second [x,y]

		int startX = x;
		int endX = x + 500;

		int StartY = y;
		int endY = y;

		// Let's do some actions on mobile
		new TouchAction<>(driver).press(PointOption.point(startX, StartY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(PointOption.point(endX, endY))
				.release().perform();

	}

}