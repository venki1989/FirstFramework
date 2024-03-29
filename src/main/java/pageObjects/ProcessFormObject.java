package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
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

import Resources.ExcelUtils;
import Resources.base;

public class ProcessFormObject {
	public static Logger log=LogManager.getLogger(base.class.getName());
	ExcelUtils data = new ExcelUtils();
	public WebDriver driver;

	By OpenProcessForm=By.xpath("//.//*[@id='ext-gen155']/div[3]/table/tbody/tr/td[2]/div");
	By ProcessNameField=By.xpath("//textarea[@id='id7']");
	By CycleName=By.xpath("//img[@alt='Cycle Name']");
	By OwnerOrganization = By.xpath("//img[@alt='Owner Organizations']");
	By Owners = By.xpath("//img[@alt='Owners']");
	By L1Approver = By.xpath("//img[@alt='Level 1 Approver']");
	By CycleObject=By.xpath(".//*[@id='ext-comp-1008']");
	By SearchName=By.xpath(".//*[@id='search_name']");
	By GoButton=By.xpath(".//*[@id='ext-gen107']");
	By OwnersGo= By.xpath(".//*[@id='ext-gen107']");
	By OAGo=By.xpath(".//*[@id='ext-gen91']");
	By OOGo=By.xpath("//button[contains(text(), 'Go')]");
	By RadioButton=By.xpath(".//*[@id='cbox0']");
	By SelectButton=By.xpath("//button[text()= 'Select']");
	By RTF=By.xpath("//img[@alt='Rich Text']");
	By RestrictDropDown=By.xpath(".//*[@name='RESTRICT_ACCESS_TO']");
	By ActionDropDown= By.xpath(".//*[@name='OBJECT_ACTION']");
	By SubmitButton = By.xpath(".//*[@class=' x-btn-text msai_toolsubmit']");
	By ContinueButton=By.xpath(".//*[@id='ext-gen12']");
	By LogOut = By.xpath("//button[@id='ext-gen56']");
	By ProcessId = By.xpath("//div[@id='OBJECT_ID_field__div']");


	public ProcessFormObject(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebElement CycleObject()
	{
		return this.driver.findElement(CycleObject);


	}

	public WebElement OpenProcessForm()
	{
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(OpenProcessForm);

	}
	
	public WebElement ProcessID()
	{
		driver.switchTo().frame("MultiWindowIframe1");
		return this.driver.findElement(ProcessId);

	}

	public WebElement Logout()
	{
		driver.switchTo().defaultContent();
		return this.driver.findElement(LogOut);	
	}

	public WebElement ProcessNameField()
	{
		int framecount= driver.findElements(By.tagName("iframe")).size();
		System.out.println(framecount);	 	 
		for(int counter = 0; counter <= framecount; counter++) {
			System.out.println(framecount);
			driver.switchTo().frame(framecount);
			WebElement found =driver.findElement(ProcessNameField); 
			if(found.isDisplayed()) {
				System.out.println("element found for process");
			}
			else {
				System.out.println("no element exist");
			}


		}
		return this.driver.findElement(ProcessNameField);
	}





	public int EnterFrameObject(By xpath)
	{


		int framecount= driver.findElements(By.tagName("iframe")).size();
		System.out.println(framecount);	 	 
		for(int counter = 0; counter <= framecount; counter++) {
			System.out.println(framecount);
			driver.switchTo().frame(framecount);
			WebElement found =driver.findElement(xpath); 
			if(found.isDisplayed()) {
				System.out.println("element found for "+ xpath);
			}
			else {
				System.out.println("no element exist");
			}


		}
		return framecount;


	}

	public void CycleNameSLOV(String value) throws InterruptedException 

	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		int framecount= driver.findElements(By.tagName("iframe")).size();
		System.out.println(framecount);	 	 
		for(int counter = 0; counter <= framecount; counter++) {
			System.out.println(framecount);
			driver.switchTo().frame(framecount);
			WebElement found =driver.findElement(CycleName); 
			if(found.isDisplayed()) {
				driver.findElement(CycleName).click();
				System.out.println("element found for CycleName");
			}
			else {
				System.out.println("no element exist");
			}


		}

		//driver.findElement(ComplianceDomains).click();
		driver.switchTo().frame("mlovPopup");
		//SELECTING COMPLIANCE DOMAINS
		driver.findElement(SearchName).sendKeys(value);
		Thread.sleep(1000);
		driver.findElement(GoButton).click();
		Thread.sleep(1000);
		driver.findElement(RadioButton).click();
		driver.findElement(SelectButton).click();	

	}

