package pom_page;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Order_page {

	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"__next\"]/header/div[3]/ul/li[4]/a") WebElement courses;
	@FindBy(xpath="//*[@id=\"__next\"]/header/div[3]/ul/li[4]/ul/li[5]/a") WebElement viewall;
	@FindBy(xpath="//*[@id=\"__next\"]/main/div[1]/div/div[1]/div/div/ul/li[1]/button") WebElement filter;
	@FindBy(xpath="//*[@id=\"freshness\"]") WebElement price;
	@FindBy(xpath="//*[@id=\"19\"]") WebElement category;
	@FindBy(xpath="//*[@id=\"__next\"]/main/div[1]/div/div[1]/div/div[2]/div/div/div/div[4]/button[2]") WebElement showresult;
	@FindBy(xpath="//*[@id=\"__next\"]/main/div[1]/div/div[2]/div/div[1]/div[2]/a[2]") WebElement buynowbtn;
	@FindBy(xpath="//*[@id=\"__next\"]/main/div/div/div/div/div[2]/div[3]/a") WebElement proceedtobuy;

	
	public Order_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void browseorders() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions act=new Actions(driver);
		act.moveToElement(courses).perform();
		wait.until(ExpectedConditions.visibilityOf(viewall));

     
        viewall.click();
        Thread.sleep(3000);
        filter.click();
        Thread.sleep(2000);
        
        if (!price.isSelected()) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", price);
        }


        if (!category.isSelected()) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", category);
        }
        showresult.click();
        buynowbtn.click();
        driver.navigate().back();
	}
	
	public void screenshot() throws Exception
	{
		File s=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(s,new File("C:\\Users\\pauln\\OneDrive\\Desktop\\SELENIUM WORKS\\Screenshot\\shine.png"));
		System.out.println("Screenshot saved successfully");
	}
}
