package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage login;

	@BeforeMethod
	public void test() {
		initializebrowser();
		login = new LoginPage();
	}

	@Test
	public void Login() {
		login.Login(getPropertyValue("username"), getPropertyValue("password"));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
