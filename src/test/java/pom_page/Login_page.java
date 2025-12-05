package pom_page;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login_page {

	
	WebDriver driver;
	
	
	@FindBy(xpath="//*[@id=\"id_email_login\"]") WebElement mail;
	@FindBy(xpath="//*[@id=\"id_password\"]") WebElement pass;
	@FindBy(xpath="//*[@id=\"cndidate_login_widget\"]/form/ul[2]/li[4]/div/button") WebElement btn;
	
	public Login_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void setvalues(String email,String password)
	{
		mail.clear();
		pass.clear();
		mail.sendKeys(email);
		pass.sendKeys(password);
	}
	
	
	
	public void login() throws Exception
	{
		btn.click();
		Thread.sleep(3000);
		
		String expurl="https://www.shine.com/myshine/mydashboard/";
		String actualurl=driver.getCurrentUrl();
		System.out.println(actualurl);
		if(expurl.equals(actualurl))
		{
			System.out.println("Login successfull");
		}
		else
		{
			System.out.println("Login failed");
			driver.navigate().refresh();
		}
	}
}
