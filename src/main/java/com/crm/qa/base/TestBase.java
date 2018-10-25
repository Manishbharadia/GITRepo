package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.AllEventListner;
import com.crm.qa.util.TestUtil;

public class TestBase extends TestUtil { // to check which class it import

	public static WebDriver driver;

	public static String getPropertyValue(String propertyName) {
		String ConfigFilePath = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\crm\\qa\\config\\config.properties";
		FileInputStream propFile = null;
		Properties prop = new Properties();
		try {
			propFile = new FileInputStream(ConfigFilePath);
			prop.load(propFile);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}

		return prop.getProperty(propertyName);
	}

	public static void initializebrowser() {
		if (getPropertyValue("browser").equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Selenium Installations\\Selinium 3.0\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

			EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
			AllEventListner alleventlistner = new AllEventListner();
			eventDriver.register(alleventlistner);
			driver = eventDriver;
		}
		// else if (getPropertyValue("browser").equals("FIREFOX"))
		// {
		// driver = new FirefoxDriver();
		// }

		driver.get(getPropertyValue("URL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(APGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(500, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

}
