package MavenFramework;

import java.io.IOException;

import org.testng.annotations.Test;

import Resources.base;
import pageObjects.VCRMHomePage;
import pageObjects.metricLoginUI;

public class loginMetricstream extends base {
	
	//add @test annotation
	//create method and initialize driver inside the method
	

	@Test()
	public void logintoapplication() throws IOException
	{
		driver=initializeDriver();
		driver.get(properties.getProperty("metricurl"));
		metricLoginUI login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().sendKeys(properties.getProperty("user"));
		login.clickaway().click();
		login.password().sendKeys(properties.getProperty("pass"));
		login.loginbutton().click();
		VCRMHomePage view=new VCRMHomePage(driver);
		view.OpenSORForm().click();
		view.EditSORForm().click();	
	}
	
	
}
