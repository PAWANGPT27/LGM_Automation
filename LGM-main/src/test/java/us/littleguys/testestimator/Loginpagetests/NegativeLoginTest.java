package us.littleguys.testestimator.Loginpagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import us.littleguy.testestimator.pages.EstimatorLoginPage;
import us.littleguy.testestimator.pages.LGMJobsPage;
import us.littleguys.testestimator.base.CsvDataProviders;
import us.littleguys.testestimator.base.TestUtilities;

public class NegativeLoginTest extends TestUtilities {
	
	@Test(dataProvider = "csvReader" , dataProviderClass= CsvDataProviders.class)
	
	public void negativeloginTest(Map<String, String> readdata ) {
		// open main page

		 
				EstimatorLoginPage loginpage = new EstimatorLoginPage(driver, log);
				loginpage.openPage();
			Assert.assertEquals(loginpage.getPageText(), "Sign in to continue.");
		
				String username = readdata.get("username");
				String password = readdata.get("password");
				sleep(1000);
				loginpage.InvalidCaptch();
				sleep(1000);
				
				takeScreenshot("LoginPage opened");

				// execute log in 
				LGMJobsPage Loginpage = loginpage.logIn(username,password);
				sleep(10000);
				
				 
				
				// Verifications login
				// New page url is expected
				Assert.assertEquals(Loginpage.getCurrentUrl(), Loginpage.getPageUrl());  
	}
				
}
	
	
//	@Parameters({ "email" ,"Subject","Name","Description","dropdownvalue"})
//	@Test
//	public void createticket(String email, String subject, String name, String description, int dropdownvalue) {
//				
//		LGMJobsPage jobpage = new LGMJobsPage(driver, log);
//		jobpage.createTicket(email, subject, name, description, dropdownvalue);
//	}
	



