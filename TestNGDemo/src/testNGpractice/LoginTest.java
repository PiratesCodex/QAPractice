package testNGpractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	 
    WebDriver driver;
 
    @BeforeMethod
    public void setUp() {
        System.out.println("Start test");
        System.setProperty("webdriver.chrome.driver",
                "D:\\ZsnrJavaWorkspace\\UpdatedAutomationFramework\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.freecrm.com");
    }

 
    @Test
    public void loginTest(String keyWord1, String keyWord2) {
    	driver.findElement(By.linkText("Login")).click();
    	driver.findElement(By.name("email")).sendKeys("sagar");
    	driver.findElement(By.name("password")).sendKeys("abc123");
    	
    	
 
        WebElement txtBox = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]"));
        txtBox.sendKeys(Keys.ENTER);
    }
 
    @AfterMethod
    public void burnDown() {
        driver.quit();
    }
	
	@DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {
        // We are creating an object from the excel sheet data by calling a method that
        // reads data from the excel stored locally in our system
        Object[][] arrObj = getExcelData(
                "D:\\ZsnrJavaWorkspace\\TestNGDemo\\DataSource\\TestData1.xlsx",
                "Details");
        return arrObj;
    }
 
    // This method handles the excel - opens it and reads the data from the
    // respective cells using a for-loop & returns it in the form of a string array
    public String[][] getExcelData(String fileName, String sheetName) throws IOException {
        String[][] data = null;
        try {
             
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(0);
            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new String[noOfRows - 1][noOfCols];
 
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sheet.getRow(i);
                    cell = row.getCell(j);
                    data[i - 1][j] = cell.getStringCellValue();
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }
        return data;
    }
    }
