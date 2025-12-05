package pom_page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard_page {

	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"ReactContainer\"]/div[1]/header/nav/div/div/ul[2]/li[3]/strong/span") WebElement dropdown;
	@FindBy(xpath="//*[@id=\"ReactContainer\"]/div[1]/header/nav/div/div/ul[2]/li[3]/ul/li[2]/a") WebElement profile;
	
	
	public Dashboard_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void dropdownhandle() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    
	    wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(profile)).click();
	}
	
	
}
