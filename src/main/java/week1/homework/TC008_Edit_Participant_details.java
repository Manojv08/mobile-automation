package week1.homework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

import base_functions.Base_methods;
import io.appium.java_client.android.AndroidDriver;

public class TC008_Edit_Participant_details {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();

		// if App is not already installed, 2 capabilities needs to set
		// deviceName
		// App
		// optional
		// platform

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

		common.fill("xpath", "//android.widget.EditText[not(@text='Password')]", "rajkumar@testleaf.com");
		common.fill("xpath", "//android.widget.EditText[@text='Password']", "Leaf@123");
		common.click("xpath", "//android.widget.Button[@text='LOGIN']");

//		Need to check for id which is not working
		common.click("xpath", "//android.view.View[@resource-id='tab-t0-2']");

//		Need to check for right arrow working
		common.click("xpath", "//android.view.View[@text='Participant Details']");

		String pptid = "41029298";
		common.clear_and_fill("xpath", "(//android.widget.EditText)[3]", pptid);

		String dlid = "D9865410";
		common.clear_and_fill("xpath", "(//android.widget.EditText)[6]", dlid);

//		Need to check on D.O.B items as well
		common.click("xpath", "//android.widget.Button[@text='SAVE CHANGES']");

		String alertText = common.fetch_text("xpath", "//android.view.View[@resource-id='alert-msg-0']");
		System.out.println("After saving changes alert text : " + alertText);

		common.click("xpath", "//android.widget.Button[@text='OK']");

		common.click("xpath", "//android.widget.Button[@text='arrow back']");

		common.click("xpath", "//android.widget.Button[@text='LOGOUT']");

		common.click("xpath", "//android.widget.Button[@text='YES, LOGOUT']");

		common.fill("xpath", "//android.widget.EditText[not(@text='Password')]", "rajkumar@testleaf.com");
		common.fill("xpath", "//android.widget.EditText[@text='Password']", "Leaf@123");
		common.click("xpath", "//android.widget.Button[@text='LOGIN']");

		String infodlid = common.fetch_text("xpath",
				"(//android.view.View[@text='DRIVERS LICENSE']/following-sibling::android.view.View)[2]");
		System.out.println("DL Id is : " + infodlid);

		String infopptid = common.fetch_text("xpath",
				"(//android.view.View[@text='PARTICIPANT ID']/following-sibling::android.view.View)[2]");
		System.out.println("Participant Id is : " + infopptid);

		boolean pptcheck = infopptid.contains(pptid);

		boolean dlcheck = infodlid.contains(dlid);

		System.out.println("Input DL Id and Info Page DL Id is same or not : " + dlcheck);

		System.out.println("Input Ppt Id and Info Page Ppt Id is same or not : " + pptcheck);

	}

}