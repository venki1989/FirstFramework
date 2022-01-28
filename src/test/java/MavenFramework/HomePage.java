package MavenFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.landingPage;
import pageObjects.loginPage;

public class HomePage extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	//this log code needs to be added in every test in order to trace where ever required

	@Test(dataProvider="getData", enabled=false)
	public void loginDetails(String name, String password) throws IOException
	{
		driver=initializeDriver(); // initializeDriver returns driver so put as driver object
		log.info("Driver is initialized in HomePage test");
		driver.get("http://www.qaclickacademy.com/");
		// Not creating the driver object here since, we are accessing it using extents and driver is declared as global
		log.info("URL is entered"); // to enter the info into log file
		landingPage login=new landingPage(driver); //Driver object is passed as argument so that the reference obj can use the driver methods
		login.getLogin().click();
		loginPage credentials=new loginPage(driver);
		credentials.getUserName().sendKeys(name);
		credentials.getpassword().sendKeys(password);
		credentials.getLoginButton().click();
	}
		@DataProvider
		public Object[][] getData() //first[] is rows second[] is column
		{
			Object[][] testdata=new Object[2][2];
			testdata[0][0]="name@name.com";
			testdata[0][1]="name1";
			log.info("One test data used");
			testdata[1][0]="name@name2.com";
			testdata[1][1]="name2";
			log.info("Second test data used");
			
			return testdata;
					
		}
		
		@AfterTest(enabled=false)
		public void tearDown()
		{
			driver.close();
			driver=null;
		}
		
}