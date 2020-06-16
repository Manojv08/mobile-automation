package flutter_trial;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import base_functions.Base_methods;
import io.appium.java_client.android.AndroidDriver;

public class flutter_gallery_trial {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("deviceName", "Redmi Note 7 Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "io.flutter.demo.gallery");
		dc.setCapability("appActivity", "io.flutter.demo.gallery.MainActivity");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Base_methods common = new Base_methods(driver);
		
		String context = driver.getContext();
		System.out.println("Context : " + context);
		
		Set<String> contextHandles = driver.getContextHandles();
		System.out.println("Context handles : " + contextHandles);

		boolean appInstalled = driver.isAppInstalled("com.vodqareactnative");
		System.out.println("vodQA App is installed? : " + appInstalled);

		common.click("xpath", "//android.view.View[@text='MATERIAL']");
		
		common.click("xpath", "//android.view.View[@text='Banner\n" + 
				"Displaying a banner within a list']");
		
		common.click("xpath", "//android.widget.Button[@text='DISMISS']");
	}

}