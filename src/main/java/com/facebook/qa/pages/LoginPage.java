package com.facebook.qa.pages;

import java.lang.annotation.Native;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.facebook.qa.base.Testbase;
import com.facebook.qa.utilities.TestUtil;

public class LoginPage extends Testbase{

	//PageFactory --OR
	@FindBy(name="email")
	WebElement email;
	
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn; 
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img')]")
	WebElement LoginImage;
	
	@FindBy(name="firstname")
	WebElement FirstName;
	
	@FindBy(name="lastname")
	WebElement LastName ;
	
	@FindBy(name="reg_email__")
	WebElement emailAdress;
	
	@FindBy(name="reg_email_confirmation__")
	WebElement ConfirmEmail;
	
	@FindBy(name="reg_passwd__")
	WebElement Pwd;
	
	@FindBy(name="birthday_day")
	WebElement day;
	
	@FindBy(name="Month")
	WebElement month;
	
	@FindBy(name="Year")
	WebElement year;
	
	@FindBy(xpath="//input[@value='2']")
	WebElement Gender;
	
	@FindBy(name="websubmit")
	WebElement Submit;
	
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
	public HomePage login(String un,String pwd) throws InterruptedException{
//		email.clear();
//		password.clear();
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		Thread.sleep(2000) ;
//		WebDriverWait wait = new WebDriverWait(driver, 120); //you can play with the time integer  to wait for longer than 15 seconds.`
//		wait.until(ExpectedConditions.titleContains("Facebook")); //if you want to wait for a particular title to show up
//		driver.manage().timeouts().pageLoadTimeout(TestUtil.EXPLICIT_PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		return new HomePage();
	}
	
	public SignUpPage NewUserSignup(){
		Submit.click();
		return new SignUpPage();
	}
	
	
	
}
