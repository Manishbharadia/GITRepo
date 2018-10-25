package com.crm.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[@title = 'Contacts']")
	WebElement contactLink;

	@FindBy(xpath = "//a[@title = 'Contacts']")
	WebElement dealstLink;

	@FindBy(xpath = "//a[@title = 'New Contact']")
	WebElement NewContactLink;

	public ContactPage clickContactLink() {
		driver.switchTo().frame("mainpanel");
		contactLink.click();
		return new ContactPage();
	}

	public DealsPage clickDealsLink() {
		dealstLink.click();
		return new DealsPage();
	}

	public NewContactPage clickNewContactLink() {
		driver.switchTo().frame("mainpanel");
		Actions howvertoContactLink = new Actions(driver);
		howvertoContactLink.moveToElement(contactLink).build().perform();
		NewContactLink.click();
		return new NewContactPage();
	}

	public HomePage() {
		PageFactory.initElements(driver, this); // To initialize all the webelement which are found by @FindBy //
												// annotation
	}

}
