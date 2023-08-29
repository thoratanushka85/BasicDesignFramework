package com.qa.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "//input[@id='email']")
	private WebElement txt_EmailId;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement txt_Password;

	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement btn_Login;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enteremailId(String EmailId) {
		txt_EmailId.sendKeys(EmailId);
	}

	public void enterPassword(String pass) {
		txt_Password.sendKeys(pass);

	}

	public void ClickloginButton() {
		btn_Login.click();
	}

}
