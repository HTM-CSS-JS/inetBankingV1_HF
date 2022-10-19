package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjectsClass.Loginpage;
import com.inetBanking.utilites.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends Baseclass

{
	 @Test(dataProvider="LoginData")
   public void loginDDT(String user,String pwd) throws InterruptedException
   
   {
		 Loginpage lp=new Loginpage(driver);
		 
		 lp.setUserName(user);
		 Logger.info("user name is provided");
		 lp.setPassword(pwd);
		 Logger.info("pass is provided");
		 lp.clickSubmit();
		 Thread.sleep(300);
		 
		 
		 if(isAlertPresent()==true)
		 {
			driver. switchTo().alert().accept();
			driver.switchTo().defaultContent();//back to homepage
			
			Assert.assertTrue(false);
			
			Logger.warn("Lofin failed");
		 }
		 
		 else
		 {
			 Assert.assertTrue(true);
			 Logger.info("passed");
			 lp.clickLogout();
			 Thread.sleep(3000);
			 driver.switchTo().alert().accept();//close logout alert
			 
			 driver.switchTo().defaultContent();
		 }
		 
   }
	 
	 public boolean isAlertPresent()
	 {
		 try
		 {
			 driver.switchTo().alert();
			 return true;
		 }
		 catch(NoAlertPresentException e)
		 {
			 return false;
		 }
	 }
	 
	 @DataProvider(name="LoginData")
	 String [][]getData() throws IOException
	 {
		 String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		    //XL Utils methods
		 
		    int rownum=XLUtils.getRowCount(path,"sheet1");
		    int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		    
		    String logindata[][]=new String[rownum][colcount];
		    
		     //To get the data from xl
		    
		         for(int i=1;i<=rownum;i++)
		         {
		        	  //j=1 then use lessthan equal to j<=colcount
		        	 for(int j=0;j<colcount;j++)
		        	 
		        	  logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1",  i,j);//1 0
		        	  
		         }
		         
		         return logindata;
	 }
} 
