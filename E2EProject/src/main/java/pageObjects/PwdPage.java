package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PwdPage {

	public WebDriver driver;
	By pwd=By.xpath("//input[@id='ap_password']");
	By submit=By.xpath("//input[@id='signInSubmit']");
	public PwdPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getPwd() {
		return driver.findElement(pwd);
		
	}
	public WebElement getSubmit(){
		return driver.findElement(submit);
		
	}
}
