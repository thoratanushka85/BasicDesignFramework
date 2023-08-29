package com.qa.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class Base {
	public WebDriver driver;

	String browsername = "chrome";

	@BeforeClass

	public void initializeBrowser() {

		if (browsername.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("start-maximized");
			// driver = new ChromeDriver(options);
			driver = new ChromeDriver(options);

			driver.navigate().to("https://www.demo.guru99.com/insurance/v1/index.php");
		}

		else if (browsername.equalsIgnoreCase("firefox")) {

			// ChromeOptions options = new ChromeOptions();
			// options.addArguments("start-maximized");
			driver = new FirefoxDriver();
		} else {
			EdgeOptions options = new EdgeOptions();

			options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options);
		}

	}
}
