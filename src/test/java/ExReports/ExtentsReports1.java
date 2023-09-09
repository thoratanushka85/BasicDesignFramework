package ExReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentsReports1 {
	ExtentReports extent;

	@BeforeTest
//required two clasess ExtentsReports ExtentSparkReporter
	public void config() {

	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automations Results");
	reporter.config().setDocumentTitle("Test Results");
     extent = new ExtentReports();
    extent.attachReporter(reporter);
    extent.setSystemInfo("Tester", "Anushka Thorat");



	}






@Test
public void DemoTest() {
	ExtentTest test= extent.createTest("Demo Test");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins");
	WebDriver driver = new ChromeDriver(options);
	driver.get("https://rahulshettyacademy.com/");
	System.out.println(driver.getTitle());
	driver.close();
	test.fail(" test does not match");

	extent.flush();

}
}
