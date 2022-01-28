package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class metricLoginUI {
	//declare instance variable to access driver methods
	//create find page objects and store in variable
	//create find element method for each page objects
	public WebDriver driver; 

	By loginlink=By.cssSelector("a[id='loginHref']");
	By username=By.cssSelector("input[id='login']");
	By clickaway=By.cssSelector("h2");
	By password=By.cssSelector("input[id='password']");
	By loginbutton=By.cssSelector("input[id='go']");


	public metricLoginUI(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement clickloginlink()
	{
		return driver.findElement(loginlink);
	}

	public WebElement username()
	{
		return driver.findElement(username);
	}

	public WebElement clickaway()
	{
		return driver.findElement(clickaway);
	}

	public WebElement password()
	{
		return driver.findElement(password);
	}

	public WebElement loginbutton()
	{
		return driver.findElement(loginbutton);
	}

}
