package com.Base_Class_Utils.com;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Base_Class {

	public static WebDriver driver;

	public static WebDriver browser_Launch(String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Javed\\eclipse-workspace\\NykaaCucumber\\Chrome_Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Javed\\eclipse-workspace\\NykaaCucumber\\firefox_Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		return driver;
	}

	public static void getUrl(String url) {

		driver.get(url);
	}

	public static void window_Manage(String size) {

		if (size.equalsIgnoreCase("maximize")) {
			driver.manage().window().maximize();
		} else if (size.equalsIgnoreCase("minimize")) {
			driver.manage().window().maximize();
		} else if (size.equalsIgnoreCase("Fullscreen")) {
			driver.manage().window().fullscreen();
		}
	}

	public static void popup_Prompt(WebElement element, String types) {

		if (types.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		} else if (types.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		}
	}

	public static void right_Click(WebElement element) {

		Actions a = new Actions(driver);
		a.contextClick(element).build().perform();
	}

	public static void moveToElement(WebElement list) {

		Actions ac = new Actions(driver);
		ac.moveToElement(list).build().perform();
	}

	public static void down_Enter() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void screenshot(WebDriver driver, String path) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);

	}

	public static void click(WebElement element) {

		element.click();
	}

	public static void clear(WebElement element) {

		element.clear();
	}

	public static void implicitly_Wait(int sec) {

		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static void current_Title() {

		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void dropdown_Index(WebElement element, int index) {

		Select s = new Select(element);
		s.selectByIndex(index);

	}

	public static void dropdown_Values(WebElement element, String name) {

		Select s = new Select(element);
		s.selectByValue(name);
	}

	public static void dropdown_Text(WebElement element, String text) {

		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public static void send_Values(WebElement element, String Values) {

		element.sendKeys(Values);
	}

	
	public static void clickon_Element(WebElement element) {
		element.click();

	}

	public static void single_WindowHandling(WebElement element) {

		String registerpage = driver.getWindowHandle();
		System.out.println(registerpage);

		Set<String> all_ID = driver.getWindowHandles();
		System.out.println(all_ID);

		for (String register_ID : all_ID) {
			if (register_ID.equals(registerpage)) {
				continue;
			} else {
				driver.switchTo().window(register_ID);
			}

		}

	}

	public static void multiple_WindowHandling(String title) {

//			String title = driver.getTitle(url);

		String expected = title;

		Set<String> all_ID = driver.getWindowHandles();
		for (String id : all_ID) {

//				driver.switchTo().window(title);

			if (driver.switchTo().window(id).getCurrentUrl().equals(expected)) {

				break;
			}

			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);

		}
	}

	public static void multiple_WindowhandlingURL(String Url) {

		String elementUrl = Url;		

		Set<String> all_ID = driver.getWindowHandles();
		
		for (String Id : all_ID) {
			
			if (driver.switchTo().window(Id).getCurrentUrl().equalsIgnoreCase(elementUrl)) {
			break;	
			}
		}
		}

	/*public static String get_Particular_Data(String path) throws IOException, InvalidFormatException {

		File f = new File("C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Project_Name\\Get particular data.xlsx");

		FileInputStream fRead = new FileInputStream(f);

		Workbook wb = new XSSFWorkbook(f);

		Sheet sheet = wb.getSheet("Data");

		Row row = sheet.getRow(2);
		Cell cell = row.getCell(1);

		CellType cellType = cell.getCellType();

		if (cellType.equals(CellType.STRING)) {

			path = cell.getStringCellValue();
		}

		else if (cellType.equals(CellType.NUMERIC)) {

			double D = cell.getNumericCellValue();

			int j = (int) D;

			path = String.valueOf(j);

		}
		return path;

	}

	public static String get_Data(String path) throws IOException {

		File f = new File(
				"C:\\Users\\Javed\\eclipse-workspace\\Project_Maven\\Project_Name\\Test Case Project-1(ADACTIN HOTEL RESERVATION).xlsx");

		FileInputStream fRead = new FileInputStream(f);

		Workbook wb = new XSSFWorkbook(fRead);

		Sheet s = wb.getSheetAt(0);

		int No_of_Rows = s.getPhysicalNumberOfRows();

		System.out.println("Rows count:" + No_of_Rows);

		for (int i = 0; i < No_of_Rows; i++) {

			Row row = s.getRow(i);
			// to count the cells
			int no_of_cells = row.getPhysicalNumberOfCells();
			System.out.println("cells count:" + no_of_cells);
			// Nested loop
			for (int j = 0; j < no_of_cells; j++) {
				Cell cell = row.getCell(j);
				// for cellType
				CellType ct = cell.getCellType();
				// STRING AND NUMERIC

				if (ct.equals(CellType.STRING)) {

					String Value = cell.getStringCellValue();
					System.out.print(":" + Value);

				} else if (ct.equals(CellType.NUMERIC)) {

					double d = cell.getNumericCellValue();

					int c = (int) d;

					String valueOf = String.valueOf(c);
					System.out.print(":" + valueOf);

				}

			}
		}

		return path;

	}

	public static String get_Data_excel(String path, int index, int row, int cell)
			throws InvalidFormatException, IOException {

		File f = new File(path);

		FileInputStream fis = new FileInputStream(f);

		Workbook wb = new XSSFWorkbook(f);

		Sheet sheetAt = wb.getSheetAt(index);

		Row row2 = sheetAt.getRow(row);

		Cell cellname = row2.getCell(cell);

		CellType ct = cellname.getCellType();

		if (ct.equals(CellType.STRING)) {
			path = cellname.getStringCellValue();
		} else if (ct.equals(CellType.NUMERIC)) {

			double d = cellname.getNumericCellValue();

			int j = (int) d;

			path = String.valueOf(j);
		}
		return path;
	}

	public static void browser_Close() {

		driver.close();

	}*/

	// mouse over

	public static void mouseOver(WebElement element) {
		try {
			Actions ac = new Actions(driver);

			if (elementisDisplayed(element) && elementisenabled(element)) {
				ac.moveToElement(element).build().perform();
			}

		} catch (Exception e) {
			e.printStackTrace();
			// throw new Exception("if the element is not present");
		}
	}

	// current URL

	public static String getCurrentUrl() throws Exception {
		String currentUrl = null;
		try {
			currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("if Url is not present");
		}
		return currentUrl;
	}

	// scrollIntoView

	public static void scrollIntoView(WebElement elements) {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", elements);

	}

	// scroll
	public static void scroll(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scroll(0,1400)", element);

	}

	public static void highlight_element(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].setAttribute('style','color:Purple')", element);

	}

	// send keys

	public static void setkey(WebElement element, String value) throws Exception {
		try {
			if (elementisDisplayed(element) && elementisenabled(element)) {
				element.clear();
				element.sendKeys(value);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("values are not present");
		}

	}

	// get title

	public static String getTitle() {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}

	// drop down

	public static void dropdown(WebElement element, String value, String i) {
		Select s = new Select(element);

		if (value.equals("index")) {

			s.selectByIndex(Integer.parseInt(i));
		} else if (value.equals("value")) {

			s.selectByValue(value);

		}

		else if (value.equals("text")) {
			s.selectByVisibleText(value);
		}
	}

	// to click

//	public static void clickElement(WebElement element) {
//		try {
//			waitforvisibilityofelment(element);
//			element.click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	// navigate to

	public static void navigateto(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// navigate back

	public static void navigateback() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// navigate forward

	public static void navigateforward() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// navigate refresh

	public static void refresh() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// get Text

	public static void getText(WebElement element) {
		try {
			System.out.println(element.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// get Attribute

	public static void getAttribute(WebElement element) {
		try {
			String attribute = element.getAttribute("Value");
			System.out.println(attribute);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// radio button

	public static void radiobutton(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// get options

	public static void getoptions(WebElement element) {
		Select y = new Select(element);
		List<WebElement> options = y.getOptions();
		for (WebElement y1 : options) {
			System.out.println(y1.getText());
		}
	}

	// first selected option

	public static void firstSelectedOp(WebElement element) {
		Select y = new Select(element);
		WebElement firstSelectedOption = y.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
	}

	// screen shot

	public static void screenshot() throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File saveFile = new File("D:\\eclipse workspace\\Selenium_Day1\\filescreenshot\\suji.png");
		Files.copy(screenshotAs, saveFile);

	}

	// window handles

	public static void Windowhandles(WebElement element) {
		String childid = driver.getWindowHandle();
		element.click();
		Set<String> parentid = driver.getWindowHandles();
		String y = null;
		for (String d : parentid) {
			if (!d.equals(childid)) {
				y = d;
			}
		}
		driver.switchTo().window(y);

	}

	// Alerts

	public static void Alertsss(WebElement element, String var) {
		element.click();
		Alert alert = driver.switchTo().alert();
		if (var == "accept") {
			alert.accept();
			driver.switchTo().defaultContent();
		} else {
			alert.dismiss();
			driver.switchTo().defaultContent();

		}

	}

	public static void Alerts1(WebElement element, String r, String value) {
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);

	}

	// close
	public static void close() {
		driver.close();
	}

	// quit
	public static void browser_Close() {
		driver.close();
	}

	// double click
	public static void Doubleclickkk(WebElement element) {
		Actions ac1 = new Actions(driver);
		ac1.doubleClick(element).build().perform();
	}

	// click
	public static void clickkk(WebElement element) {
		Actions ac2 = new Actions(driver);
		ac2.click(element).build().perform();
	}

	// right click

	public static void rightclick(WebElement element) {
		Actions ac3 = new Actions(driver);
		ac3.contextClick(element).build().perform();

	}

	// send keys using actions
	public static void sendkeysActions(WebElement element, String value) {
		Actions ac4 = new Actions(driver);
		ac4.sendKeys(element, value).build().perform();
	}

	// robot

	public static void robotttt(WebElement element, String value) throws Exception {
		Actions ac = new Actions(driver);
		ac.contextClick(element).build().perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	// drag and drop
	public void dragdrop(WebElement element1, WebElement element2) {

		Actions ac = new Actions(driver);
		ac.dragAndDrop(element1, element2).build().perform();

	}

	// i-Frames

	public static void iframes(WebElement elements) {
		driver.switchTo().frame(elements);

	}

	// explicit wait

	public static void waitExp(WebElement element, long sec) {

		try {
			WebDriverWait wb = new WebDriverWait(driver, sec);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//explicit Wait
	
	
	public static void wait_Explicit() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);
		
		 
	}

	// is displayed

	public static boolean elementisDisplayed(WebElement element) {
		boolean displayed = false;

		try {
			displayed = element.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return displayed;

	}

	public static void moveTOelement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();

	}

	// is enabled

	public static boolean elementisenabled(WebElement element) {
		boolean enabled = false;

		try {
			enabled = element.isEnabled();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enabled;

	}

	// is selected

	public boolean elementisselected(WebElement element) {

		boolean selected = false;
		try {
			selected = element.isSelected();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selected;
	}

}
