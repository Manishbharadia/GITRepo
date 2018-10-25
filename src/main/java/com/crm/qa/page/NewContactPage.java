package com.crm.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;;

public class NewContactPage extends TestBase {

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "surname")
	WebElement lastName;

	@FindBy(xpath = "//input [@value = 'Save']")
	WebElement saveButton;

	@FindBy(name = "client_lookup")
	WebElement companyName;

	public void createNewContact(String title, String fname, String lName, String cmpnyname) {
		Select sel = new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lName);
		companyName.sendKeys(cmpnyname);
		saveButton.click();
	}

	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}

}
