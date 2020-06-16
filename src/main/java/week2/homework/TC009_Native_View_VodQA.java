package week2.homework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import base_functions.Base_methods;
import io.appium.java_client.android.AndroidDriver;

public class TC009_Native_View_VodQA {

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
		common.click("xpath", "//android.view.ViewGroup[@content-desc='chainedView']");

		String viewone = common.fetch_text("xpath", "//android.view.ViewGroup[@content-desc='viewgroup1']/*");
		
		String viewtwo = common.fetch_text("xpath", "//android.view.ViewGroup[@content-desc='viewgroup2']/*");
		
		String viewthree = common.fetch_text("xpath", "//android.view.ViewGroup[@content-desc='viewgroup3']/*");
		
		System.out.println(viewone + "\n" + viewtwo + "\n" + viewthree);
	
	}

}