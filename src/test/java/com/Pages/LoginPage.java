package com.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class LoginPage {
	 WebDriver driver;
	 By username = By.name("username");
	 By password= By.name("password");
	 By titleText = By.xpath("//h5[normalize-space()='Login']");
	 By login = By.xpath("//button[normalize-space()='Login']");
	 By errorMessage = By.xpath("//p[@class='oxd-text ocd-text--p oxd-alert-content-text']");
	 By dashboard =By.xpath("//h6[[text()='Dashboard']");
	 public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }
	 public void setUserName(String strUserName) {
	        driver.findElement(username).sendKeys(strUserName);
	    }
	 public void setPassword(String strPassword) {
	        driver.findElement(password).sendKeys(strPassword);
	    }
	 public void clickLogin() {
	        driver.findElement(login).click();
	    }
	 public void verifyPageTitle() {
		 String loginPageTitle= driver.findElement(titleText).getText();
	     Assert.assertTrue(loginPageTitle.contains("Login"));	 
	 }
	 public void verifyErrorMessage() {
		 String invalidCredentialsErrorMessage =driver.findElement(errorMessage)
.getText()	;
		 Assert.assertTrue(invalidCredentialsErrorMessage.contains("Invalid credentials"));
	 }
	 public void verifyDashboard() {
	        String dashboardText = driver.findElement(dashboard).getText();
	        Assert.assertTrue(dashboardText.contains("Dashboard"), "Dashboard not displayed after login!");
	 }
	 public void login(String struserName,String strPasword) {
		 this.setUserName(struserName);;
		 this.setPassword(strPasword);
		 this.clickLogin();
		 
	 }

}	
