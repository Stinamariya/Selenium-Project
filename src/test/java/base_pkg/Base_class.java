package base_pkg;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base_class {

	
	public static WebDriver driver;

	@BeforeTest
	public void setup()
	{
		
		driver=new ChromeDriver();
		driver.get("https://www.shine.com/myshine/login/");
		driver.manage().window().maximize();
		
	}
	
	


	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
