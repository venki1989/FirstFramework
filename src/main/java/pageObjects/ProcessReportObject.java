package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.base;

public class ProcessReportObject extends base {
	public WebDriver driver;
	WebDriverWait wait;
	By ProcessReportLink=By.xpath("//div[contains(text(),'SOX Process') and @class='x-grid3-cell-inner x-grid3-col-1']");
	By ReportExpand = By.xpath("//div[@id='ext-gen132' and @class='x-layout-mini x-layout-mini-north']");
	By CycleFilter = By.xpath("//input[@id='101259_Cycle']");
	By CycleFilterList = By.xpath("//div[@class='x-combo-list-inner']/child::div");
	By ProcessFilter = By.xpath("//input[@id='101260_Process']");
	By ProcessFilterList = By.xpath("//div[@class='x-combo-list-inner']/child::div");
	By SubmitReport = By.xpath("//button[@id='ext-gen61']");
	By ClearAll = By.xpath("//button[@id='ext-gen65']");
	By CloseReport = By.xpath("//button[@id='ext-gen54']");


	By CycleName = By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-1']");
	By Area = By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-2']");
	By ProcessID = By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-3']");
	By ProcessName = By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-4']");
	By OwnerOrg = By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-5']");
	By Owner = By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-6']");
	By ReportCount = By.xpath("//div[@id='ext-comp-1067']");


	By ReportHeader = By.xpath("//div[@class='x-grid3-header']");
	By ExcelExport = By.xpath("//*[@id='ext-gen49' and @class=' x-btn-text']");
	By CSVExport= By.xpath("//input[@type='radio' and @id='EXP_REP_FORMAT_CSV']");
	By ReportExcelExport = By.xpath("//*[@id='ext-gen46' and @class=' x-btn-text report-export-excel']");



	public ProcessReportObject(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebElement ProcessReportLink()
	{
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(ProcessReportLink);

	}

	public WebElement ReportExpand() throws InterruptedException
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(ReportExpand));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(ReportExpand));
		return this.driver.findElement(ReportExpand);

	}


	public void CycleFilter(String value) throws InterruptedException
	{

		try {
			driver.findElement(CycleFilter).sendKeys(value);
			List<WebElement> optionsToSelect = driver.findElements(CycleFilterList);
			for(WebElement option : optionsToSelect){
				System.out.println(option.getText());
				if(option.getText().equals(value)) {
					System.out.println("Trying to select: " +value);
					option.click();
				}
				else {
					System.out.println("The value is not clicked");
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}


	public void ProcessFilter(String value) throws InterruptedException
	{

		try {
			driver.findElement(ProcessFilter).sendKeys(value);
			List<WebElement> optionsToSelect = driver.findElements(ProcessFilterList);
			for(WebElement option : optionsToSelect){
				System.out.println(option.getText());
				if(option.getText().equals(value)) {
					System.out.println("Trying to select: " +value);
					option.click();
				}
				else {
					System.out.println("The value is not clicked");
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}




	public WebElement SubmitReport()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(SubmitReport);

	}
	public WebElement ClearAllReport()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(ClearAll);

	}
	public WebElement CycleName()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(CycleName);

	}
	public WebElement Area()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(Area);

	}
	public WebElement ProcessID()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(ProcessID);

	}

	public WebElement ProcessName()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(ProcessName);

	}

	public WebElement OwnerOrg()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(OwnerOrg);

	}

	public WebElement Owner()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(Owner);

	}


	public WebElement ReportCount()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(ReportCount);

	}

	public WebElement ReportColumn()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(ReportCount);

	}

	public WebElement ReportExcelExport()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(ReportExcelExport);

	}


	public WebElement ExcelExport()
	{

		return this.driver.findElement(ExcelExport);

	}

	public WebElement CSVExport()
	{
		driver.switchTo().frame("exportpopup");
		return this.driver.findElement(CSVExport);

	}



	public WebElement CloseReport()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(CloseReport);

	}
}