	public void RTF(String text) throws InterruptedException
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		int framecount= driver.findElements(By.tagName("iframe")).size();
		System.out.println(framecount);	 	 
		for(int counter = 0; counter <= framecount; counter++) {
			System.out.println(framecount);
			driver.switchTo().frame(framecount);
			WebElement found =driver.findElement(RTF); 
			if(found.isDisplayed()) {
				driver.findElement(RTF).click();
				System.out.println("element found for RTF");
			}
			else {
				System.out.println("no element exist");
			}


		}


		////////////////
		String winhandle=driver.getWindowHandle(); //Working on pop-up
		driver.switchTo().window(winhandle);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(10000);
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		System.out.println(parentWindowHandler);
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles(); // get all window handles
		System.out.println(handles.size());
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);//Focus on the pop-up


		//////////
		driver.switchTo().frame("tinymce_ifr"); //Selecting the pop-up frame
		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys(text);
		driver.switchTo().window(subWindowHandler);//Go back to pop-up focus
		driver.findElement(By.xpath("//span[@class='mceIcon mce_close']")).click();
		driver.switchTo().window(parentWindowHandler);//Go back to parent window
	}
	

	public void OwnerOrganizationsSLOV(String MRCName) throws InterruptedException  

	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		int framecount= driver.findElements(By.tagName("iframe")).size();
		System.out.println(framecount);	 	 
		for(int counter = 0; counter <= framecount; counter++) {
			System.out.println(framecount);
			driver.switchTo().frame(framecount);
			WebElement found =driver.findElement(OwnerOrganization); 
			if(found.isDisplayed()) {
				driver.findElement(OwnerOrganization).click();
				System.out.println("element found for OwnerOrganization");
			}
			else {
				System.out.println("no element exist");
			}


		}
		//driver.findElement(OwnerOrganization).click();
		driver.switchTo().frame("lovPopup");
		driver.findElement(SearchName).sendKeys(MRCName);
		Thread.sleep(1000);
		driver.findElement(OOGo).click();
		Thread.sleep(1000);
		driver.findElement(RadioButton).click();
		driver.findElement(SelectButton).click();	
	}

	public void Owners(String value) throws InterruptedException 
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		int framecount= driver.findElements(By.tagName("iframe")).size();
		System.out.println(framecount);	 	 
		for(int counter = 0; counter <= framecount; counter++) {
			System.out.println(framecount);
			driver.switchTo().frame(framecount);
			WebElement found =driver.findElement(Owners); 
			if(found.isDisplayed()) {
				driver.findElement(Owners).click();
				System.out.println("element found for Owners");
			}
			else {
				System.out.println("no element exist");
			}


		}
		//SELECTING Owner owner

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("mlovPopup");
		driver.findElement(SearchName).sendKeys(value);
		Thread.sleep(2000);
		driver.findElement(OwnersGo).click();
		Thread.sleep(2000);
		driver.findElement(RadioButton).click();
		driver.findElement(SelectButton).click();

	}

	public void Level1Approver(String value) throws InterruptedException 
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		int framecount= driver.findElements(By.tagName("iframe")).size();
		System.out.println(framecount);	 	 
		for(int counter = 0; counter <= framecount; counter++) {
			System.out.println(framecount);
			driver.switchTo().frame(framecount);
			WebElement found =driver.findElement(L1Approver); 
			if(found.isDisplayed()) {
				driver.findElement(L1Approver).click();
				System.out.println("element found for L1Approver");
			}
			else {
				System.out.println("no element exist");
			}


		}
		//SELECTING Owner owner

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("lovPopup");
		driver.findElement(SearchName).sendKeys(value);
		Thread.sleep(2000);
		driver.findElement(OOGo).click();
		Thread.sleep(2000);
		driver.findElement(RadioButton).click();
		driver.findElement(SelectButton).click();

	}
	
	public void RestricDropDown(String value)
	{
		driver.switchTo().frame("MultiWindowIframe1");
		int framecount= driver.findElements(By.tagName("iframe")).size();
		System.out.println(framecount);	 	 
		for(int counter = 0; counter <= framecount; counter++) {
			System.out.println(framecount);
			driver.switchTo().frame(framecount);
			WebElement found =driver.findElement(RestrictDropDown); 
			if(found.isDisplayed()) {
				Select dropdown= new Select(driver.findElement(RestrictDropDown));
				dropdown.selectByValue(value);
				System.out.println("element found for RestrictDropDown");
			}
			else {
				System.out.println("no element exist");
			}


		}

	}

	public void ActionDropDown(String value)
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MultiWindowIframe1");
		int framecount= driver.findElements(By.tagName("iframe")).size();
		System.out.println(framecount);	 	 
		for(int counter = 0; counter <= framecount; counter++) {
			System.out.println(framecount);
			driver.switchTo().frame(framecount);
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

	public String SubmitForm() throws IOException, InterruptedException
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

	public void ExitFrameObject()
	{
		driver.switchTo().defaultContent();
	}
	
	public void SelectMyTask() throws InterruptedException, IOException
	{
		driver.switchTo().defaultContent();
		WebElement mouseElement = driver.findElement(By.cssSelector("*[class*=' x-btn-text todoIcon']"));
		Actions mouseclick = new Actions(driver);
		mouseclick.moveToElement(mouseElement).build().perform();
		Thread.sleep(3000);
		ArrayList<String>value =data.getDynamicData("EventIdNumber");
		String input = value.get(1);
		System.out.println("The data written into Excel " +input);
		boolean emptyflg=false,btnflg=false;
		int p=0;
		try {
			List<WebElement> divcollect = driver.findElements(By.cssSelector("div[class*='x-grid-empty']"));
			System.out.println("divcollect size :" + divcollect.size());
			log.info("divcollect size :" + divcollect.size());
			if (divcollect.size() > 0) {
				emptyflg = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			log.error(e.getMessage());
		}
		if (emptyflg == false) {
			try {
				do {

					try {
						List<WebElement> link1 = driver
								.findElements(By.cssSelector("table[class*='x-grid3-row-table']"));
						if (link1.size() > 0) {
							btnflg = true;
							break;
						} else {
							Thread.sleep(2000);
							p++;
							// System.out.println("P "+p);
							log.info("P  " + p);

						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
						log.error(e.getMessage());
					}

				} while (p < 10);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				log.error(e.getMessage());
			} // close of catch
		}
		// System.out.println("mytask coming here "+emptyflg+" btnflg
		// :"+btnflg);
		log.info("mytask coming here " + emptyflg + " btnflg :" + btnflg);
		if (btnflg == false) {
			try {
				/*ToDoMenuClick("Objectname");*/
			} catch (Exception e) {
				System.out.println(e.getMessage());
				log.error(e.getMessage());
			} // close of catch

		} // close of if
		boolean flgfnd = false, btnflg2 = false;
		String stsmsg = "", txtsts = "";
		int h = 0;
		if (emptyflg == false) {
			try {
				do {
					List<WebElement> link1 = driver.findElements(By.cssSelector("table[class*='x-grid3-row-table']"));
					// System.out.println("link2 size "+link1.size());
					log.info("link2  size " + link1.size());
					if (link1.size() > 0) {

						break;
					} else {
						// Generalfunction.ToDoMenuClick(GlobalVariable.Objectname);
						Thread.sleep(2000);
						h++;

					}
				} while (h < 20);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				log.error(e.getMessage());
			}
			try {

				Document doc1 = Jsoup.parse(driver.getPageSource());
				Elements tblcollect = doc1.select("table[class*=x-grid3-row-table]");
				System.out.println("tblcollect size :" + tblcollect.size());
				log.info("tblcollect size :" + tblcollect.size());
				for (Element tbl : tblcollect) {
					Elements trcollect = tbl.getElementsByTag("tr");
					for (Element tr : trcollect) {
						Elements tdcollect = tr.select("td[class*=x-grid3-col]");
						for (Element td : tdcollect) {
							System.out.println("getting the text here" + td.text());
							String Inputpid = input;
							if (td.text().trim().contains(Inputpid.trim())) {
								flgfnd = true;
								String css = td.cssSelector();
								WebElement element = driver.findElement(By.cssSelector(css));

								System.out.println("coming here ");
								log.info("coming here ");
								element.click();
								// driver.findElement(By.cssSelector(css)).click();
								// Generalfunction.waitForpageLoad();
								break;
							}
							if (flgfnd == true) {
								break;
							}
						}
						if (flgfnd == true) {
							break;
						}
					}
					if (flgfnd == true) {
						break;
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				log.error(e.getMessage());
			}


			// }
			if (flgfnd == false) {
				System.out.println("coming here :mytask ");
				log.info("coming here :mytask ");
				do {
					try {

						List<WebElement> arrbtn = driver
								.findElements(By.cssSelector("button[class*='x-btn-text x-tbar-page-next']"));
						for (WebElement btn : arrbtn) {
							String arrowcls = null;
							if (btn.getAttribute("class").trim().equals(arrowcls.trim())) {
								if (btn.isEnabled() == true) {
									/*if (GlobalVariable.browserType.equals("IE")) {
										JavascriptExecutor executor = (JavascriptExecutor) driver;
										executor.executeScript("arguments[0].click();", btn);
									} else {
										System.out.println("coming here ");
										log.info("coming here ");

										// asdfasdf
										// act.moveToElement(btn);
										// act.moveToElement(btn).click().perform();
										// act.moveToElement(btn);
										// JavascriptExecutor executor =
										// (JavascriptExecutor) driver;
										// executor.executeScript("arguments[0].click();",
										// btn);
										String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
										((JavascriptExecutor) AppKeywords_GENERAL.driver).executeScript(mouseOverScript,
												btn);
									}*/
									btn.click();
									break;
								} else {
									flgfnd = false;
								}
							}
						} // close of for loop
						Thread.sleep(1000);

						Document doc2 = Jsoup.parse(driver.getPageSource());
						Elements tblcollect1 = doc2.select("table[class*=x-grid3-row-table]");
						for (Element tbl : tblcollect1) {
							Elements trcollect = tbl.getElementsByTag("tr");
							for (Element tr : trcollect) {
								Elements tdcollect = tr.select("td[class*=x-grid3-col]");
								for (Element td : tdcollect) {
									String Inputpid = input;
									if (td.text().trim().contains(Inputpid.trim())) {
										flgfnd = true;
										String css = td.cssSelector();
										WebElement element = driver.findElement(By.cssSelector(css));
										JavascriptExecutor executor = (JavascriptExecutor) driver;
										executor.executeScript("arguments[0].click();", element);
										//Generalfunction.waitForpageLoad();
										break;
									}

								}
								if (flgfnd == true) {
									break;
								}
							}
							if (flgfnd == true) {
								break;
							}
						}

						Thread.sleep(1000);
						String statuscls = null;
						List<WebElement> statuscollect = driver
								.findElements(By.cssSelector("div[class*='" + statuscls + "']"));
						for (WebElement sts : statuscollect) {
							if (sts.getText().contains("of")) {
								stsmsg = sts.getText();
								break;
							}
						}
						String[] st1 = stsmsg.split("of");
						stsmsg = st1[1];
						String statustxtcls = null;
						List<WebElement> txtcollect = driver
								.findElements(By.cssSelector("input[class*='" + statustxtcls + "']"));
						// System.out.println("size txt :"+txtcollect.size());
						log.info("size txt :" + txtcollect.size());
						for (WebElement txt : txtcollect) {
							txtsts = txt.getAttribute("value");
							break;
						}

					} catch (Exception e) {
						System.out.println(e.getMessage());
						log.error(e.getMessage());
					}
					if (txtsts.trim().equals(stsmsg.trim())) {
						btnflg2 = true;
						// System.out.println("exit do loop");
						log.info("exit do loop");
						break;
					}
				} while (flgfnd == false || txtsts.trim().equals(stsmsg.trim()));
			}
			if (btnflg2 == false) {

				Thread.sleep(2000);
			}
			int k = 0;
			try {
				Alert a = new WebDriverWait(driver, 1).until(ExpectedConditions.alertIsPresent());// to
				// handle
				// popup
				// in
				// BMO
				// project
				if (a != null) {
					//String poptext = AppsAPI.AlertWindow();
				} else {
					System.out.println("Alert is not Present");
				}
			} catch (Exception e) {
				// System.out.println(e.getMessage());
				log.error(e.getMessage());
			}
			if (btnflg2 == false) {
				do {
					String homepage = null;
					if (!driver.getTitle().equals(homepage)) {
						break;
					} else {
						k++;
						Thread.sleep(2000);
					}

				} while (k < 30);

			}
			do {
				Thread.sleep(2000);
				String homepage = null;
				if (!driver.getTitle().equals(homepage)) {
					break;
				} else {
					k++;

				}

			} while (k < 30);
		}
		
	}
	
}

