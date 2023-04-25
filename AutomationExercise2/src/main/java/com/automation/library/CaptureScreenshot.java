package com.automation.library;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CaptureScreenshot {
	public static void takeScreenshot(WebDriver driver, String imageName) {
	    try {
	        File theDir = new File("./Screenshots/"); if(!theDir.exists()) {theDir.mkdirs();}
	        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
	        TakesScreenshot screenshot = (TakesScreenshot) driver;
	        		
	        File source = screenshot.getScreenshotAs(OutputType.FILE);
	        File destiny = new File("./Screenshots/" +currentTime+"_"+imageName+".jpg");
	        FileHandler.copy(source, destiny);

	    } catch (Exception ex) {
	        System.out.println("Đã xảy ra lỗi khi chụp màn hình!");
	        ex.printStackTrace();
	    }
	}

}


