package MavenFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.landingPage;

public class ValidateTitle extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());

	@BeforeTest(enabled=false)
	public void initialization() throws IOException 
	{
		driver=initializeDriver();
		driver.get(properties.getProperty("URL"));
		log.info("got the URL from property file");
	}

	@Test(enabled=false)
	public void getTitle()
	{
		landingPage landing=new landingPage(driver);
		Assert.assertEquals(landing.getTitle().getText(),"Featured COURSES");
		log.info("Title is validated");

	}
   @AfterTest(enabled=false)
	public void tearDown()
	{
		driver.close();
		driver=null;
	}

}