package MavenFramework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Resources.ExcelUtils;
import Resources.base;
import pageObjects.ControlActivityForm;
import pageObjects.ControlObjectiveFormObject;
import pageObjects.CycleFormObject;
import pageObjects.MRCFormObject;
import pageObjects.ProcessFormObject;
import pageObjects.metricLoginUI;

public class ValidateFieldStatus extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	MRCFormObject mrcFormObject=null;
	CycleFormObject cycleformobject=null;
	ControlActivityForm controlactivityform=null;
	ControlObjectiveFormObject controlobjectiveform=null;
	ProcessFormObject processformobject = null;
	ExcelUtils data = new ExcelUtils();
	metricLoginUI login=null;
	ArrayList<String>value=null;

	@Test
	public void LoginApplication() throws IOException, InterruptedException
	{
		//Login to Application
		ArrayList<String>value =data.getData("LoginApplication");
		driver=initializeDriver();
		mrcFormObject=new MRCFormObject(driver);
		driver.get(properties.getProperty("metricurl"));
		login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().sendKeys(value.get(1));
		login.clickaway().click();
		login.password().sendKeys(value.get(2));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		//Open Process MRC from browser

		mrcFormObject.OpenMRC();
		
		//Add Cycle to MRC
		
		mrcFormObject.AddCycle();
		value =data.getData("Select Action Drop Down in process form");
		mrcFormObject.ActionDropDown(value.get(1));
	//	mrcFormObject.WaitForEditMRC();
		//Submit MRC form
		mrcFormObject.SubmitForm();


	}


	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}
