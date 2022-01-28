package MavenFramework;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.metricLoginUI;

public class iframe extends base {

	@Test()
	public void iframe() throws IOException, InterruptedException 
	{
		driver=initializeDriver();
		driver.get(properties.getProperty("metricurl"));
		metricLoginUI login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().sendKeys(properties.getProperty("user"));
		login.clickaway().click();
		login.password().sendKeys(properties.getProperty("pass"));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int framecount1 =driver.findElements(By.tagName("iframe")).size();
		System.out.println(framecount1);
		driver.switchTo().frame("MultiWindowIframe1");
		driver.findElement(By.xpath(".//*[@id='ext-gen155']/div[2]/table/tbody/tr/td[2]/div")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		int framecount2= driver.findElements(By.tagName("iframe")).size();
		System.out.println(framecount2);	 	 
		for(int counter = 0; counter <= framecount2; counter++) {
			System.out.println(framecount2);
			driver.switchTo().frame(framecount2);
			WebElement found =driver.findElement(By.xpath("//textarea[@id='id7']")); 
			if(found.isDisplayed()) {
				found.sendKeys("New Cycle Name");
				System.out.println("element found");
			}
			else {
				System.out.println("no element exist");
			}


		}
		driver.findElement(By.xpath("//img[@alt='Compliance Domains']")).click();
		driver.switchTo().frame("lovPopup");
		
		//SELECTING COMPLIANCE DOMAINS
		driver.findElement(By.xpath(".//*[@id='search_name']")).sendKeys("Information Security");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ext-gen95']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='cbox0']")).click();
		driver.findElement(By.xpath(".//*[@id='ext-gen31']")).click();
		
		
		driver.switchTo().frame("MultiWindowIframe1");
		driver.switchTo().frame(framecount2);
		driver.findElement(By.xpath("//img[@alt='Rich Text']")).click();
		
		////////////////
		String winhandle=driver.getWindowHandle();
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
		driver.switchTo().window(subWindowHandler);
		
		
		//////////
		driver.switchTo().frame("tinymce_ifr");
		driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("RTF FIELD");
		driver.switchTo().window(subWindowHandler);
		driver.findElement(By.xpath("//span[@class='mceIcon mce_close']")).click();
		driver.switchTo().window(parentWindowHandler);
		
		//SELECTING Organizational Area
		driver.switchTo().frame("MultiWindowIframe1");
		System.out.println("the new iframe is"+ framecount2);
		driver.switchTo().frame(framecount2);
		driver.findElement(By.xpath("//img[@alt='Organizational Area']")).click();
		driver.switchTo().frame("lovPopup");
		driver.findElement(By.xpath(".//*[@id='search_name']")).sendKeys("Information Technology");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ext-gen91']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='cbox0']")).click();
		driver.findElement(By.xpath(".//*[@id='ext-gen31']")).click();
		
		//SELECTING Owner Organizations
		driver.switchTo().frame("MultiWindowIframe1");
		System.out.println("the new iframe is"+ framecount2);
		driver.switchTo().frame(framecount2);
		driver.findElement(By.xpath("//img[@alt='Owner Organizations']")).click();
		driver.switchTo().frame("lovPopup");
		driver.findElement(By.xpath(".//*[@id='search_name']")).sendKeys("MRC-9951");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ext-gen99']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='cbox0']")).click();
		driver.findElement(By.xpath(".//*[@id='ext-gen31']")).click();
		
		//SELECTING Owner owner
		driver.switchTo().frame("MultiWindowIframe1");
		System.out.println("the new iframe is"+ framecount2);
		driver.switchTo().frame(framecount2);
		driver.findElement(By.xpath("//img[@alt='Owners']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("mlovPopup");
		driver.findElement(By.xpath(".//*[@id='search_name']")).sendKeys("chunter4");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='ext-gen107']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='cbox0']")).click();
		driver.findElement(By.xpath(".//*[@id='ext-gen31']")).click();
		
		
				
		
		driver.switchTo().frame("MultiWindowIframe1");
		driver.switchTo().frame(framecount2);
		Select dropdown= new Select(driver.findElement(By.xpath(".//*[@name='RESTRICT_ACCESS_TO']")));
		dropdown.selectByValue("N");
		
		Select Actiondropdown= new Select(driver.findElement(By.xpath(".//*[@name='OBJECT_ACTION']")));
		Actiondropdown.selectByValue("S");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@id='ext-gen225']")).click();
		driver.switchTo().frame("MultiWindowIframe1");
		driver.findElement(By.xpath(".//*[@id='ext-gen12']")).click();
		driver.findElement(By.xpath(".//*[@id='ext-gen155']/div[3]/table/tbody/tr/td[2]/div")).click();
		/*int framecount3= driver.findElements(By.tagName("iframe")).size();
		System.out.println(framecount3);	 	 
		for(int counter = 0; counter <= framecount3; counter++) {
			System.out.println(framecount3);
			driver.switchTo().frame(framecount3);
			WebElement found =driver.findElement(By.xpath(".//*[@id='search_name']]")); 
			if(found.isDisplayed()) {
				found.sendKeys("CycleName");
				System.out.println("element found");
			}
			else {
				System.out.println("no element exist");
			}


		}*/

	}

}



