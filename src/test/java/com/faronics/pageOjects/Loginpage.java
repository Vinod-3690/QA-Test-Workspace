package com.faronics.pageOjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	public WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// PageObject declaration
	
	
	@FindBy(id="EmailAddress")
	@CacheLookup
	WebElement Email;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement passwd;
	
	@FindBy(css = "input[type='submit']")
	@CacheLookup
	WebElement loginbuttn;
	
	@FindBy(xpath = "//i[@class='fa fa-user-circle']")
	@CacheLookup
	WebElement Usericon;
	
	@FindBy(xpath = "//a[normalize-space()='Sign Out']")
	@CacheLookup
	WebElement Signoutbuttn;

	// Action Methods
	
	
	public void EnterEmailAddress(String mail)
	{
		Email.sendKeys(mail);
	}
	
	public void EnterPassword(String pass)
	{
		passwd.sendKeys(pass);
	}
	
	public void clickOnSignInbuttn()
	{
		loginbuttn.click();
	}
	
	public void clickOnSignoutbuttn()
	{
		Usericon.click();
		Signoutbuttn.click();
	}
	
}
