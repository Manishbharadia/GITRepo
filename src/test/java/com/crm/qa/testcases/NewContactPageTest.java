package com.crm.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.LoginPage;
import com.crm.qa.util.TestUtil;

@Listeners
public class NewContactPageTest extends TestBase {

	LoginPage login;

	@BeforeMethod
	public void test() {
		initializebrowser();
		login = new LoginPage();
	}

	@Test(dataProvider = "getTestData123")
	public void createContact(String title, String fname, String lname, String compny) {
		login.Login(getPropertyValue("username"), getPropertyValue("password")).clickNewContactLink()
				.createNewContact(title, fname, lname, compny);
		assertTrue(false);
	}

	@DataProvider(name = "getTestData123")
	public Object[][] getTestData() {
		TestUtil test = new TestUtil();
		Object[][] data = test.getTestData("testdata");
		return data;
	}

}
