package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base  {
	  //THis if for Log 4J XML
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	
	public void initialize() throws IOException
	{
		
		 driver = intializeDriver();//AS intializeDriver() returns driver that is in base class
		 log.info("Driver is intialized");
		 	}
	   
   @Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password) throws IOException
	{
	   //driver.get(prop.getProperty("url"));
	   driver.get("http://qaclickacademy.com");
	   log.info("Navigated to Home page");
	   
	   LandingPage L = new LandingPage(driver);
	   Assert.assertEquals(L.Course().getText(), "FEATURED COURSES");
		 log.info("Successfully validated Text message");
	   L.getLogin().click();
	   LoginPage Lp = new LoginPage(driver);
	   Lp.getEmail().sendKeys(Username);
	   Lp.getPassword().sendKeys(Password);
	   
	   Lp.getLogin().click();
	   log.info("successfully entered account details");
	   
	}
  
   @DataProvider
   public Object[][] getData()
   {
	   //[row][column] -rows stands for different types of data that we need to run
	   //column stands for how many values per each test
	   Object[][] data = new Object[2][2];
	   //0th row
	   data[0][0]= "nonrestricteduser@qw.com";
	   data[0][1]= "123456";
	   
	   //1st row
	   data[1][0]= "restricteduser@qw.com";
	   data[1][1]= "456789";

	   return data;
	   
   }
  

   @AfterTest
	public void teardown() throws IOException
	{
		 driver.close();//AS intializeDriver() returns driver that is in base class
		 driver =null;
		 
		 	}
	   
}
