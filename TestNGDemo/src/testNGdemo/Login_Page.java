package testNGdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
	
	WebDriver driver;
	public Login_Page(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	}
	public void verify_Login() {
		
	    WebElement uname =  driver.findElement(By.id("username"));
	    uname.sendKeys("student");
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("Password123");
		
		driver.findElement(By.id("submit")).click();
		
		System.out.println("Login Successfully Testcse pass");
		System.out.println("Login Username = "+uname);
		System.out.println("Login Password = "+pass);
		

	}

}
