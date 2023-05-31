package POM_Pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Makeup_Remover_Page {
	
	public static WebDriver driver;
	
//       //body/div/div/div/div/div[5]/div[2]/div/div[14]/div/div/a/div[2]
	
	@FindBy (xpath = "//div[@class='css-d5z3ro']")
	private WebElement productclick;
	
////


	public Makeup_Remover_Page(WebDriver driver1) {
			
		Makeup_Remover_Page.driver = driver1;
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getProductclick() {
		return productclick;
	}
	
	
	public void getclickon_Product() {

		productclick.click();
	}
}
