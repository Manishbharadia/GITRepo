package com.crm.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;

	public HomePage Login(String username, String pwd) {
		userName.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
}
