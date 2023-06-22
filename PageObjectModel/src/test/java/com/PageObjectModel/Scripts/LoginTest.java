package com.PageObjectModel.Scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PageObjectModel.Base.TestBase;
import com.PageObjectModel.Pages.LoginPage;
import com.PageObjectModel.Utilities.ExcelRead;
import com.PageObjectModel.constants.Constants;

public class LoginTest extends TestBase{
	LoginPage objLogin;
	
	@Test(dataProvider="invalidUserInvalidPassword")
	  public void verifySigninInvalidUserInvalidpass(String userName,String password1) {
		  
		  objLogin=new LoginPage(driver);
		  objLogin.setUserName(userName);
		  objLogin.setPassword(password1);
		  objLogin.clickSignIn();
		  
		  SoftAssert ast=new SoftAssert();
		  ast.assertEquals(driver.getTitle(),Constants.LOGINTITLE);
		  ast.assertAll();  
	  }
	
  @Test(dataProvider="invalidUserValidpassword",retryAnalyzer=com.PageObjectModel.Listners.RetryAnalyser.class)
  public void verifySigninInvalidUserValidpass(String userName,String password1) {
	  
	  objLogin=new LoginPage(driver);
	  objLogin.setUserName(userName);
	  objLogin.setPassword(password1);
	  objLogin.clickSignIn();
	  
	  SoftAssert ast=new SoftAssert();
	  ast.assertEquals(driver.getTitle(),Constants.LOGINTITLE);
	  ast.assertAll();  
  }
  
  @Test(dataProvider="validUserInvalidPassword")
  public void verifySigninValidUserInvalidpass(String userName,String password1) {
	  
	  objLogin=new LoginPage(driver);
	  objLogin.setUserName(userName);
	  objLogin.setPassword(password1);
	  objLogin.clickSignIn();
	  
	  SoftAssert ast=new SoftAssert();
	  ast.assertEquals(driver.getTitle(),Constants.LOGINTITLE);
	  ast.assertAll();  
  }
  
  @Test(dataProvider="validUserValidpassword")
  public void verifySigninValidUserValidpass(String userName,String password1) {
	  
	  objLogin=new LoginPage(driver);
	  objLogin.setUserName(userName);
	  objLogin.setPassword(password1);
	  objLogin.clickSignIn();
	  
	  SoftAssert ast=new SoftAssert();
	  ast.assertEquals(driver.getTitle(),Constants.HOMETITLE);
	  ast.assertAll();  
  } 
  
  
  
  @DataProvider
  public Object[][] invalidUserInvalidPassword() {
  	  Object[][] data=new Object[1][2];
  	  data[0][0]=ExcelRead.getCellStringData(0, 0, Constants.sheet1);
  	  data[0][1]=ExcelRead.getCellStringData(0, 1,Constants.sheet1);
  	  return data;
  }

@DataProvider
public Object[][] invalidUserValidpassword() {
	  Object[][] data=new Object[1][2];
	  data[0][0]=ExcelRead.getCellStringData(1, 0, Constants.sheet1);
	  data[0][1]=ExcelRead.getCellStringData(1, 1,Constants.sheet1);
	  return data;
}

@DataProvider
public Object[][] validUserInvalidPassword() {
	  Object[][] data=new Object[1][2];
	  data[0][0]=ExcelRead.getCellStringData(2, 0, Constants.sheet1);
	  data[0][1]=ExcelRead.getCellStringData(2, 1,Constants.sheet1);
	  return data;
}

@DataProvider
public Object[][] validUserValidpassword() {
	  Object[][] data=new Object[1][2];
	  data[0][0]=ExcelRead.getCellStringData(3, 0, Constants.sheet1);
	  data[0][1]=ExcelRead.getCellStringData(3, 1,Constants.sheet1);
	  return data;
} 
}