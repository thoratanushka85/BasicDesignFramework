package TestNg;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerConfiguration implements ITestListener {

	public void onTestSuccess(ITestResult result) {
		System.out.println(" I sucessfully executed listner test cases");

	}
	
	public void onTestFailure(ITestResult result) {
		//System.out.println("test is failue on listners");
	}

}
