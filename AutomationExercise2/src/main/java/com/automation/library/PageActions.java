package com.automation.library;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.inject.spi.Element;

public class PageActions {
	WebDriver driver;
	WebDriverWait wait;
	Random random;
	public PageActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		random = new Random();
	}

	public void A_click(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch(Exception e) {
			System.out.println("*******************Exception***************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "PageActions_click");
			Assert.fail();
		}
	}
	
	public void A_JS_ScrollAndClick(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", e);
		js.executeScript("arguments[0].click();", e);
	}
	
	public void A_inputText(WebElement element, String text) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(text);
		} catch(Exception e) {
			System.out.println("*******************Exception***************");
			e.printStackTrace();
//			CaptureScreenshot.takeScreenshot(driver, "PageActions_inputText");
			Assert.fail();
		}
	}
	
	
// -------------------------------------DropDownList ----------------------------------------------
	public void A_selectDropDownByText(WebElement element, String text) {
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(element,text));
			Select select = new  Select(element);
			select.selectByVisibleText(text);
		} catch(Exception e) {
			System.out.println("*******************Exception***************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "PageActions_selectDropDownByText");
			Assert.fail();
		}
	}
	
	public void A_selectDropDownByValue(WebElement element, String value) {
		try {
			String attribute = "value";
			wait.until(ExpectedConditions.attributeToBe(element,attribute,value));
			Select select = new  Select(element);
			select.selectByValue(value);
		} catch(Exception e) {
			System.out.println("*******************Exception***************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "PageActions_selectDropDownByValue");
			Assert.fail();
		}

	}
	public void A_selectDropDownByIndex(WebElement element, int index) {
		try {
			String attribute = "id";
			wait.until(ExpectedConditions.visibilityOf(element));
			Select select = new  Select(element);
			select.selectByIndex(index);
		} catch(Exception e) {
			System.out.println("*******************Exception***************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "PageActions_selectDropDownByIndex");
			Assert.fail();
		}
	}
	
	public void A_selectRandomElement_fromDropDownList(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select = new  Select(element);
		int size = select.getAllSelectedOptions().size();
		int random_intdex = random.nextInt(size);
		select.selectByIndex(random_intdex);
	}

// ----------------------------------Assertequal ---------------------------------------------------
	
	public void A_assertequal(Boolean actual, Boolean expected) {
		try {
			assertEquals(actual, expected);
		} catch(Exception e) {
			System.out.println("*******************Exception***************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "PageActions_A_assertequal");
			Assert.fail();
		}
	}
	
	public void A_assertequal_String(String actual, String expected) {
		try {
			assertEquals(actual, expected);
		} catch(Exception e) {
			System.out.println("*******************Exception***************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "PageActions_A_assertequal");
			Assert.fail();
		}
	}
	
	public void A_assertequal_int(int actual, int expected) {
		try {
			assertEquals(actual, expected);
		} catch(Exception e) {
			System.out.println("*******************Exception***************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "PageActions_A_assertequal");
			Assert.fail();
		}
	}
	
	
// -------------------------------- A_isDisplayed A_isEnabled -----------------------------------------
	public void A_isDisplayed(WebElement element) {
		try {
			assertEquals(element.isDisplayed(),true);
		} catch(Exception e) {
			System.out.println("*******************Exception***************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "PageActions_A_assertequal");
			Assert.fail();
		}
	}
	
	public void A_isEnabled(WebElement element) {
		try {
			assertEquals(element.isEnabled(),true);
		} catch(Exception e) {
			System.out.println("*******************Exception***************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "PageActions_A_assertequal");
			Assert.fail();
		}
	}
	
	public void A_isSelected(WebElement element) {
		try {
			assertEquals(element.isSelected(),true);
		} catch(Exception e) {
			System.out.println("*******************Exception***************");
			e.printStackTrace();
			CaptureScreenshot.takeScreenshot(driver, "PageActions_A_assertequal");
			Assert.fail();
		}
	}

// -----------------------------------Frame Ads Alert Window handle-------------------------------------------------------

	public void A_Frame_closeAds() throws InterruptedException {
		String url = driver.getCurrentUrl();
		if(url.length()<=30){}
		else {
			if(url.substring(url.length()-16).equals("#google_vignette")) {
				List<WebElement> frames = driver.findElements(By.tagName("iframe"));
				driver.switchTo().frame(frames.get(frames.size()-1)); 
				if(driver.findElement(By.xpath("//div[@class='toprow']/div")).getAttribute("id").equals("dismiss-button")) {driver.findElement(By.xpath("//div[@class='toprow']/div")).click();}
				else {driver.switchTo().frame(driver.findElement(By.tagName("iframe")));driver.findElement(By.xpath("//div[@id='dismiss-button']/div")).click();}
				driver.switchTo().defaultContent();
			}
		}
	}
	
	
	public void A_Frame_getAllIdFrame() {
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		for (WebElement frame : frames) {
		    System.out.println("ID of Frame: " + frame.getAttribute("id"));
		}
	}
	
	public void A_CloseAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.dismiss(); // alert.accept(); // alert.dismiss();
	}
	
	public void A_AcceptAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept(); // alert.accept(); // alert.dismiss();
	}
	
	public void A_closeOtherWindow() {
		String mainHandle = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();
		for (String currentHandle : allHandles) {
		  if (!currentHandle.equals(mainHandle)) {
		    driver.switchTo().window(currentHandle);
		    driver.close();
		  }
		}
		driver.switchTo().window(mainHandle);
	}
	
	
// ---------------------------------- get Random ---------------------------------
	public String A_getRandom_Email() {
		 String prefix = "user";
		 String suffix = "@example.com";
		 String randomString = RandomStringUtils.randomAlphanumeric(10);
		 return prefix + randomString + suffix;
	}
	
	public String A_getRandom_Phone() {
		String phone = RandomStringUtils.random(10, false, true);
		return phone;
	}
	
	public String A_getRandomUsername() {
		String username = RandomStringUtils.randomAlphanumeric(8, 12);
		return username;
	}
	public String A_getRandomFirstNameVN() {
		String[] FirstName = { "Đức Anh", "Thúy An", "Việt Anh", "Thành An", "Thanh Bình", "Thúy Bình", "Thuỳ Chi", "Hồng Đào", "Văn Dũng", "Thái Dương", "Lan Hương", "Thùy Hương", "Văn Hùng", "Hữu Khuê", "Văn Khương", "Thị Kim", "Văn Lâm", "Hồng Loan", "Mỹ Linh", "Quang Minh", "Mỹ Nga", "Hồng Nhung", "Thiên Quang", "Ngọc Quyên", "Hồng Sơn", "Hoàng Thái", "Thiện Thanh", "Hồng Thắm", "Thị Thảo", "Thanh Tùng", "Thế Vinh", "Hoàng Vũ", "Hoàng Yến", "Đăng Dũng", "Thuỳ Dương", "Minh Giang", "Thái Hà", "Hồng Hạnh", "Thị Hải", "Ngọc Hoa", "Văn Hòa", "Đức Hòa", "Văn Hưng", "Hữu Hưng", "Quang Huy", "Thanh Huyền", "Thị Huệ", "Văn Khai", "Văn Khánh", "Tố Loan", "Thị Lý", "Xuân Mai", "Thị Nguyệt", "Hoàng Oanh", "Thuyền Phương", "Hữu Phương", "Thị Phương", "Như Quỳnh", "Thiên Quốc", "Thuỳ Trang", "Lan Trinh", "Thiên Trường", "Đức Tùng", "Vũ Tùng", "Văn Vương", "Văn Xuân", "Ngọc Yến", "Thị Yến", "Lê Anh", "Thị Bình", "Mai Châu", "Đăng Cường", "Thuận Dung", "Quang Đông", "Ngọc Gia", "Ngọc Hải", "Minh Hằng", "Hồ Hồng", "Tấn Hưng", "Đức Khương", "Thiên Kim", "Văn Linh", "Mai Linh", "Minh Long", "Thành Lợi", "Văn Nam", "Quốc Nhân", "Phương Nhi", "Đăng Phú", "Minh Phúc", "Huyền Phương", "Ngọc Quang", "Ngọc Sơn", "Thành Tâm", "Vân Thanh", "Văn Thành", "Phương Thu", "Hồng Thuận", "Thanh Tú", "Hữu Tuấn", "Thuỳ Uyên", "Hữu Vĩnh", "Minh Vương" };
		return FirstName[random.nextInt(FirstName.length-1)];
	}
	
	public String A_getRandomLastNameVN() {
		String[] LastName_VN = {"Nguyễn", "Trần", "Lê", "Phạm", "Hoàng", "Phan", "Vũ", "Đặng", "Bùi", "Đỗ", "Hồ", "Ngô", "Dương", "Lý", "Lương", "Mai", "Trịnh", "Đinh", "Vương", "Trương"};
		return LastName_VN[random.nextInt(LastName_VN.length-1)];
	}
	
	public String A_getRandomFirstNameEN() {
		String[] firstNameEN = {"James", "Emma", "William", "Olivia", "Noah", "Ava", "Liam", "Sophia", "Elijah", "Isabella", "Logan", "Mia", "Mason", "Charlotte", "Ethan", "Amelia", "Lucas", "Harper", "Jacob", "Evelyn", "Aiden", "Abigail", "Jackson", "Emily", "Caden", "Ella", "Grayson", "Madison", "Connor", "Scarlett", "Carter", "Luna", "Henry", "Chloe", "Max", "Lily", "Isaac", "Avery", "Alexander", "Leah", "Sebastian", "Sofia", "Michael", "Grace", "Benjamin", "Hazel", "Caleb", "Nora", "Ryan", "Aria"};
		return firstNameEN[random.nextInt(firstNameEN.length-1)];
	}
	
	public String A_getRandomLastNameEN() {
		String[] lastNamesEN = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Davis"};
		return lastNamesEN[random.nextInt(lastNamesEN.length-1)];
	}
	
	public String A_getRandomZipcode() {
		String[] zipCodes = {"90210", "10001", "60601", "02108", "33109", "90001", "98101", "80202", "60611", "75201", "20001", "02109", "10019", "92101", "94108", "90266", "90277", "92660", "90292", "90291", "90293", "90405", "90402", "90069", "90272", "90403", "90404", "90401", "90407", "90411"};
		return zipCodes[random.nextInt(zipCodes.length-1)];
	}
	
	
	public int A_getRandom_int(int min, int max) {
		Random random = new Random();
		return random.nextInt(max-min+1)+min;
	}
	
	public Boolean A_getRandom_boolean() {
		Boolean randomBoolean = random.nextBoolean(); return randomBoolean;
	}

 // --------------------------------------- get / select List Webelements ------------------------

	
	public WebElement A_getElementFromList(String xpath,int index) {
		List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		return elements.get(index);
	}
	
	public void A_selectElementFromList(String xpath,int index) {
		List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		elements.get(index).click();
	}	
	
	public void A_selectRandomElement_FromListByXpath(String xpath) {
		List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		Random random = new Random();
		int i = random.nextInt(elements.size());
		elements.get(i).click();
	}	
	
	public void A_SelectRandomElement_FromListWebElement(List <WebElement> ListWebElement) {
		int size = ListWebElement.size();
		int randomIndex = A_getRandom_int(0, size-1);
		ListWebElement.get(randomIndex).click();
	}
	
// --------------------------------------------Test function Radio & Multi  checkbox -----------------------	
	public void A_testFunctionRadio(String xpath) {
		List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		for(WebElement i: elements) {
			i.click();
			for(WebElement j: elements) {
				if(j==i) {assertEquals(j.isSelected(), true);}
				else {assertEquals(j.isSelected(), false);}
			}
			
		}
		
	}
	
	public void A_testFunctionMulCheckbox(String xpath) {
		List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		for(WebElement i: elements) {i.click(); assertEquals(i.isSelected(), true);}
		for(WebElement i: elements) {i.click(); assertEquals(i.isSelected(), false);}
	}
	
// -------------------------Convert File Excel to Object ---------------------------------------------
// --------- Declare: @DataProvider(name="") -------------- use:@Test(dataProvider = "")--------------
    public Object A_ConvertExcelToObject_TitleOnFirstRow(String FilePath, String SheetName) throws IOException{
	   FileInputStream file = new FileInputStream(FilePath);
	   XSSFWorkbook Workbook = new XSSFWorkbook(file);
	   XSSFSheet s0 = Workbook.getSheet(SheetName);
	   int numberOfRow  = s0.getPhysicalNumberOfRows();
	   int numberOfCell = s0.getRow(0).getPhysicalNumberOfCells(); 
	   Object [][] data = new Object[numberOfRow][numberOfCell];
	   for (int row = 1; row < numberOfRow; row++){
		   for(int cell = 0; cell < numberOfCell;cell++) {
			   data[row-1][cell] = s0.getRow(row).getCell(cell).getStringCellValue();
		   }
	   }
	   return data;
   }
   
    public Object A_ConvertExcelToObject_DataOnFirstRow(String FilePath, String SheetName) throws IOException{
	   FileInputStream file = new FileInputStream(FilePath);
	   XSSFWorkbook Workbook = new XSSFWorkbook(file);
	   XSSFSheet s0 = Workbook.getSheet(SheetName);
	   int numberOfRow  = s0.getPhysicalNumberOfRows();
	   int numberOfCell = s0.getRow(0).getPhysicalNumberOfCells(); 
	   Object [][] data = new Object[numberOfRow][numberOfCell];
	   for (int row = 1; row < numberOfRow; row++){
		   for(int cell = 0; cell < numberOfCell;cell++) {
			   data[row][cell] = s0.getRow(row).getCell(cell).getStringCellValue();
		   }
	   }
	   return data;
   }
   
    
    public Object A_ConvertExcelToObject_FromTo(String FilePath, String SheetName, int StartRow, int EndRow) throws IOException{
    	//---------->>	RowBegin, RowEnd is number in Excel 	
    	FileInputStream file = new FileInputStream(FilePath);
    	XSSFWorkbook Workbook = new XSSFWorkbook(file);
    	XSSFSheet s0 = Workbook.getSheet(SheetName);
    	int numberOfRow  = s0.getPhysicalNumberOfRows();
    	int numberOfCell = s0.getRow(0).getPhysicalNumberOfCells(); 
    	Object [][] data = new Object[numberOfRow][numberOfCell];
    	for (int row = StartRow -1 ; row < EndRow; row++){
		   for(int cell = 0; cell < numberOfCell;cell++) {
			   data[row][cell] = s0.getRow(row).getCell(cell).getStringCellValue();
		   }
	   }
	   return data;
   } 
	
	public void A_CreateExcel(String FilePath) throws FileNotFoundException {
		FileOutputStream file = new FileOutputStream(FilePath);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
	}
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();
		  for (int i = 0; i < dirContents.length; i++) {
		      if (dirContents[i].getName().equals(fileName)) {
		          dirContents[i].delete();
		          return true;
		      }
		   }
		      return false;
		  }
	
	
	
}
	
//try {
//
//} catch(Exception e) {
//	System.out.println("*******************Exception***************");
//	e.printStackTrace();
//	CaptureScreenshot.takeScreenshot(driver, "RegisterPage");
//	Assert.fail();
//}

//public void takeScreenShot(ITestResult result)throws Exception {
//	if(ITestResult.FAILURE == result.getStatus()) {
//		String email = (String) result.getParameters()[0];
//		int index = email.indexOf("@");
//		String accountName = email.substring(0, index);
//		ScreenShots.takeScreeShot(driver, accountName);
//		ScreenShots.attachScreenShot(accountName);
//	}
//}