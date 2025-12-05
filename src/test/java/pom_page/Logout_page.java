package pom_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout_page {

	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"__next\"]/header/div[2]/div/div/div[2]/div[1]/div") WebElement profileicon;
	@FindBy(xpath="//*[@id=\"__next\"]/header/div[2]/div/div/div[2]/div[1]/ul/li[4]/a") WebElement logoutbtn;
	
	
	public Logout_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void performlogout() throws Exception
	{
		Thread.sleep(2000);
		profileicon.click();
		logoutbtn.click();
	}
}
