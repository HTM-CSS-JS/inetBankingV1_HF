package com.inetBanking.pageObjectsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver Local_driver;;
	 
	//constructor
	public AddCustomerPage(WebDriver remote_driver)
	{
		Local_driver=remote_driver;;
		PageFactory.initElements(remote_driver , this);
		
	}
	
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddnewCustomer;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "name")
	WebElement txtCustomerName;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "rad1")
	WebElement rdGender;

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME,using = "dob")
	WebElement txtdob;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "addr")
	WebElement txtaddress;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "city")
	WebElement txtcity;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "state")
	WebElement txtstate;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "pinno")
	WebElement txtpinno;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "telephoneno")
	WebElement txttelephoneno;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "emailid")
	WebElement txtemailid;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "password")
	WebElement password;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "sub")
	WebElement btnsubmit;
	
	public void ClickAddNewCustomer()
	{
		lnkAddnewCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender)
	{
		rdGender.click();
	}
	
	public void custdob(String mm ,String dd ,String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custaddress(String caddress)
	{
		txtaddress.sendKeys(caddress);
	}
	
	public void custcity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	
	public void custstate(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	
	public void custpinno(String cpinno)
	
	{      //Incase of converting int to string we use String.valueof()
		//txtpinno.sendKeys(String.valueOf(cpinno));
		
		txtpinno.sendKeys(cpinno);
	}
	
       public void custtelephoneno(String ctelephoneno)
	
	{
		txttelephoneno.sendKeys(ctelephoneno);
	}
	
       public void custemailid(String cemailid)
   	
   	{
   		txttelephoneno.sendKeys(cemailid);
   	}
       
       public void custpassword(String cpassword)
      	
      	{
      		txttelephoneno.sendKeys(cpassword);
      	}
      	
       
       public void custsubmit()
      	
      	{
      		btnsubmit.click();
      	}
      	


   	

}
