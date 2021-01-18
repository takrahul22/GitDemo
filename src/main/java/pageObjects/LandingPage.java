package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class LandingPage  {
	//public static Logger log =LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	private By signin = By.cssSelector("a[href*='sign_in']");  //we should keep data variables as private and 
	//methods as public
	 private By course = By.xpath("//h2[contains(text(),'Featured Courses')]");


public LandingPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	this.driver = driver2;
	}


public WebElement getLogin() 
{
	//log.info("invoking getlogin method");
return driver.findElement(signin);	
}

public WebElement Course() 
{
return driver.findElement(course);	
}


}