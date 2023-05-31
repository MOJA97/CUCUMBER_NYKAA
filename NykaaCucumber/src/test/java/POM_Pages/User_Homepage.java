package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_Homepage {
	
	public static WebDriver driver;
	
	@FindBy (xpath = "//a[text()='makeup']//parent::li")
	private WebElement makeup;

	public User_Homepage(WebDriver driver2) {

	User_Homepage.driver = driver2;
	PageFactory.initElements(driver, this);
	
	}

	public WebElement getMakeup() {
		return makeup;
	}
	
	public void getmakeup() {

		makeup.click();
	}

}
