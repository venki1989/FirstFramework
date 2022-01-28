package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	
	By username=By.cssSelector("input[id=user_email]");
	By password=By.cssSelector("input[id=user_password]");
	By submit=By.cssSelector("input[name=commit]");
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getUserName()
	{
		return driver.findElement(username);
	}
	public WebElement getpassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLoginButton()
	{
		return driver.findElement(submit);
	}
}
