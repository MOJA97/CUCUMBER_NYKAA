package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shipping_Page {
	
	public static WebDriver driver;
	
	@FindBy (xpath = "//p[text()='Add New Address']//parent::div")
	private WebElement Address1;
	
	@FindBy (xpath = "//div[@class='css-65fmv9 emgron30']//descendant::input[@placeholder='Pincode']")
	private WebElement pincode;
	
	@FindBy (xpath = "//div[@class='css-65fmv9 emgron30']//descendant::input[@placeholder='House/ Flat/ Office No.']")
	private WebElement houseno;
	
	@FindBy (xpath = "//div[@class='css-65fmv9 emgron30']//descendant::textarea[@placeholder='Road Name/ Area /Colony']")
	private WebElement address;
	
	@FindBy (xpath = "//div[@class='css-65fmv9 emgron30']//descendant::span[@class='slider round css-0 e1rxn2v03']")
	private WebElement checkbox;
	
	@FindBy (xpath = "//div[@class='css-65fmv9 emgron30']//descendant::input[@placeholder='Name']")
	private WebElement name;
	
	@FindBy (xpath = "//div[@class='css-65fmv9 emgron30']//descendant::input[@placeholder='Phone']")
	private WebElement phone;
	
	@FindBy (xpath = "//div[@class='css-65fmv9 emgron30']//descendant::input[@placeholder='Email ID (Optional)']")
	private WebElement emailID;
	
	@FindBy (xpath = "//button[text()='Ship to this address']")
	private WebElement shippingBTN;

	public Shipping_Page(WebDriver driver1) {
//		
		Shipping_Page.driver=driver1;
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddress1() {
		
		return Address1;
	}

	public WebElement getPincode() {
		return pincode;
	}

	public WebElement getHouseno() {
		return houseno;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEmailID() {
		return emailID;
	}

	public WebElement getShippingBTN() {
		return shippingBTN;
	}
	///////////////////////////////////////////////////////
	
	public void Pin(String Pincode) {
		pincode.sendKeys(Pincode);
	}

	public void Houseno(String HouseNo) {
		houseno.sendKeys(HouseNo);
	}

	public void Address(String Address) {
		address.sendKeys(Address);
	}

	public void Checkbox() {
		checkbox.click();
	}

	public void Name(String Name) {
		name.sendKeys(Name);
	}

	public void Phone(String phoneNumber) {
		phone.sendKeys(phoneNumber);
	}

	public void EmailID(String email) {
		emailID.sendKeys(email);
	}

	public void ShippingBTN() {
		shippingBTN.click();
	}

	
	
	
	
	
	

}
