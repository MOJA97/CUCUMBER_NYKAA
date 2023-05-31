package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout_Page {

	
	public static WebDriver driver;
	
	@FindBy (xpath = "//button[@type='button']//parent::div[@class='css-1t6rx6a euw1lbv0']")
	private WebElement profileBTN;
	
	@FindBy (xpath = "//div[@class='dropDown_list css-12mp2ee euw1lbv5']//descendant::button[text()='Logout']")
	private WebElement LogoutBTN;
	
	@FindBy (xpath = "//div[@class='  partial-modal  css-1pqs92a e1j92jav0']//descendant::div")
	private WebElement LogoutPopup;

	public WebElement getLogoutPopup() {
		return LogoutPopup;
	}

	public Logout_Page(WebDriver driver1) {
		
		Logout_Page.driver = driver1;
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getProfileBTN() {
		return profileBTN;
	}

	public WebElement getLogoutBTN() {
		return LogoutBTN;
	}
	
	
	
	
	
	
}
