package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjectsClass.Loginpage;

public class TC_LoginTest_001 extends Baseclass {
	
	@Test
	public void loginTest()throws IOException
	{
		driver.get(baseURL);
		
		Logger.info("URL is opened");
		
		Loginpage lp=new Loginpage(driver);
		
		lp.setUserName(username);
		Logger.info("Entered username");
		
		lp.setPassword(password);
		Logger.info("Entered password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
			Logger.info("Login test is passed");
			
		}
		
		else
		{
			 captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			Logger.info("Login test is failed");
		}
	}
	

}
