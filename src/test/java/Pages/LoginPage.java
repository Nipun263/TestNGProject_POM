package Pages;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	public static WebDriver driver;
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindAll({ @FindBy(xpath = "//div/nav/a"), @FindBy(xpath = "//div/nav/a") })
	List<WebElement> elementsOnLoginPage;
	

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Login')]//preceding-sibling::div/span"),
			@FindBy(xpath = "//a[contains(text(),'Login')]//preceding-sibling::div/span") })
	List<WebElement> remaniningelementsOnLoginPage;
	
	

	@FindBy(xpath = "//a[contains(text(),'Login')]//preceding-sibling::div/span[contains(text(),'Features')]")
	WebElement feature;
	
	

	@FindBy(xpath = "//a[contains(text(),'Cars')]")
	WebElement carModule;
	
	

	public void getOptionsLoginPage() throws InterruptedException {

		List<WebElement> LL = elementsOnLoginPage;
		List<WebElement> RR = remaniningelementsOnLoginPage;
		
		

		for (WebElement WB : LL) {
			String SS = WB.getText();
			System.out.println("Element found is   ::::::::::: " + SS);

		}
		
		

		for (WebElement WB : RR) {
			String remElement = WB.getText();
			System.out.println("Element found is   ::::::::::: " + remElement);

			if (remElement.contains("Features")) {
				Actions action = new Actions(driver);
				action.moveToElement(feature).clickAndHold(feature).build().perform();
					
		}
			
			carModule.click();
		
		}
	}
	
		
	
}


