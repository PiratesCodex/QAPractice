package testNGpractice;

import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import excelUtility.ExcelReader;

public class AnnotationsDemo {

	public WebDriver driver;
	ExcelReader er;
	public String url = "https://www.lambdatest.com/";

	@BeforeSuite
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SP67139\\git\\QAPractice\\TestNGDemo\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		String path = "C:\\Users\\SP67139\\git\\QAPractice\\TestNGDemo\\DataSource\\TestNGData.xlsx";
		er = new ExcelReader(path);
		Reporter.log("The Browser is Open now");
	}

	@BeforeTest
	public void profileSetup() {
		driver.manage().window().maximize();
		
		//implicit wait 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("The profile setup process is completed");

	}

	@BeforeClass
	public void appSetup() {
		driver.get(url);
		Reporter.log("The WebSite is Open now");
	}

	@Test(priority = 3)
	public void checkLogin() throws InterruptedException {
		int totalrow = er.getRowCount(0);
		for (int i = 0; i < totalrow; i++) {
		driver.get("https://accounts.lambdatest.com/login");
		Thread.sleep(2500);
		String mail = er.getData(0, i, 1);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(mail);
		Reporter.log("The Username data \"User61@gmail.com\" is Entered");
		Thread.sleep(2500);
		String pass = er.getData(0, i, 2);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		Reporter.log("The Password data \"TestUser123\" is Entered");
		Thread.sleep(2500);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2500);
		System.out.println("The login process on lamdatest is completed");
		}
	}

	@Test(priority = 1, description = "this test validates the sign-up test")
	public void signUp() throws InterruptedException {
		int totalrow = er.getRowCount(0);
		for (int i = 0; i < totalrow; i++) {
			System.out.println("***********************This " + i +"th index user infromation***************************\n");
			
		WebElement link = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div/div[2]/div/div/div[2]/a[2]"));
		link.click();
//		Thread.sleep(2500);
//		WebElement organization = driver.findElement(By.xpath("//input[@name='organization_name']"));
//		organization.sendKeys("LambdaTest");
		Thread.sleep(2500);
		
		String uname = er.getData(0, i, 0);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(uname);
		System.out.println("user name is = " + uname);
		Thread.sleep(2500);
		
		String mail = er.getData(0, i, 1);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(mail);
		System.out.println("user mail id is = " + mail);
		Thread.sleep(2500);
		
		String pass = er.getData(0, i, 2);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		System.out.println("user password is = " +pass);
		Thread.sleep(2500);
		
		WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
		phoneNumber.sendKeys("9412267690");
		Thread.sleep(2500);
		
		WebElement termsOfService = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/form/div[5]/label/samp"));
		termsOfService.click();
		Thread.sleep(2500);
		WebElement button = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/form/div[6]/button"));
		button.click();
		Thread.sleep(2500);
		System.out.println("The sign-up process is completed");
		}

	}
	
	@Test(priority = 2, description = "this test validates the logout functionality", timeOut = 25000)
	public void logout() throws InterruptedException {
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div[3]/div/span")).click();
		driver.findElement(By.xpath("//*[@id=\"menu-appbar\"]/div[3]/ul/li[2]")).click();
	}
	
	@Test(priority = 4, alwaysRun = true, dependsOnMethods = "checkLogin",description = "this test validates the URL post logging in", groups = "url_validation")
	public void testCurrentUrl() throws InterruptedException {
	
		String currentUrl = driver.getCurrentUrl();
		
		//Assertion determines the state of the application 
		
		assertEquals(currentUrl, "https://accounts.lambdatest.com/email/verify",
				"url did not matched");
		System.out.println("The url validation test is completed");
	}

	@Test(priority = 5, description = "this test validates the  last logout functionality", timeOut = 25000)
	public void finallogout() throws InterruptedException {
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div[3]/div/span")).click();
		driver.findElement(By.xpath("//*[@id=\"menu-appbar\"]/div[3]/ul/li[2]")).click();
	}

	@Test(enabled = false)
	public void skipMethod() {
		System.out.println("this method will be skipped from the test run using the attribute enabled=false");
	}

	@Test(priority = 6, invocationCount = 5, invocationTimeOut = 20)
	public void invocationcountShowCaseMethod() {
		System.out.println("this method will be executed by 5 times");
	}

	@AfterMethod()
	public void screenshot() throws IOException {
		TakesScreenshot scr = ((TakesScreenshot) driver);
		File file1 = scr.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file1, new File("D:\\ZsnrJavaWorkspace\\TestNGDemo\\ScreenShot\\test1.PNG"));
		System.out.println("Screenshot of the test is taken");
	}

	@AfterClass
	public void closeUp() {
		//driver.close();
		System.out.println("The close_up process is completed");
	}

	@AfterTest
	public void reportReady() {
		System.out.println("Report is ready to be shared, with screenshots of tests");
	}

	@AfterSuite
	public void cleanUp() {

		System.out.println("All close up activities completed");
	}

	@BeforeGroups("urlValidation")
	public void setUpSecurity() {
		System.out.println("url validation test starting");
	}

	@AfterGroups("urlValidation")
	public void tearDownSecurity() {
		System.out.println("url validation test finished");
	}

}
