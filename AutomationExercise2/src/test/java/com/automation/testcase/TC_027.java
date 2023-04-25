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

public class TC_027 extends DriverInstance {
	
    @Test
    public void TC27() throws InterruptedException {
    	try {
	        driver.get("https://demo.guru99.com/V4/");
	        Thread.sleep(2000);
	        driver.findElement(By.name("uid")).sendKeys("mngr484782");
	        driver.findElement(By.name("password")).sendKeys("nEzarEs");
	        driver.findElement(By.name("btnLogin")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.linkText("New Customer")).click();
	        Thread.sleep(2000);

	        //Get element in frame by ID
	        WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
	        //Switch to frame with element
	        driver.switchTo().frame(frame1);
	        //Check button X or Close displays
	        List < WebElement > checkButtonX = driver.findElements(By.xpath("//div[@id='dismiss-button']"));
	        System.out.println("checkButtonX: " + checkButtonX.size());
	        if (checkButtonX.size() > 0) {
	            driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
	        } else {
	            WebElement frame2 = driver.findElement(By.id("ad_iframe"));
	            driver.switchTo().frame(frame2);
	            Thread.sleep(1000);
	            List < WebElement > checkButtonClose = driver.findElements(By.xpath("//div[@id='dismiss-button']//span[normalize-space()='Close']"));
	            System.out.println("checkButtonClose: " + checkButtonClose.size());
	            if (checkButtonClose.size() > 0) {
	                driver.findElement(By.xpath("//div[@id='dismiss-button']//span[normalize-space()='Close']")).click();
	            } else {
	                driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
	            }
	        }

	        driver.switchTo().defaultContent();
	        Thread.sleep(2000);
	    } catch (Exception e) {e.printStackTrace();}
    			
 
    }
}
