package com.Tests;
import com.Pages.LoginPage;
import org.testng.annotations.Test;
import com.Utilities.*;
public class LoginTests extends BaseTest {
@Test(description="verify Login Page Title")
public void verifyLoginPage() {
	LoginPage objLogin = new LoginPage(getDriver());
	objLogin.verifyPageTitle();}
@Test(dataProvider = "excelData", dataProviderClass = DPExcel.class,
description = "Login Test with multiple credentials from Excel")
public void loginTest(String username, String password) {
LoginPage objLogin = new LoginPage(getDriver());

objLogin.login(username, password);
if (username.equalsIgnoreCase("Admin")) {
	objLogin.verifyDashboard();
}
else {
	objLogin.verifyErrorMessage();
}
	
}}

