package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	By email=By.xpath("//input[@id='ap_email']");
	By submit=By.xpath("//input[@id='continue']");
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
		
	}
	public WebElement getContinue(){
		return driver.findElement(submit);
		
	}
}
