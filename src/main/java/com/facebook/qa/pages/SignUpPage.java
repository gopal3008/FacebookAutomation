package com.facebook.qa.pages;

import org.testng.annotations.BeforeMethod;

import com.facebook.qa.base.Testbase;

public class SignUpPage extends Testbase {

	LoginPage loginPage;
	public SignUpPage() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	 
	
	
	
	
	
	
}
