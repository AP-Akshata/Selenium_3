package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Apachepoi_demo1 {
  @Test
  public void f() throws IOException, InterruptedException {
	  File src=new File("C:\\Users\\training_b6B.01.16\\Desktop\\TestData.xlsx");
	  FileInputStream fis=new FileInputStream(src);
	  XSSFWorkbook WB=new XSSFWorkbook(fis);
	  XSSFSheet SH=WB.getSheetAt(0);
	  System.out.println("first row number: "+SH.getFirstRowNum());
	  System.out.println("last row number: "+SH.getLastRowNum());
	  int rowCount=SH.getLastRowNum()-SH.getFirstRowNum();
	  System.out.println("The total rowcount is "+rowCount);
	  System.out.println(SH.getRow(0).getCell(0).getStringCellValue()+"\t\t"+SH.getRow(0).getCell(1).getStringCellValue());
	  System.out.println(SH.getRow(1).getCell(0).getStringCellValue()+"\t\t"+SH.getRow(1).getCell(1).getStringCellValue());
	  for(int i=1;i<=rowCount;i++)
	  {
		  //getting from excel sheet
		  System.out.println(SH.getRow(i).getCell(0).getStringCellValue()+"\t\t"+SH.getRow(i).getCell(1).getStringCellValue());
		  WebDriver driver=driver_utility.getDriver("chrome");
		  String url="http://10.232.237.143:443/TestMeApp/fetchcat.htm";
		  driver.get(url);
		  driver.findElement(By.linkText("SignIn")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.name("userName")).sendKeys(SH.getRow(i).getCell(0).getStringCellValue());
		  Thread.sleep(2000);
		  driver.findElement(By.name("password")).sendKeys(SH.getRow(i).getCell(1).getStringCellValue());
		  Thread.sleep(2000);
		  driver.findElement(By.name("Login")).click();
		  Thread.sleep(2000);
		  //driver.close();
	  
		 //writing to excel sheet
		  XSSFRow header1=SH.getRow(0);
		  XSSFCell header2=header1.createCell(2);
		  header2.setCellValue("status");
		  SH.getRow(1).createCell(2).setCellValue("Pass");
		  SH.getRow(2).createCell(2).setCellValue("Fail");
		  FileOutputStream fos=new FileOutputStream(src);
		  WB.write(fos);
		  ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:\\Users\\training_b6B.01.16\\Desktop\\mynewextenthtmlreport_ak.html");
		  ExtentReports extent=new ExtentReports();
		  extent.attachReporter(reporter);
		  ExtentTest logger=extent.createTest("DemoWebShop");
		  //to add image
		  logger.addScreenCaptureFromPath("");
		  logger.log(Status.INFO, "Apache poi is used in this script");
		  logger.log(Status.PASS, "Excel data reading is done successfully");
		  logger.log(Status.FAIL, MarkupHelper.createLabel("This test case is fail", ExtentColor.CYAN));
		  extent.flush();
		  driver.close();
	  }
	  
  }
}
