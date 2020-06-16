package week2.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;

public class Battery_Info {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("deviceName", "Redmi Note 7 Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Way 01 using Android driver - java-client
		AndroidBatteryInfo batteryInfo = driver.getBatteryInfo();
		System.out.println("Battery Information : " + batteryInfo);
		System.out.println("Battery level : " + batteryInfo.getLevel());
		System.out.println("Battery State : " + batteryInfo.getState());
		
		
		//Way 02 using adb shell
		Map<String, Object> bt = new HashMap<>();
		bt.put("command", "dumpsys");
		bt.put("args", "battery");
		
		Object executeScript = driver.executeScript("mobile: shell", bt);
		System.out.println(executeScript.toString());
	
	}

}