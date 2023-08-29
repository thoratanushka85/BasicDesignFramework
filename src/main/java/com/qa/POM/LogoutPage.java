package com.qa.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	@FindBy(xpath = "//*[text()='udaychavan12@gmail.com']")
	private WebElement label_EmailId;

	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement btn_Logout;

	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getEmailId() {
		String EmailId = label_EmailId.getText();
		return EmailId;
	}

	public void logout() {
		btn_Logout.click();
	}
}
