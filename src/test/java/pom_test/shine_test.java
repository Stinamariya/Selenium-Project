package pom_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base_pkg.Base_class;
import pom_page.Dashboard_page;
import pom_page.Login_page;
import pom_page.Logout_page;
import pom_page.Order_page;
import pom_page.Profile_page;
import utilities.Excelutils;

public class shine_test extends Base_class {

	@Test
	public void shineauto() throws Exception {
		Login_page obj = new Login_page(driver);

		String xl = "C:\\Users\\pauln\\OneDrive\\Desktop\\Shineautomation.xlsx";
		String Sheet = "Login";
		int rowCount = Excelutils.getRowCount(xl, Sheet);
		System.out.println(rowCount);
		for (int i = 1; i <= rowCount; i++) {

			Thread.sleep(2000);

			String Email = Excelutils.getCellValString(xl, Sheet, i, 0);

			System.out.println("Email---" + Email);

			String Password = Excelutils.getCellValString(xl, Sheet, i, 1);
			System.out.println("password---" + Password);

			obj.setvalues(Email, Password);

			obj.login();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.urlContains("shine.com"));

			if (driver.getCurrentUrl().contains("/myshine/mydashboard/")) {

				System.out.println("Login successful for " + Email);

				Dashboard_page ob = new Dashboard_page(driver);
				ob.dropdownhandle();

				Profile_page ob2 = new Profile_page(driver);
				ob2.upload("C:\\Users\\pauln\\Downloads\\Demo.pdf");

				ob2.ordersection();

				Order_page ob3 = new Order_page(driver);
				ob3.browseorders();
				ob3.screenshot();

				Logout_page ob5 = new Logout_page(driver);
				ob5.performlogout();
				System.out.println("Logout successfully");
			} else {

				System.out.println("Login failed for " + Email);
				driver.get("https://www.shine.com/myshine/login/");
			}
		}
	}
}
