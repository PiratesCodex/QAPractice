package testNGdemo;

import org.testng.annotations.Test;

public class GroupingInTestNG 
{  
@Test(groups= {"software company"})  
public void infosys()  
{  
System.out.println("Infosys");  
}  
@Test(groups= {"Non IT"}) 
public void technip()  
{  
System.out.println("Technip India Ltd");  
}  
@Test(groups= {"software company"})  
public void wipro()  
{  
System.out.println("Wipro");  
}  
@Test(groups= {"Non IT"})
public void adani()  
{  
System.out.println("adani India Ltd");  
}  
@Test(groups= {"software company"})  
public void hp()  
{  
System.out.println("HP");  
}  
}  