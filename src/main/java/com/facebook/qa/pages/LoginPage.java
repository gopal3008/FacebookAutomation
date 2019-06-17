package com.facebook.qa.pages;

import java.lang.annotation.Native;
import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.Testbase;

public class LoginPage extends Testbase{

	//PageFactory --OR
	@FindBy(name="username")
	WebElement username;
	
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn; 
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img')]")
	WebElement LoginImage;
	
//	how to initialize the pagefactory elements
//	there is an method called initelements which initializes all objects using parent class driver
	
	public LoginPage(){
	PageFactory.initElements(driver, this);//instead of this we can use LoginPage.class	
	}
	
	//Actions--> different features
	public String validateLoginPageTitle(){
		
		return driver.getTitle();
	}
	public boolean validateLoginImage(){
		return LoginImage.isDisplayed();
	}
	public HomePage login(String un,String pwd){
		username.clear();
		password.clear();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage();
	}
	
}
