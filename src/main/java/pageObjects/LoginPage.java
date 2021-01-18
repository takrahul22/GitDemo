package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;

	
	By email = By.cssSelector("#user_email");
	By password = By.cssSelector("#user_password");
	By login = By.xpath("//input[@name='commit']");

public LoginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	this.driver = driver2;
	}


public WebElement getEmail() 
{
return driver.findElement(email);	
}

public WebElement getPassword() 
{
return driver.findElement(password);	
}

public WebElement getLogin() 
{
return driver.findElement(login);	
}

}
