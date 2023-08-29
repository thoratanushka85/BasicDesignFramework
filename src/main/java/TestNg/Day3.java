package TestNg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Day3 {
	@Parameters({"URL"})
	@Test
	public void HomeLoan(String urlname) {
		System.out.println(" welcome to home loan");
		System.out.println(urlname);
	}

	@Test
	public void webLoginHomeLoan() {
		System.out.println("welcome home weblogin");
	}

}
