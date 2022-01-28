package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VCRMHomePage {

	public WebDriver driver;
	
	By SourceOFRisk=By.xpath("//a[contains(text(), 'DataFix')]//..//..//..//td//div[@class='x-grid3-cell-inner x-grid3-col-9']//a//img[@id='image1']");
	By EditPage=By.cssSelector("button[in=ext-gen274]");
	
	public VCRMHomePage(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebElement OpenSORForm()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(SourceOFRisk));
		return this.driver.findElement((By) element);
	}
	public WebElement EditSORForm()
	{
		return this.driver.findElement(EditPage);
	}
}
