package E2E.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PwdPage;
import resources.base;

public class HomePageTest extends base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	
	public void initial() throws IOException {
		driver = initializeDriver();
		log.info("driver is initializ");
	}
	
	@Test(dataProvider = "getData")
	public void successfullLogin(String email, String password, String text) throws IOException {
		
		driver.get(prop.getProperty("url"));
		log.info("page loaded");
		System.out.println("page navigation");
		LandingPage l = new LandingPage(driver);
		l.getSignin().click();
		log.info("clicked signin");

		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(email);
		lp.getContinue().click();

		PwdPage pwdp = new PwdPage(driver);
		pwdp.getPwd().sendKeys(password);
		pwdp.getSubmit().click();
		System.out.println(text);
		
	}
	
	@Test(dataProvider = "getData")
	public void selectItem(String email, String password, String text) throws IOException {
		
	//successfullLogin(email,password,text);
				
	}

	
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][3];
		data[0][0] = "sri666@yahoo.com";
		data[0][1] = "Laks@123";
		data[0][2] = "Successful login";
		return data;
	
	}

	@AfterTest
	public void tearDown() throws IOException {
		
		driver.close();
	}
	
}
