package com.empirix.pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LangChangePage {

	@FindBy(xpath = "//a[contains(text(),'QA_traininguser')]")
	private WebElement qa_training_drpdwn;

	@FindBy(xpath = "//a[contains(text(),'Japanese')]")
	private WebElement japLnkBtn;

	@FindBy(xpath = "//a[contains(text(),'English')]")
	private WebElement engLnkBtn;

	public LangChangePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void japlang() // usable method
	{
		qa_training_drpdwn.click();
		japLnkBtn.click();
	}
	
	public void englang() // usable method
	{
		qa_training_drpdwn.click();
		engLnkBtn.click();
	}
	
}
