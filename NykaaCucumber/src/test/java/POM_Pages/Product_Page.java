package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Page {
	
	public static WebDriver driver;
	
	@FindBy (xpath = "//div[@class='css-l13z72']//descendant::span[contains(text(),'Add to Bag')]")
	private WebElement addtobag;
	
	
	@FindBy (xpath = "//button[@class='css-aesrxy']")
	private WebElement cart;
	
	@FindBy (xpath = "//iframe[@class='css-acpm4k']")
	private WebElement frame;
	
	@FindBy (xpath = "//span[.='Proceed']")
	private WebElement proceedbtn;


	public WebElement getFrameSwitch() {
		driver.switchTo().frame(frame);
		return frame;
	}


	public WebElement getProceedbtn() {
		proceedbtn.click();
		return proceedbtn;
	}


	public Product_Page(WebDriver driver1) {
		Product_Page.driver = driver1;
		PageFactory.initElements(driver, this);
	
	}


	public WebElement getAddtobag() {
		addtobag.click();
		return addtobag;
	}


	public WebElement getCart() {
		cart.click();
		return cart;
	}
	
	
}
