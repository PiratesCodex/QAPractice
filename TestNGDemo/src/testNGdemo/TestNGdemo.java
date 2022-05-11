package testNGdemo;

import org.testng.annotations.Test;

public class TestNGdemo {
	
	//Normal TestNG Test case
	@Test  
	public void testcase1()  
	{   
	   System.out.println("This is testcase1");  
	}
	
	//description annotation that describes the information about the test.
	 
	 @Test(description="This is Description of testcase2")  
	 public void testcase2()  
	 {  
	 System.out.println("Hello welcome to 2nd testcase..");  
	 }  
	 
	 
	 //dependsOnMethods second test method wants to be dependent on the first test method,
	 
	 @Test(dependsOnMethods= {"testcase1"})  
	 public void testcase3()  
	 {  
	 System.out.println("Hello DependOnMethod this method is depend on testcase 1...");  
	 }
	 
	// enabled If you want to skip some test method, then you need to explicitly specify 'false' value
	 
	 @Test(enabled=false)
	 public void testcase4()  
	 {  
	 System.out.println(" Testcase4");  
	 }  
	 
	 //priority attribute is specified then the TestNG will run the test cases in alphabetical order
	 
	 @Test(priority=2)  
	 public void testcase5()  
	 {  
	 System.out.println("I am testcase5 but my priority 2");  
	 }  
	 
	 @Test(priority=1)  
	 public void testcase6()  
	 {  
	 System.out.println("I am testcase6  but my priority 1");  
	 }
	 
	
}
