package base_functions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Base_methods {
	
	private AndroidDriver<WebElement> driver;

	public Base_methods(AndroidDriver<WebElement> Adriver) {
		this.driver = Adriver;
	}
	
	public WebElement waitForElement(String how, String what) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(how, what)));
	}

	public void fill(String how, String what, String value) {
		waitForElement(how, what).sendKeys(value);
	}
	
	public void clear_and_fill(String how, String what, String value) {
		waitForElement(how, what).clear();
		waitForElement(how, what).sendKeys(value);
	}
	
	public void click(String how, String what) {
		waitForElement(how, what).click();
	}
	
	public String fetch_text(String how, String what) {
		return waitForElement(how, what).getText();
	}

}
