package week2.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import base_functions.Base_methods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Keyboard_Interactions {

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

		Base_methods common = new Base_methods(driver);

		boolean appInstalled = driver.isAppInstalled("com.testleaf.leaforg");
		System.out.println("LeafOrg App is installed? : " + appInstalled);
		
		common.click("xpath", "//android.widget.EditText[not(@text='Password')]");
		
		// Once the keyboard is opened - we have to use key event to type in the keyboard
		KeyEvent key = new KeyEvent(AndroidKey.R);
		driver.pressKey(key);
		
		driver.pressKey(new KeyEvent(AndroidKey.A));
		driver.pressKey(new KeyEvent(AndroidKey.J));
		driver.pressKey(new KeyEvent(AndroidKey.K));
		driver.pressKey(new KeyEvent(AndroidKey.U));
		driver.pressKey(new KeyEvent(AndroidKey.M));
		driver.pressKey(new KeyEvent(AndroidKey.A));
		driver.pressKey(new KeyEvent(AndroidKey.R));
		driver.pressKey(new KeyEvent(AndroidKey.AT));
		driver.pressKey(new KeyEvent(AndroidKey.T));
		driver.pressKey(new KeyEvent(AndroidKey.E));
		driver.pressKey(new KeyEvent(AndroidKey.S));
		driver.pressKey(new KeyEvent(AndroidKey.T));
		driver.pressKey(new KeyEvent(AndroidKey.L));
		driver.pressKey(new KeyEvent(AndroidKey.E));
		driver.pressKey(new KeyEvent(AndroidKey.A));
		driver.pressKey(new KeyEvent(AndroidKey.F));
		driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_DOT));
		driver.pressKey(new KeyEvent(AndroidKey.C));
		driver.pressKey(new KeyEvent(AndroidKey.O));
		driver.pressKey(new KeyEvent(AndroidKey.M));
		
		// To close the keyboard
		driver.hideKeyboard();

		common.fill("xpath", "//android.widget.EditText[@text='Password']", "Leaf@123");
		common.click("xpath", "//android.widget.Button[@text='LOGIN']");
	
	}

}