package Tests;

import org.ghost4j.GhostscriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.CaptchaReading;
import Pages.LoginPage;
import Pages.RegisterNewUser;
import Utility.BrowserFactory;
import net.sourceforge.tess4j.TesseractException;

public class TestCase {

	public static WebDriver driver;
	
	
	@BeforeSuite
	public static void startApplication() throws Exception {
	driver = BrowserFactory.BrowserIntialization(driver, "Firefox", "https://phptravels.com/demo/");
	
	}
	
		@Test
		public void LoginPageTestCase() throws InterruptedException {
		LoginPage LP = 	PageFactory.initElements(driver, LoginPage.class);
		LP.getOptionsLoginPage();
	}
	
	
		@Test
		public void RegisterNewUserTestCase() throws InterruptedException {
		RegisterNewUser NP = 	PageFactory.initElements(driver, RegisterNewUser.class);
		NP.registerNewUser("ABCD","CDFG","Test@test.com" , "99991918" , "India" , "Chandigarh" , "Chandigarh" ,"110199" );
	}
	
	
	
	
	public static void closeApplication() {
		BrowserFactory.tearDown(driver);
	}
	
}
