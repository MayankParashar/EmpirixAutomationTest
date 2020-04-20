package com.empirix.pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.Log;

public class LoginPage {
	
	@FindBy(xpath = "//label[(text()=' Username ')]/..//input")
	private WebElement unTxtBx;
	
	@FindBy(xpath = "//label[(text()=' Password ')]/..//input")
	private WebElement pwdTxtBx;
	
	@FindBy(xpath = "//input[@value='Sign in']")
	private WebElement signBtn;
		
	@FindBy(xpath = "//a[@id='logo']")
	private WebElement validLoginMsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) // usable method
	{
		unTxtBx.sendKeys(username);
		pwdTxtBx.sendKeys(password);
		signBtn.click();
	}

	public void verifyLoginPage()
	{
		boolean flag = validLoginMsg.isDisplayed();
		if(flag) {
			Log.debug("Login Pass");
		}
		else {
			Log.error("Login Failed");
		}
	}
}
