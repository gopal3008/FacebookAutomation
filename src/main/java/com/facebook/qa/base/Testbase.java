package com.facebook.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.facebook.qa.utilities.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {

	public static WebDriver driver;  
	public static Properties prop;
	
	public Testbase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/"
					+ "facebook/qa/config/config.properties");
			prop.load(ip);
			System.out.println("Config Loading");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		System.out.println("read browser property");
		String browserName = prop.getProperty("browser").trim();//prop.getProperty("browser");
		System.out.println("Got browser name");
		System.out.println(browserName);
		if(browserName.equals("chrome")){
			System.out.println("chrome browser");
//			System.setProperty("webdriver.chrome.driver","C:/selenium/ChromeDriver_win32/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver  = new ChromeDriver();
		}
		else if(browserName.equals("FF")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE")){
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
//		else{
//			System.out.println("Please select the browser name out of : chrome/FF/IE");
//		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
