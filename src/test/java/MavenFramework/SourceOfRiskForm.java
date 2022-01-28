package MavenFramework;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.VCRMHomePage;

public class SourceOfRiskForm extends base{
	
	@Test
	public void SourceofRiskForm() throws IOException {
		driver=initializeDriver();
		VCRMHomePage view=new VCRMHomePage(driver);
		view.OpenSORForm().click();
		view.EditSORForm().click();		
		
	}
	@AfterTest
public void teardown()
{
	driver.close();
	driver=null;
}

}
