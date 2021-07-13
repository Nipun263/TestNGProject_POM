package Pages;

import java.awt.Frame;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterNewUser {

	public static WebDriver driver;
	
	

	public RegisterNewUser(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div/nav/a[contains(text(),'Login')]")
	WebElement loginBtn;

	@FindBy(xpath = "//*[@id='header-title'][contains(text(),'Cars module')]")
	WebElement carModuleTitle;

	@FindBy(xpath = "//*[@id='Secondary_Navbar-Account']/a")
	WebElement account;

	@FindBy(xpath = "//*[@id='Secondary_Navbar-Account-Register']/a")
	WebElement register;

	@FindBy(xpath = "//*[@id='main-body']//small")
	WebElement verifyRegisterPage;

	@FindBy(xpath = "//*[@name='firstname']")
	WebElement firstName;

	@FindBy(xpath = "//*[@name='lastname']")
	WebElement lastName;

	@FindBy(xpath = "//*[@name='email']")
	WebElement email;

	@FindBy(xpath = "//*[@name='phonenumber']")
	WebElement phone;
	
	
	@FindAll({
	@FindBy(xpath = "//*[@class='country-name']"),
	@FindBy(xpath = "//*[@class='country-name']") })
	List<WebElement> countryCode;
	

	@FindBy(xpath = "//*[@class='selected-dial-code']")
	WebElement countryCodeDD;
	

	@FindBy(name = "address1")
	WebElement Address1;
	
	
	@FindBy(name = "city")
	WebElement City;
	
	@FindBy(name = "state")
	WebElement State;
	
	@FindBy(name = "postcode")
	WebElement postCode;
	

	@FindBy(name = "password")
	WebElement Password;
	

	@FindBy(name = "password2")
	WebElement ConfirmPassword;
	
	
	
	@FindBy(xpath = "//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']")
	WebElement captcha;
	
	
	@FindBy(xpath = "//*[@class='recaptcha-checkbox-border']")
	WebElement registerUser;
	

	public void registerNewUser(String firstNamePassed , String lastNamePassed , String emailPassed , String phoneNumberPassed
			,String DesiredCounty , String cityName , String stateName , String pincodePassed) throws InterruptedException {
		
		String handle = driver.getWindowHandle();
	
		loginBtn.click();
		
		Thread.sleep(3000);
	
		Set<String> handles = driver.getWindowHandles();
			for(String STR : handles) {
				if(!STR.equals(handle)) {
			driver.switchTo().window(STR);
		
			System.out.println("Window Successfully switched");	
		
				}
	  }
			
		account.click();
		Actions action = new Actions(driver);
		action.clickAndHold(account).build().perform();
		
		register.click();
		
		Boolean flag = verifyRegisterPage.isDisplayed();
		Assert.assertTrue(flag);
		
		//Passing the New User Data 
		firstName.sendKeys(firstNamePassed);
		
		lastName.sendKeys(lastNamePassed);

		email.sendKeys(emailPassed);
		
		countryCodeDD.click();
		
		List<WebElement> countryCodes_Extracted = countryCode;
		
		for(WebElement WB : countryCodes_Extracted) {
		String  CC = WB.getText();
			
		System.out.println("Text Extracted is ::"  + CC.toString());
		
		
		if(CC.startsWith(DesiredCounty)) {
			WB.click();
		}
		
		}
		
		phone.sendKeys(phoneNumberPassed);
		
		City.sendKeys(cityName);
		
		State.sendKeys(stateName);
		
		postCode.sendKeys(pincodePassed);
		
		Double rNumber = Math.random();
		
		String PasswordToPass = "Dummy" + rNumber ;
		
		Password.sendKeys(PasswordToPass);
		
		ConfirmPassword.sendKeys(PasswordToPass);
		
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("window.scrollBy(0,400)");
		
		
		
		
		
		List<WebElement> framz = driver.findElements(By.tagName("iframe"));
		int size = driver.findElements(By.tagName("iframe")).size();
		
		
		
		for(int i = 0 ; i < framz.size() ; i++) {
			
			String TT = framz.get(i).getAttribute("name");
			
			if(driver.switchTo().frame(TT) != null) {
		
			action.moveToElement(captcha).click(captcha).build().perform();
		
			driver.switchTo().defaultContent();
			
			break;
			
		}
			
		}
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@title='recaptcha challenge']")));
		
		System.out.println("Frame Switched");
		
		
		WebElement playBtn = driver.findElement(By.xpath("//*[@class='button-holder audio-button-holder']"));
		playBtn.click();
		
		WebElement play = driver.findElement(By.xpath("//button[contains(text(),'PLAY')]"));
		play.click();
		
		//registerUser.click();
		
	}	

	}

