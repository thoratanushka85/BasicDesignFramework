package TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {

	@Test(dataProvider = "getData")
	public void login(String username, String password) {
		System.out.println("welcome to rahul shetty");
		System.out.println(username);
		System.out.println(password);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] Data = new Object[3][2];
		// ist username and password
		Data[0][0] = "user1";
		Data[0][1] = "password";
		// 2nd type data
		Data[1][0] = "user2";
		Data[1][1] = "password2";
		// 3rd type of data
		Data[2][0] = "user3";
		Data[2][1] = "passowrd3";
		return Data;

	}

}
