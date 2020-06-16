package week2.day2;

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
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Scroll_until_element {

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
		
		Set<String> names = new HashSet<String>();
		boolean notfound;
		do
		{
			List<WebElement> contactnames = driver.findElements("xpath", "//android.widget.TextView[@resource-id='com.whatsapp:id/conversations_row_contact_name']");
			for (WebElement contactname : contactnames) {
				names.add(contactname.getText());
			}
			System.out.println(names);
			
			if(!names.contains("Vivriti-QA")) {
				notfound = true;
			}else {
				notfound = false;
			}
			
			Dimension size = driver.manage().window().getSize();
			System.out.println("Dimensions : " + size);

			int width = size.getWidth();
			int height = size.getHeight();

			System.out.println("Width : " + width);
			System.out.println("height : " + height);
			
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
			
		}while(notfound);
		
		
	}

}
