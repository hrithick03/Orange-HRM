package com.Tests;
import com.Pages.LoginPage;
import org.testng.annotations.Test;
import com.Pages.*;
import com.Utilities.*;
public class DashboardTests extends BaseTest{
      @Test (dataProvider ="excelData",dataProviderClass= DPExcel.class,
      description="Verify Dashborad Page using Data Driven approach")
      public void dashboardTest(String username,String password) {
    	  LoginPage objLogin = new LoginPage(getDriver());
    	  objLogin.login(username, password);
    	  if (username.equalsIgnoreCase("Admin")) {
    		  DashboardPage objDashboardpage = new DashboardPage(getDriver());
    		  objDashboardpage.verifyDashboardPageTitle();
    		  objDashboardpage.verifyQuickLaunchOptions();	  
    	  }
    	  else {
    		  System.out.println("Skipping dashboard validation for invalid user:"+username);
    	  }
      }


}
