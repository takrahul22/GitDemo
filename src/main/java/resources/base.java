package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public static WebDriver driver;
	//keeping it static so that another class cannot modify the driver
	public Properties prop; // reason why we made it public is so that we can 
	
	//use prop properties in all test cases
	
public WebDriver intializeDriver() throws IOException
   
{
	//System.getProperty("user.dir"); //this step reaches till your project and after that we have same src\\main\\java\\resources
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	
	//This concatinates user.dir where we have project with path of data.properties
	prop.load(fis);
	//String browserName = prop.getProperty("browser");
	String browserName = System.getProperty("browser"); //If we need to parametrize from maven then use system.get
	//System.out.println(browserName);
	//String url = prop.getProperty("url");
	//System.out.println(url);
	if(browserName.contains("chrome"))
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Work selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		if (browserName.contains("headless"))
		options.addArguments("headless");
		  driver = new ChromeDriver(options);
		
	}
	else if (browserName.equals("firefox"))
		
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Work selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		  
		driver = new FirefoxDriver();
		
	}
else if (browserName.equals("IE"))
		
	{
	System.setProperty("webdriver.ie.driver", "D:\\Work selenium\\IEDriverServer_x64_3.4.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
	}
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	return driver; 
	
	//so that we can access this driver outside this class in any another class
	}

public void getscreenshot(String result) throws IOException
{
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src,new File("D:\\Work selenium\\"+result+"Screenshot.png"));
	}
}
