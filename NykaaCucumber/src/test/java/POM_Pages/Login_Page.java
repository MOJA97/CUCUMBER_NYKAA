package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	public static WebDriver driver;
	
	@FindBy (xpath = "//input[@name='emailMobile']")
	private WebElement login;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement proceedBTN;
	
	@FindBy (xpath = "//button[text()='send otp to email']")
	private WebElement pass;
	

		
	public Login_Page(WebDriver driver2) {
		
		Login_Page.driver = driver2;
		PageFactory.initElements(driver, this);
	}
	public WebElement getLogin() {
		return login;
	}

	public WebElement getProceedBTN() {
		return proceedBTN;
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public WebElement getPass() {
		return pass;
	}
	
	public void enterEmail(String email) {

		login.sendKeys(email);
		
	}
	
	public void enterProceedBTN() {

		login.click();
	}
	
	
	
	
	

}
