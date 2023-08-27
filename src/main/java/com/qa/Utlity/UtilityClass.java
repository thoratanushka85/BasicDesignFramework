package com.qa.Utlity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class UtilityClass {
	public WebDriver driver;


	@Test

	public static String getDataPF(String Key) throws IOException {

		FileInputStream file = new FileInputStream("C:\\Auto\\Backup\\10-5-23\\capgemini\\Login.properties");

	Properties prop = new Properties();
	prop.load(file);
	 String value = prop.getProperty(Key);
	 return value;


	}

	public static String  getDataFromexcel(int rowindex,int colindex) throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream("C:\\Auto\\Backup\\10-5-23\\capgemini\\TestData\\ValidationMessage.xlsx");
		String data = WorkbookFactory.create(file).getSheet("Sheet1").getRow(rowindex).getCell(colindex).getStringCellValue();
		return data;
	}

	public static void getScreenShot(String Screen,int TestcaseID,WebDriver driver) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//System.out.println(src);
		DateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
		Date date = new Date();

				File Dest = new File("C:\\Auto\\Backup\\10-5-23\\capgemini\\Screenshot\\"+Screen+"-"+dateformat.format(date)+".png");
				//System.out.println(Dest);
				FileHandler.copy(src, Dest);


	}



}
