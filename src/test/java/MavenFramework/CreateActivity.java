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
import pageObjects.metricLoginUI;

public class CreateActivity extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	ControlActivityForm controlactivity=null;
	ExcelUtils data = new ExcelUtils();
	metricLoginUI login=null;
	ArrayList<String>value=null;

	@Test
	public void LoginApplication() throws IOException, InterruptedException
	{
		//Login to Application
		ArrayList<String>value =data.getData("LoginApplication");
		driver=initializeDriver();
		controlactivity=new ControlActivityForm(driver);
		driver.get(properties.getProperty("metricurl"));
		login=new metricLoginUI(driver);
		login.clickloginlink().click();
		login.username().sendKeys(value.get(1));
		login.clickaway().click();
		login.password().sendKeys(value.get(2));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		//Open Activity form

		controlactivity.OpenControlActivityForm().click();
		value =data.getData("EnterControlActivityName");
		controlactivity.ControlActivityNameField().sendKeys(value.get(1));


		//Enter RTF Data
		value =data.getData("EnterControlActivityRTF");
		controlactivity.RTF(value.get(1));

		//Select Automated/Manual
		value =data.getData("Select Automated/Manual");
		controlactivity.Automated_Manual(value.get(1));

		//Select Control Type
		value =data.getData("Select Control Type");
		controlactivity.ControlType(value.get(1));

		//Select Frequency
		value =data.getData("Select Frequency");
		controlactivity.Frequency(value.get(1));

		//Select Assertion
		value =data.getData("Assertions");
		controlactivity.AssertionsMLOV(value.get(1));
		
		//Select Pooling
		value =data.getData("Pooling");
		controlactivity.Pooling(value.get(1));

		//Select Events Per Frequency
		value =data.getData("Frequency Per");
		controlactivity.PerFrequency(value.get(1));
		
		//Select Anual Sample
		value =data.getData("Annual Sample");
		controlactivity.SampleSize(value.get(1));
		
		//Select MRC Name
		value =data.getData("MRC Number");
		controlactivity.OwnerOrganizationsSLOV(value.get(1));

		//Select owner
		value =data.getData("MRC Activity Owner");
		controlactivity.Owners(value.get(1));
		
		
//		//Select L1 approver
//		value =data.getData("L1 Approver in Control_Activity");
//		controlactivity.Level1Approver(value.get(1));

		//Select Restic drop down
		value =data.getData("Select Restriction Drop Down Control_Activity");
		controlactivity.RestricDropDown(value.get(1));

		//Select Performed By
		value =data.getData("Control Performed");
		controlactivity.PerformedBy(value.get(1));
		
		
		//Select Action drop down
		value =data.getData("Select Action Drop Down Control_Activity");
		controlactivity.ActionDropDown(value.get(1));

		//Select Related to tab
		controlactivity.RelatedToSpan().click();

		//Click and Control
		controlactivity.ClickControlLink().click();
		value =data.getData("EnterCycleName");
		controlactivity.CycleNameSLOV(value.get(1));
		
		Thread.sleep(2000);
		value =data.getData("EnterProcessName");
		controlactivity.ProcessNameSLOV(value.get(1));
		
		Thread.sleep(2000);
		value =data.getData("EnterControlObjectiveName");
		controlactivity.ControlObjectiveSLOV(value.get(1));
		Thread.sleep(2000);

		//Submit form
		controlactivity.SubmitForm();
		Thread.sleep(2000);


		//Enter with approver
		controlactivity.Logout().click();
		value =data.getData("L1 Approver in Control_Activity");
		login.clickloginlink().click();
		login.username().clear();
		login.username().sendKeys(value.get(1));
		login.clickaway().click();
		login.password().sendKeys(value.get(2));
		login.loginbutton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



		//Select my task
		controlactivity.SelectMyTask();


		//Approve the form
		Thread.sleep(3000);
		value =data.getData("Select Action Drop Down in control form");
		controlactivity.ActionDropDown(value.get(2));



		//Submit the form
		Thread.sleep(1000);
		controlactivity.SubmitForm();
		Thread.sleep(3000);
	}


	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}
