package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;

public class TestClass extends TestBase {

	@BeforeMethod
	public void test() {
		initializebrowser();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
