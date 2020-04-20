package com.empirix.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.empirix.pageObjectRepository.LangChangePage;
import com.empirix.pageObjectRepository.LoginPage;
import com.utilities.BaseLib;

public class LangChangeTest extends BaseLib {

	@Test(priority = 1)
	public void ValidLoginTest() {
		// String filePath = "./testdata/testdata.xlsx";
		// String username = ExcelUtilities.readData(filePath, "Sheet1", 1, 1); //(1 row
		// 2 cell read admin from testdata)
		// String password = ExcelUtilities.readData(filePath, "Sheet1", 1, 2); //(1 row
		// 3 cell read manager from testdata)
		String username = "QA_traininguser25";
		String password = "Empirix!";
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
		lp.verifyLoginPage();

		LangChangePage lc = new LangChangePage(driver);
		lc.japlang();
		lc.englang();
	}
}
