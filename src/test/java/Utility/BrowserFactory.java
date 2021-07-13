package Utility;

import java.io.File;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BrowserFactory {

	public static WebDriver driver;
	
	

	@BeforeSuite
	public static WebDriver BrowserIntialization(WebDriver driver, String BrowserName, String URL) throws Exception {

		if (BrowserName.equalsIgnoreCase("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "C:\\MARIONETTE_Logs\\logs.txt");
			
			
			driver = new FirefoxDriver();
			
			System.out.println("Firefox driver used");
		}
		
		
		else if (BrowserName.equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")  + "/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome driver used");

		}
		
		
		else if(BrowserName.equalsIgnoreCase("Edge")){
			
			System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
			
			driver = new EdgeDriver();
		}
		
		else {
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}

			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(43, TimeUnit.SECONDS);
			
		

		return driver;

	}

	@AfterSuite
	public static WebDriver tearDown(WebDriver driver) {
		driver.quit();
		return driver;

	}

}
