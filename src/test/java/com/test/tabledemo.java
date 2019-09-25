package com.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class tabledemo {
  @Test
  public void f() {
	  WebDriver driver=driver_utility.getDriver("chrome");
	  String url="http://10.232.237.143:443/TestMeApp/fetchcat.htm";
	  driver.get(url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  System.out.println("the title of the webpage is"+driver.getTitle());
	  driver.findElement(By.linkText("SignIn")).click();
	  driver.findElement(By.name("userName")).sendKeys("lalitha");
	  driver.findElement(By.id("password")).sendKeys("password123");
	  driver.findElement(By.name("Login")).click();
	  driver.findElement(By.xpath("//*[@id='menu3']/li[4]/a/span")).click();
	  WebElement objtable=driver.findElement(By.xpath("/html/body/b/section/div/div/div/form/table"));
	  List<WebElement> allrows=objtable.findElements(By.tagName("tr"));
	  for(WebElement row:allrows) {
		  List<WebElement> cells=row.findElements(By.tagName("td"));
		  for(WebElement cell:cells) {
			  System.out.println(cell.getText());
		  }
	  }
	  
	  
  }
}
