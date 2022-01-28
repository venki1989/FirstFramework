package pageObjects;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.ExcelUtils;
import Resources.base;

public class MRCFormObject {
	public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	ExcelUtils data = new ExcelUtils();
	ArrayList<String>value=null;
	WebDriverWait wait = null;

	By SearchName=By.xpath(".//*[@id='search_name']");
	By OOGo=By.xpath("//button[contains(text(), 'Go')]"); 
	By RadioButton=By.xpath(".//*[@id='cbox0']");
	By SelectButton=By.xpath("//button[text()= 'Select']");
	By SubmitButton = By.xpath(".//*[@class=' x-btn-text msai_toolsubmit']");
	By ContinueButton=By.xpath(".//*[@id='ext-gen12']");
	By GetEventId=By.xpath("//div[@id='ext-comp-1003' and @class='conent x-column']");
	By LogOut = By.xpath("//button[@id='ext-gen56']");
	By Save = By.xpath(".//*[@class=' x-btn-text msai_toolsave']");
	By SaveDraft = By.xpath(".//*[@class=' x-btn-text msai_toolsaveandclose']");
	By EditForm = By.xpath("//*[@class=' x-btn-text msai_tooldefault']");
	By SpanCycle = By.xpath("//*//span[contains(text(), 'Cycles ')]");
	By AddCycleLink = By.xpath("//*//a[contains(text(), 'Add Cycle(s)')]");
	By CycleNameLOV = By.xpath("(//img[@alt='Cycle Name'])[last()]");
	By BrowseSelection = By.xpath("//a/span[contains(text(), 'MRC-9951')]");
	By BrowseFilterSubmit = By.xpath("//button[@id='ext-gen18']");
	By MRCNumberFiled = By.xpath("//*[@qtip='MRC Number']");
	By ActionDropDown= By.xpath(".//*[@name='OBJECT_ACTION']");
    By BrowserMinMax= By.xpath("//*[@class='x-tool x-tool-toggle x-tool-collapse-west ']");
    		
	public MRCFormObject(WebDriver driver) 
	{
		this.driver=driver;
	}

	public void OpenMRC() throws IOException, InterruptedException
	{
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
		driver.findElement(MRCNumberFiled).sendKeys(value.get(1));
		driver.findElement(BrowseFilterSubmit).click();
		driver.switchTo().defaultContent();
		String BrowseClick = "//a/span[contains(text(), '"+browseData+"')]";
		System.out.println(BrowseClick);
		driver.findElement(By.xpath(BrowseClick)).click();
		
	}

	public void AddCycle() throws IOException, InterruptedException
	{
		
		driver.findElement(EditForm).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		driver.switchTo().frame(0);
		driver.findElement(SpanCycle).click();
		driver.findElement(AddCycleLink).click();
		driver.findElement(CycleNameLOV).click();
		driver.switchTo().frame("lovPopup");
		//SELECTING CycleName
		value =data.getData("EnterCycleName");
		driver.findElement(SearchName).sendKeys(value.get(1));
		Thread.sleep(1000);
		driver.findElement(OOGo).click();
		Thread.sleep(1000);
		driver.findElement(RadioButton).click();
		driver.findElement(SelectButton).click();	
	}


	public String SubmitForm() throws InterruptedException, IOException
	{
		driver.switchTo().defaultContent();
		driver.findElement(SubmitButton).click();
		driver.switchTo().frame("MultiWindowIframe1");
		String string = driver.findElement(By.xpath("//div[@id='ext-comp-1003' and @class='conent x-column']")).getText();
		System.out.println(string);
		String string2=string.replaceAll("[^0-9]", "");
		System.out.println(string2);
		Thread.sleep(2000);
		data.setData(string2);
		System.out.println("Writting Excel");
		driver.findElement(ContinueButton).click();
		return string2;
	}


	
	public void WaitForEditMRC() throws IOException, InterruptedException
	{
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
	
	public void ActionDropDown(String value)
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		int framecount2= driver.findElements(By.tagName("iframe")).size();
		System.out.println(framecount2);	 	 
		for(int counter = 0; counter <= framecount2; counter++) {
			System.out.println(framecount2);
			driver.switchTo().frame(framecount2);
			WebElement found =driver.findElement(ActionDropDown); 
			if(found.isDisplayed()) {
				Select dropdown= new Select(driver.findElement(ActionDropDown));
				dropdown.selectByValue(value);
				System.out.println("element found for ActionDropDown");
			}
			else {
				System.out.println("no element exist");
			}


		}

	}
	public WebElement Logout()
	{
		driver.switchTo().defaultContent();
		return this.driver.findElement(LogOut);	
	}


}
