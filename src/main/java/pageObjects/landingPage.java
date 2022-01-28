package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	
	public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector(".text-center>h2");
	
	public landingPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return this.driver.findElement(signin);
	}
	
	public WebElement getTitle()
	{
		return this.driver.findElement(title);
	}

}
