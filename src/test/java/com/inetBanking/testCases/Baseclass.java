package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilites.ReadConfig;

//*** IF YOU WANT TO RUN FAILED TESTCASES WE HAVE TESTNG-FAILED.XML //INCASE THE FAILED TEST CASES ARE 50 ***//
public class Baseclass {

	ReadConfig readconfig=new ReadConfig();
	
	//*** ALL COMMON METHOD SHOULD BE PART OF BASECLASS WE CREATE ONE TIME AND ACCESS ANY TIME BASE CLASS METHODS//
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger Logger ;
	 
	  @Parameters("browser")
	  @BeforeClass
      public void setup(String br)
        
      { 
		  //Project home directory by System.setproperty
    	 
    	  Logger=Logger.getLogger("ebanking");
    	  PropertyConfigurator.configure("log4j.properties");
    	  
    	  if(br.equals("chrome"))
    		  
    	  {
    		  System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
        	  driver=new ChromeDriver();
        	  driver.get(baseURL);
        	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	  }
      }
	  
     @AfterClass
      public void tearDown()
      
      {
    	  
    	  driver.quit();
      }
     
     public void captureScreen(WebDriver driver,String tname)throws IOException{
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
    	FileUtils.copyFile(source, target);
    	System.out.println("Screenshot taken");
    	 
     }}


