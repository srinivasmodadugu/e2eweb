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

public class LaunchPageTest extends base {
	
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	
	public void initial() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String email, String password, String text) throws IOException {
		
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

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "lauchpage@gamil.com";
		data[0][1] = "password";
		data[0][2] = "Successful login";

		data[1][0] = "lauchpage@gamil.com";
		data[1][1] = "password";
		data[1][2] = "unsuccessful login";
		
		return data;
	
	}

	@AfterTest
	public void tearDown() throws IOException {
		
		driver.close();
	}
	
}
