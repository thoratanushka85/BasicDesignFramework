package com.qa.TestClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandaloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebdriverManager.Chromedriver().setup();
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--remote-aalow-origin");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("cricket1285@gamil.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Cricket@1234");
		driver.findElement(By.xpath("//*[@id='login']")).click();
		List<WebElement>products= driver.findElements(By.cssSelector(".mb-3"));
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(null)));

	}

}
