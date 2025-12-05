package pom_page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Profile_page {

	
	WebDriver driver;
	

	@FindBy(xpath="//*[@id=\"__next\"]/div[4]/div/div/div[2]/div[3]/div[1]/button/span") WebElement uploadResume;
	@FindBy(xpath="//*[@id=\"webHeaderNova\"]/div/div/div[3]/div[2]/a/img") WebElement icon;
	@FindBy(xpath="//*[@id=\"webHeaderNova\"]/div/div/div[3]/div[2]/div/ul/li[2]/a/span[2]") WebElement order;
	
	
	
	
	public Profile_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void upload(String p) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(uploadResume)).click();

		StringSelection strSelection=new StringSelection(p);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
		
		Robot rob=new Robot();
		rob.delay(3000);
		
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_V);
		
		rob.keyRelease(KeyEvent.VK_CONTROL);
		
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
	}
	
	
	
	public void ordersection()
	{
		icon.click();
		order.click();
	}
	
	
	
}
