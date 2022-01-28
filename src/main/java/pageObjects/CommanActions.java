package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Resources.base;

public class CommanActions {
	public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;

	By GetEventId=By.xpath("//div[@id='ext-comp-1003' and @class='conent x-column']");
	By OpenCycleForm=By.xpath("//.//*[@id='ext-gen155']/div[2]/table/tbody/tr/td[2]/div");
	By CycleNameField=By.xpath("//textarea[@id='id7']");
	By ComplianceDomains=By.xpath("//img[@alt='Compliance Domains']");
	By OperationArea=By.xpath("//img[@alt='Organizational Area']");
	By OwnerOrganization = By.xpath("//img[@alt='Owner Organizations']");
	By Owners = By.xpath("//img[@alt='Owners']");
	By ApplicaTechnoMLOV = By.xpath("//img[@alt='Applicable Technology']");
	By CycleObject=By.xpath(".//*[@id='ext-comp-1008']");
	By SearchName=By.xpath(".//*[@id='search_name']");
	By CDGo=By.xpath(".//*[@id='ext-gen95']");
	By OwnersGo= By.xpath(".//*[@id='ext-gen107']");
	By OAGo=By.xpath(".//*[@id='ext-gen91']");
	By OOGo=By.xpath(".//*[@id='ext-gen99']");
	By AppliTecGo= By.xpath(".//*[@id='ext-gen104']");
	By RadioButton=By.xpath(".//*[@id='cbox0']");
	By SelectButton=By.xpath(".//*[@id='ext-gen31']");
	By RTF=By.xpath("//img[@alt='Rich Text']");
	By RestrictDropDown=By.xpath(".//*[@name='RESTRICT_ACCESS_TO']");
	By ActionDropDown= By.xpath(".//*[@name='OBJECT_ACTION']");
	By CommentText = By.xpath("//textarea[@id='id32']");
	By ValidFrom = By.xpath("//input[@id='iddate17-date']");
	By ValidUntill = By.xpath("//input[@id='iddate18-date']");
	By SubmitButton = By.xpath(".//*[@id='ext-gen225']");
	By ContinueButton=By.xpath(".//*[@id='ext-gen12']");
	By DateClickAway=By.xpath("//span[@id='MSAI_23']");
	By MyTaskSelection = By.cssSelector("*[class*=' x-btn-text todoIcon']");
	By LogOut = By.xpath("//button[@id='ext-gen56']");


	public void GetEventId() throws InterruptedException 
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		String string = driver.findElement(By.xpath("//div[@id='ext-comp-1003' and @class='conent x-column']")).getText();
		System.out.println(string);
		String string2=string.replaceAll("[^0-9]", "");
		System.out.println(string2);

	}

	
	public void SubmitForm() throws InterruptedException
	{
		driver.switchTo().defaultContent();
		driver.findElement(SubmitButton).click(); //Submit the form
		driver.switchTo().frame("MultiWindowIframe1");
         
		//get Event ID
		String string = driver.findElement(By.xpath("//div[@id='ext-comp-1003' and @class='conent x-column']")).getText();
		
		System.out.println(string);
		String string2=string.replaceAll("[^0-9]", "");
		System.out.println(string2);
		Thread.sleep(2000);
		driver.findElement(ContinueButton).click();
	}


	public WebElement Logout()
	{
		return this.driver.findElement(LogOut);	
	}
}

	