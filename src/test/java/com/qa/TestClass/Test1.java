package com.qa.TestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.Base;
import com.qa.POM.LoginPage;
import com.qa.POM.LogoutPage;
import com.qa.Utlity.UtilityClass;

public class Test1 extends Base {
	LoginPage loginpage;
	LogoutPage logoutpage;
	int TestcaseID;

	@BeforeClass

	public void openBrowser() {

		// initializeBrowser();
		loginpage = new LoginPage(driver);
		logoutpage = new LogoutPage(driver);

	}

	@BeforeMethod

	public void login() throws IOException {

		loginpage.enteremailId(UtilityClass.getDataPF("EmailId"));
		loginpage.enterPassword(UtilityClass.getDataPF("password"));
		loginpage.ClickloginButton();
	}

	@Test(priority = 1)
	public void validateEmailId() throws EncryptedDocumentException, IOException {
		TestcaseID = 1;
		String ActulaEmailId = logoutpage.getEmailId();
		String ExpEmailId = UtilityClass.getDataFromexcel(0, 0);
		Assert.assertEquals(ActulaEmailId, ExpEmailId);

	}

	@Test(priority = 2)
	public void validateTitle() throws EncryptedDocumentException, IOException {
		TestcaseID = 2;
		String ActualTile = driver.getTitle();
		System.out.println(ActualTile);
		String ExpectedTitle = UtilityClass.getDataFromexcel(1, 0);
		Assert.assertEquals(ActualTile, ExpectedTitle);

	}

	@AfterMethod()
	public void captureScreenshot(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			UtilityClass.getScreenShot("Screen", TestcaseID, driver);
			System.out.println("test case is fail");
			logoutpage.logout();
		} else {
			UtilityClass.getScreenShot("Screen", TestcaseID, driver);
			System.out.println("test case is pass");
			logoutpage.logout();
		}
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
		// driver.quit();
	}

}
