package week2.homework;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import base_functions.Base_methods;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TC011_Vertical_Swipe_VodQA {

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
		common.click("xpath", "//android.widget.TextView[@content-desc='verticalSwipe']");

		common.waitForElement("xpath", "//android.widget.ScrollView[@content-desc='listview']//android.widget.TextView");
		
		Set<String> eletextlist = new HashSet<String>();
		boolean flag;
		
		do {
			List<WebElement> elelist = driver.findElements("xpath", "//android.widget.ScrollView[@content-desc='listview']//android.widget.TextView");
			for (WebElement ele : elelist) {
				String eletext = ele.getText();
				System.out.println(eletext);
				eletextlist.add(eletext);
			}
			
			System.out.println(eletextlist);
			System.out.println(eletextlist.contains(" Karma"));
			
			if(eletextlist.contains(" Karma")) {
				flag = false;
			} else {
				scroll_up(driver);
				flag = true;
			}
		}while(flag);
		
		System.out.println(eletextlist);
		
	}
	
	public static void scroll_up(AndroidDriver<WebElement> driver){
		Dimension size = driver.manage().window().getSize();

		int width = size.getWidth();
		int height = size.getHeight();

		// Scroll up function
		// Find the start x & y and end x & y positions on where you need to touch
		int startXup = (int) (width * 0.5);
		int endXup = (int) (width * 0.5);

		int StartYup = (int) (height * 0.9);
		int endYup = (int) (height * 0.2);

		// Let's do some actions on mobile
		new TouchAction<>(driver).press(PointOption.point(startXup, StartYup))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(PointOption.point(endXup, endYup))
				.release().perform();
	}

}