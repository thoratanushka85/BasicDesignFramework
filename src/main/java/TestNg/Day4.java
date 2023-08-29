package TestNg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {
	@Test(groups ="smoke")
	public void carloan() {
		System.out.println("welcome to car loan");
	}

	@Test(timeOut =4000)
	public void webLoginCarLoan() {
		System.out.println(" in selenium");
	}

	@Test(groups="smoke")
	public void MobileLoginCarLoan() {
		System.out.println(" welcome to appium");
	}

	@Test
	public void MobilesignIn() {
		System.out.println(" welcome to appium1");
	}
	@Test(dependsOnMethods ={"MobilesignIn"})
	public void MobileSignout() {
		System.out.println(" welcome to appium2");
	}


	@Test(enabled =false)
	public void MobileLogin() {
		System.out.println(" welcome to appium1");
	}

	@Test(enabled=false)
	public void MobileLogout() {
		System.out.println(" welcome to appium");
	}

    @Parameters({"URL"})
	@Test
	public void APIRestLogin(String namevalue) {
		System.out.println("api login");
		System.out.println(namevalue);
	}
}
