package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class base {

	 public static final  String USERNAME = "sri666";
	  public static final  String ACCESS_KEY = "4fd8d29e-e5e1-41e1-b366-07b3005291e6";
	
	public WebDriver driver;
	public Properties prop;
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
public WebDriver initializeDriver() throws IOException {
		
	
	
	System.out.println("initial driver page");
	prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Sri\\git\\e2eweb\\E2EProject\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	String env=prop.getProperty("environment");
	System.out.println(browserName);


	
	if((env.equals("saucelabs"))&& (browserName.equals("chrome")) )
	{
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 7");
		caps.setCapability("version", "51.0");
		driver=new RemoteWebDriver(new URL(URL), caps);
	}

		else if((env.equals("local"))&& (browserName.equals("chrome")) )
		{
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if (browserName.equals("IE"))
	{
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability("platform", "Windows 7");
		caps.setCapability("version", "51.0");
		driver=new RemoteWebDriver(new URL(URL), caps);
		//System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		//driver=new ChromeDriver();
	}	
	else if (browserName.equals("firefox"))
	{	
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Windows 7");
		caps.setCapability("version", "51.0");
		driver=new RemoteWebDriver(new URL(URL), caps);
		
		//System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		 //driver=new ChromeDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;
}

public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
{
TakesScreenshot ts=	(TakesScreenshot) driver;
File source=ts.getScreenshotAs(OutputType.FILE);
String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
FileUtils.copyFile(source,new File(destinationFile));
return destinationFile;
}
	
}
