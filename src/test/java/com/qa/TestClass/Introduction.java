package com.qa.TestClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

public class Introduction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "Rahul";
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		//WebDriver driver = new ChromeDriver(options);

		//FirefoxOptions options = new FirefoxOptions();
		//options.addArguments("--remote-allow-origins=*");
		//WebDriver driver = new FirefoxDriver(options);

		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver =  new EdgeDriver(options);




		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = getpassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name=\"inputPassword\"]")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Hello "+name+",");
		driver.findElement(By.xpath("//*[text()= 'Log Out']")).click();
		driver.close();



	}
	public static String getpassword(WebDriver driver) throws InterruptedException {

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String passwordtext= driver.findElement(By.cssSelector("p.infoMsg")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordarray= passwordtext.split("'");
		String password = passwordarray[1].split("'")[0];
		return password;
	}

}
