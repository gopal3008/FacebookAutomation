package com.facebook.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.Testbase;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;

public class LoginPageTest extends Testbase {

	LoginPage loginPage;
	HomePage homePage;
	public  LoginPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	@Test(priority=1,enabled=false)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	@Test(priority=2,enabled=true)
	public void loginPageImagetest(){
		boolean loginImage = loginPage.validateLoginImage();
		Assert.assertTrue(loginImage);
	}
//	@Test(priority=3)
//	public void loginTest() throws InterruptedException{
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		
//	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
