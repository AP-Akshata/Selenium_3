package com.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class driver_utility {
  public static WebDriver getDriver(String browser) {
	  if(browser.equals("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b6B.01.16\\Desktop\\Browser Drivers\\chromedriver.exe");
		  return new ChromeDriver();
	  }else if(browser.equals("firefox")) {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\training_b6B.01.16\\Desktop\\Browser Drivers\\geckodriver.exe");
		  return new FirefoxDriver();
	  }
	  else if(browser.equals("ie")) {
		  System.setProperty("webdriver.ie.driver", "C:\\Users\\training_b6B.01.16\\Desktop\\Browser Drivers\\IEDriverServer.exe");
		  return new InternetExplorerDriver();
	  }
	  else
		  return null;
  }
}
