package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.LoginPage;

public class ContactPageTest extends TestBase {
	LoginPage login;

	// @BeforeTest
	public void setUP() {
		initializebrowser();
		login = new LoginPage();
		login.Login(getPropertyValue("username"), getPropertyValue("password"));
	}

	@Test
	public void addContact() {
		System.out.println("test");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
