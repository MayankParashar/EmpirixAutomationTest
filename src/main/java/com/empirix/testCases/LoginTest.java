package com.empirix.testCases;

import org.testng.annotations.Test;

import com.empirix.pageObjectRepository.LoginPage;
import com.utilities.BaseLib;
import com.utilities.Log;

import utils.load.dataSource.ExcelLib;

public class LoginTest extends BaseLib {
	@Test(priority = 1)
	public void ValidLoginTest() {
		Log.startLog("loginTest");
		// (1 row 2 cell read User Name from testdata)
		String username = ExcelLib.getExcelData(inputTestDataSheet, "TestData", 1, 0);
		Log.info(username +" is fetched from excel");
		// (1 row 2 cell read Password from testdata)
		String password = ExcelLib.getExcelData(inputTestDataSheet, "TestData", 1, 1);
		Log.info(password +" is fetched from excel");
		
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
		lp.verifyLoginPage();
	}

}
