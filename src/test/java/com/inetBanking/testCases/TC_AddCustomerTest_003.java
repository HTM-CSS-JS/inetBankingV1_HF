package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjectsClass.AddCustomerPage;
import com.inetBanking.pageObjectsClass.Loginpage;



public class TC_AddCustomerTest_003 extends Baseclass
{
	
	@Test
     public void addNewCustomer() throws InterruptedException, IOException
     {
		//Performing Login Process
		Loginpage lp=new Loginpage(driver);
		lp.setUserName(username);
		
		Logger.info("User name is provided");
		lp.setPassword(password);
		
		Logger.info("Password is Provided");
		lp.clickSubmit();
		
		
		
		Thread.sleep(3000);
		
		//Create page  class object 
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.ClickAddNewCustomer();
		
		Logger.info("providing Cutomer details!!!!");
		
		addcust.custName("Mudsir");
		addcust.custGender("male");
		addcust.custdob("30","10","15");//Text box three different parts 
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYDERABAD");
		addcust.custstate("TELANGANA");
		addcust.custpinno("50003001");
		addcust.custtelephoneno("986754554");
		
	 String email=randomestring()+"@gmail.com";
	 addcust.custemailid(email);
	 addcust.custpassword("abcdef");
	 addcust.custsubmit();
	 
	 Thread.sleep(3000);
	 
	 Logger.info("Validation started!!!! ");
	 
	 Thread.sleep(7000);
	 
	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	 
	 if(res==true)
	 {
		 Assert.assertTrue(true);
		 Logger.info("test case is passed !!!");
	 }
	 
	 else
	 {
		 Logger.info("test case is failed******");
		 captureScreen(driver,"addnewCustomer");
		 Assert.assertTrue(false);
		
	 }}
	 
	 
	//Randomstring method

	 public String randomestring()
	 {
	 	 String generatedstring=RandomStringUtils.randomAlphabetic(8);
	 	return generatedstring;
	 }

	 public String randomeNum()
	 {
	 	 String generatedstring2=RandomStringUtils.randomNumeric(8);
	 	return generatedstring2;
	 }
     }
		
     
	
	  

