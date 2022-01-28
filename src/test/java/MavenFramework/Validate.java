package MavenFramework;


import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Resources.ExcelUtils;
import Resources.base;
import pageObjects.ControlObjectiveFormObject;
import pageObjects.metricLoginUI;



public class Validate extends base {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	ControlObjectiveFormObject controlobject=null;
	ExcelUtils data = new ExcelUtils();
	metricLoginUI login=null;
	ArrayList<String>value=null;
	By MRCNumberFiled = By.xpath("//*[@qtip='Cycle Name']");
	By BrowseFilterSubmit = By.xpath("//button[@id='ext-gen18']");
	By EditForm = By.xpath("//*[@class=' x-btn-text msai_tooldefault']");
	By Owners = By.xpath("//input[@name='OWNER_ORGANIZATIONS_lov']");
	By BrowseSelection = By.xpath("//a/span[contains(text(), 'MRC-9951')]");
	WebDriverWait wait = null;
	
	
	public Validate(WebDriver driver) 
	{
		this.driver=driver;
	}
	@Test(priority=1)
	public void WaitForEditMRC() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		By web1 = By.xpath("//*[@id='ext-gen34']");
       WebElement mousehover1 = driver.findElement(web1);	 
       Actions mouseclick1 = new Actions(driver);
          mouseclick1.moveToElement(mousehover1).build().perform();
          mouseclick1.click();
          Thread.sleep(3000);
		//driver.switchTo().defaultContent();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String text = "='MRC']";
		String web="//*[@id='collapsedDivdatabrowserpanel1']//img[@alt"+text;
		System.out.println(web);
		WebElement mousehover = driver.findElement(By.xpath(web));
		Actions mouseclick = new Actions(driver);
		mouseclick.moveToElement(mousehover).build().perform();
		

		String textmrc = "='MRC']";
		String webmrc="a[onclick*"+textmrc;
		System.out.println(webmrc);
		driver.findElement(By.cssSelector(webmrc)).click();


		driver.switchTo().frame("databrowserFilterFormIframe");
		value =data.getData("Select MRC");
		String browseData = value.get(1).toString();
		System.out.println(browseData + " : to string");
		driver.findElement(MRCNumberFiled).clear();
		driver.findElement(MRCNumberFiled).sendKeys(value.get(1));
		driver.findElement(BrowseFilterSubmit).click();
		driver.switchTo().defaultContent();
		String BrowseClick = "//a/span[contains(text(), '"+browseData+"')]";
		System.out.println(BrowseClick);
		driver.findElement(By.xpath(BrowseClick)).click();

		boolean location =wait.until(ExpectedConditions.elementToBeClickable(EditForm)).isDisplayed();

		for(int i=0; i<=3;i++) {

			if(location) {
				System.out.println("Inside edit form click");
				driver.findElement(EditForm).click();

			}
			else {
				System.out.println("Waiting one minutes for the edit icon to appear");
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
				String mrctext = "='MRC']";
				String mrcweb="//*[@id='collapsedDivdatabrowserpanel1']//img[@alt"+mrctext;
				System.out.println(mrcweb);
				driver.findElement(By.xpath(mrcweb)).click();
				driver.switchTo().defaultContent();
				driver.findElement(BrowseSelection).click();

			}

		}

	}
}




