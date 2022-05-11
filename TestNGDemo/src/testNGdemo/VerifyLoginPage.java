package testNGdemo;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class VerifyLoginPage {
	WebDriver driver;
	
  @Test(dataProvider = "loginDataProvider")
  public void testcase(String uname, String pass) throws InterruptedException {
	  
	  String chromePath = "D:\\ZsnrJavaWorkspace\\TestNGDemo\\BrowserDriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromePath);

		WebDriver driver = new ChromeDriver();
		
		//respective command to load a new web page can be written
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	  
	  WebElement n =  driver.findElement(By.id("username"));
	    n.sendKeys(uname);
	    Reporter.log(uname);
	    Thread.sleep(2000);
		WebElement p = driver.findElement(By.id("password"));
		p.sendKeys(pass);
		Reporter.log(pass);
		Thread.sleep(2000);
		
		driver.findElement(By.id("submit")).click();
		
		System.out.println("Login Successfully Testcse pass");
		System.out.println("Login Username = "+uname);
		System.out.println("Login Password = "+pass);
		Thread.sleep(2000);
		driver.quit();
  }

  @DataProvider
  public Object[][] loginDataProvider() {
    return new Object[][] {
      new Object[] { "student", "Password123" },
      new Object[] { "student", "Password123" },
    };
  }
}
