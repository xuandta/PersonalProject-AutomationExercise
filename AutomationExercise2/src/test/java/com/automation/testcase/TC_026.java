package com.automation.testcase;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;
import com.automation.library.PageActions;

public class TC_026 extends DriverInstance {
	
    @Test
    public void TC26() throws InterruptedException {
    	driver.get("https://toplist.vn");
    	List<WebElement> list = driver.findElements(By.xpath("//body/div[@class='container']//div[@class='media-body']/h4/a"));
    	list.get(4).click();
    	PageActions action =  new PageActions(driver);
    	action.A_Frame_closeAds();
    	List<WebElement> list2 = driver.findElements(By.xpath("//div[@id=\"col_right\"]//h5[@class=\"media-heading\"]/a"));
    	list2.get(4).click();
    	action.A_Frame_closeAds();
    			
 
    }
}
