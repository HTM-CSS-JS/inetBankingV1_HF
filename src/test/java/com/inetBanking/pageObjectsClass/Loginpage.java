package com.inetBanking.pageObjectsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Created Page Object Class
public class Loginpage {
	
	//create driver object and import
	
	WebDriver Local_driver;
	
      //Create a constructor pass webdriver driver
	
    public Loginpage(WebDriver remote_driver){
		
		Local_driver=remote_driver;
		
		//We have to intialize page factory class
		
		PageFactory.initElements(remote_driver,this);
		
	}
	
	  @FindBy(name="uid")
	  WebElement txtUserName;
	  
	  @FindBy(name="password")
	  WebElement txtPassword;
	  
	  @FindBy(name="btnLogin")
	  WebElement btnLogin;
	  
	  
	  @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	  WebElement lnkLogout;
	  
	  public void setUserName(String uname)
	  {
		  txtUserName.sendKeys(uname);
	  }
	  public void setPassword(String Password)
	  {
		  txtPassword.sendKeys(Password);
	  }
	  
	  public void clickSubmit( )
	  {
		  btnLogin.click();
	  }
	  
	  public void  clickLogout()
	  {
		  lnkLogout.click();
	  }
}
