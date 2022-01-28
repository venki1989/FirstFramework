package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class base {
	public static WebDriver driver; //Define as global variable, so that we eliminate for creating object every step
	public Properties properties; //Define as global variable, so that we eliminate for creating object every step
	public WebDriver initializeDriver() throws IOException
	{
		properties= new Properties();
		FileInputStream file= new FileInputStream("C:\\Users\\venkatesh.m\\Framework\\src\\main\\java\\Resources\\data.properties");
		properties.load(file);
		String BrowserName=properties.getProperty("Browser");

		if(BrowserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatesh.m\\Framework\\DRIVER\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(BrowserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\venkatesh.m\\Framework\\DRIVER\\geckodriver.exe");
			driver=new FirefoxDriver();

		}
		else if(BrowserName.equals("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		return driver; // Return so that any class can use this methods/objects


	}
   
	
	public void getScreenshot(String result) throws IOException
	{
		TakesScreenshot screenshot=(TakesScreenshot)driver;

	    File source=screenshot.getScreenshotAs(OutputType.FILE);    
	    FileHandler.copy(source,new File("C:\\Users\\venkatesh.m\\Desktop\\FrameworkScreenshot\\"+result+"Screenshot.png"));
	
		
		        
	}


}
