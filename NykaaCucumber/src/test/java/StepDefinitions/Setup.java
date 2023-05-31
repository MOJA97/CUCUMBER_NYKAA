package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Base_Class_Utils.com.Base_Class;

import POM_Pages.Logout_Page;
import POM_Pages.Makeup_Remover_Page;
import POM_Pages.Product_Page;
import POM_Pages.Shipping_Page;
import POM_Pages.User_Homepage;
import POM_Pages.Login_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Setup extends Base_Class {

	public static WebDriver driver = browser_Launch("chrome");

	static Login_Page login = new Login_Page(driver);
	static User_Homepage Uhp = new User_Homepage(driver);
	static Makeup_Remover_Page Mrp = new Makeup_Remover_Page(driver);
	static Product_Page page = new Product_Page(driver);
	static Shipping_Page Spage = new Shipping_Page(driver);
	static Logout_Page Lpage = new Logout_Page(driver);

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.err.println("Inside step- User is on login Page");

		getUrl("https://www.nykaa.com/auth/verify?ptype=auth&redirect=%2F");
		System.out.println("Browser launched");
		window_Manage("maximize");
		System.out.println("Window Maximized");

	}

	@When("user enters the valid {string}")
	public void user_enters_the_valid_email(String email) throws IOException {
		System.out.println("Inside step- User enters the email address");

		send_Values(login.getLogin(), email);
		System.out.println("email has been entered");
		implicitly_Wait(5);
		screenshot(driver, "C:\\Users\\Javed\\eclipse-workspace\\NykaaCucumber\\Screenshots/loginpage.png");

	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("Inside step- User clicked on login button");

		click(login.getProceedBTN());
		System.out.println("Proceed button clicked");

		click(login.getPass());
		System.out.println("OTP procedure started");

		// Enter your OTP:
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your OTP:");
		String otp = s.next();
		WebElement OTPNo = driver.findElement(By.xpath("//input[@name='otpValue']"));
		click(OTPNo);
		send_Values(OTPNo, otp);

		System.out.println("OTP has been entered");

	}

	@Then("user is navigates to the home page")
	public void user_is_navigates_to_the_home_page() {

		WebElement verifyBTN = driver.findElement(By.xpath("//button[@type='submit']"));
		verifyBTN.click();
		System.out.println("user navigated to HOME PAGE");

	}

	@Given("user in on home page")
	public void user_in_on_home_page() throws IOException {

		System.out.println("User is on home page");
	}

	@When("user click the byproduct from the makeup product")
	public void user_click_the_byproduct_from_the_makeup_product() throws IOException {

		moveTOelement(driver, Uhp.getMakeup());
		WebElement makeupremover = driver.findElement(By.linkText("Makeup Remover"));
		implicitly_Wait(4);
		screenshot(driver, "C:\\Users\\Javed\\eclipse-workspace\\NykaaCucumber\\Screenshots/makeuppage.png");
		makeupremover.click();
		System.err.println("Browser open a makeup remover window tab");

	}

	@Then("user navigates to new tab of byproduct list page")
	public void user_navigates_to_new_tab_of_byproduct_list_page() throws IOException {

		String title = driver.getTitle();
		multiple_WindowHandling(title);
		screenshot(driver, "C:\\Users\\Javed\\eclipse-workspace\\NykaaCucumber\\Screenshots/makeupremoverPAGE.png");
		System.out.println("Driver moved to newly opened window");
		System.err.println("user navigates to products page");
		scrollIntoView(Mrp.getProductclick());

	}

	@Given("user is on products page")
	public void user_is_on_products_page() {

		System.out.println("User is on product page");
		

	}

	@When("user clicks the byproduct")
	public void user_clicks_the_byproduct() {
		implicitly_Wait(5);
		moveToElement(Mrp.getProductclick());
		
		List<WebElement> product = driver.findElements(By.xpath("//div[@class='css-d5z3ro']"));
		for (WebElement name : product) {

			if (name.getText().contains("Clinique Take The Day Off Cleansing Balm (Makeup Remover)")) {

				WebElement prd = driver.findElement(
						By.xpath("//div[text()='Clinique Take The Day Off Cleansing Balm (Makeup Remover)']"));
				prd.click();

			}

		}
		System.out.println("Product has been found and clicked");

	}

	@When("user navigates to new tab of chosen product page")
	public void user_navigates_to_new_tab_of_chosen_product_page() throws IOException {
		String title2 = driver.getTitle();
		multiple_WindowHandling(title2);
		screenshot(driver, "C:\\Users\\Javed\\eclipse-workspace\\NykaaCucumber\\Screenshots/productpage.png");
		System.out.println("moved to newly opened window");

	}

	@When("user clicks the add to bag button")
	public void user_clicks_the_add_to_bag_button() {
		click(page.getAddtobag());
		System.out.println("Product is added in to the bag");

	}

	@When("user clicks the bag icon in the product page")
	public void user_clicks_the_bag_icon_in_the_product_page() throws IOException {
		click(page.getCart());

		implicitly_Wait(3);
		screenshot(driver, "C:\\Users\\Javed\\eclipse-workspace\\NykaaCucumber\\Screenshots/cartFrame.png");

	}

	@When("user clicks proceed button")
	public void user_clicks_proceed_button() {
		iframes(page.getFrameSwitch());
		click(page.getProceedbtn());
		System.out.println("Proceed button has been clicked");
	}

	@Then("user navigates to the choose address page")
	public void user_navigates_to_the_choose_address_page() {
		
		System.err.println("User navigated to address page");

	}

	@Given("user is on address page")
	public void user_is_on_address_page() {

		System.out.println("Url changes to address page");
	}

	@When("user clicks the add new address icon")
	public void user_clicks_the_add_new_address_icon() {
		click(Spage.getAddress1());
	}

	@When("user enters the valid Pincode")
	public void user_enters_the_valid_pincode(String Pincode) {
		click(Spage.getPincode());
		send_Values(Spage.getPincode(), Pincode);
	}

	@When("user enters the House number")
	public void user_enters_the_house_number(String HouseNo) {

		implicitly_Wait(5);
		send_Values(Spage.getHouseno(), HouseNo);
	}

	@When("user enters the Area name")
	public void user_enters_the_area_name(String Area) throws IOException {
		send_Values(Spage.getAddress(), Area);

		implicitly_Wait(4);
		screenshot(driver, "C:\\Users\\Javed\\eclipse-workspace\\NykaaCucumber\\Screenshots/shippingpage.png");

	}

	@When("user click the default address checkbox")
	public void user_click_the_default_address_checkbox() {
		click(Spage.getCheckbox());
	}

	@When("user enters the name in the contact details")
	public void user_enters_the_name_in_the_contact_details(String name) {

		click(Spage.getName());
		send_Values(Spage.getName(), name);
	}

	@When("user enters the phone number")
	public void user_enters_the_phone_number(String phoneNumber) {

		click(Spage.getPhone());
		send_Values(Spage.getPhone(), phoneNumber);
	}

	@When("user enters the emailID")
	public void user_enters_the_email_id(String email) {

		click(Spage.getEmailID());
		send_Values(Spage.getEmailID(), email);
	}

	@When("user clicks the ship to this address button")
	public void user_clicks_the_ship_to_this_address_button() {
		click(Spage.getShippingBTN());
	}

	@Then("user navigates to Payment method page for payment")
	public void user_navigates_to_payment_method_page_for_payment() {

		System.out.println("User navigates to payment method for bill");
	}

	@Given("user navigates to profile home page")
	public void user_navigates_to_profile_home_page() {
		multiple_WindowhandlingURL("https://www.nykaa.com/");
	}

	@When("user clicks on logout button")
	public void user_clicks_on_logout_button() {
		click(Lpage.getProfileBTN());
		click(Lpage.getLogoutBTN());

	}

	@Then("user navigates to home page")
	public void user_navigates_to_home_page() throws IOException {
		screenshot(driver, "C:\\Users\\Javed\\eclipse-workspace\\NykaaCucumber\\Screenshots/logoutPage.png");
		click(Lpage.getLogoutPopup());
		System.out.println("Profile has been logged out");

		window_Manage("minimize");
		System.out.println("Browser maximize");
		
		driver.close();
	}

}
