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
import pageObjects.ControlObjectiveFormObject;
import pageObjects.metricLoginUI;

public class CreateObjective extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	ControlObjectiveFormObject controlobject=null;
	ExcelUtils data = new ExcelUtils();
	metricLoginUI login=null;
	ArrayList<String>value=null;

	@Test
	public void LoginApplication() throws IOException, InterruptedException
	{
		//Login to Application
		ArrayList<String>value =data.getData("LoginApplication");
		driver=initializeDriver();
		controlobject=new ControlObjectiveFormObject(driver);
		driver.get(properties.getProperty("metricurl"));
		login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().sendKeys(value.get(1));
		login.clickaway().click();
		login.password().sendKeys(value.get(2));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		//Open Process form
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		controlobject.OpenControlObjectiveForm().click();
		value =data.getData("EnterControlObjectiveName");
		controlobject.ControlObjectNameField().sendKeys(value.get(1));


		//Enter RTF Data
		value =data.getData("EnterControlObjectiveRTF");
		controlobject.RTF(value.get(1));

		//Select Assertion
		value =data.getData("Select Assertion");
		controlobject.AssertionsMLOV(value.get(1));
		
		//Select owner org
		value =data.getData("Select Owner Organizations in Control");
		controlobject.OwnerOrganizationsSLOV(value.get(1));

		//Select owner
		value =data.getData("Select Owner in control objective");
		controlobject.Owners(value.get(1));
//        //Select L1 approver
//		value =data.getData("L1 Approver in Control");
//		controlobject.Level1Approver(value.get(1));

		//Select Restic drop down
		value =data.getData("Select Restriction Drop Down in control form");
		controlobject.RestricDropDown(value.get(1));


		//Select Action drop down
		value =data.getData("Select Action Drop Down in control form");
		controlobject.ActionDropDown(value.get(1));
		
		//Select Related to tab
		controlobject.RelatedToSpan().click();
		
		//Click and add cycle
		controlobject.ClickAddCycleLink().click();
		value =data.getData("EnterCycleName");
		controlobject.CycleNameSLOV(value.get(1));
		Thread.sleep(3000);
		
		//Submit form
		controlobject.SubmitForm();
		Thread.sleep(2000);


		//Enter with approver
		controlobject.Logout().click();
		value =data.getData("L1 Approver in Control");
		login.clickloginlink().click();
		login.username().clear();
		login.username().sendKeys(value.get(1));
		login.clickaway().click();
		login.password().sendKeys(value.get(2));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



		//Select my task
		controlobject.SelectMyTask();


		//Approve the form
		Thread.sleep(3000);
		value =data.getData("Select Action Drop Down in control form");
		controlobject.ActionDropDown(value.get(2));



		//Submit the form
		Thread.sleep(1000);
		controlobject.SubmitForm();
		Thread.sleep(3000);
	}


	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}
