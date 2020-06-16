package week1.day2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TC002_SendMsgWhatsapp {

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
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		WebElement chatperson = driver.findElementByXPath("//android.widget.TextView[@text='RJ']");
		wait.until(ExpectedConditions.visibilityOf(chatperson));
		chatperson.click();
		
		WebElement message = driver.findElementById("com.whatsapp:id/entry");
		wait.until(ExpectedConditions.visibilityOf(message));
		message.sendKeys("Via Program - Manoj");
		
		WebElement sendbutton = driver.findElementByAccessibilityId("Send");
		wait.until(ExpectedConditions.visibilityOf(sendbutton));
		sendbutton.click();

	}

}
