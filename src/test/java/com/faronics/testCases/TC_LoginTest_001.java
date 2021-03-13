package com.faronics.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.faronics.pageOjects.Loginpage;


public class TC_LoginTest_001 extends Baseclass {

	@Test
	public void logintest() throws IOException {
		log.info("Url opening..!!!");
		driver.get(BaseUrl);
		Loginpage lp = new Loginpage(driver);
		lp.EnterEmailAddress(UserName);
		log.info("User entered the Email Address..!!");
		lp.EnterPassword(UserPass);
		log.info("User entered the Password..!!");
		lp.clickOnSignInbuttn();
		log.info("User clicked on the Sign In button..!!");
		
		if (driver.getTitle().equals("Faronics Deploy"))
		{
			log.info("Test case Passed..!!!");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "logintest");
			log.error("Test case Failed...!!!");
			Assert.assertTrue(false);
			
		}
		
		lp.clickOnSignoutbuttn();
		log.info("User logout Successfully...!!!");
	}

}
