package com.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class DashboardPage {
    WebDriver driver;
    By dashboardPageTitle = By.xpath("//h6[text()='Dashboard']");
    By options = By.xpath("//p[normalize-space()='Assign Leave']");
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyDashboardPageTitle() {
        String DashboardPageTitle = driver.findElement(dashboardPageTitle).getText();
        Assert.assertTrue(DashboardPageTitle.contains("Dashboard"));
    }
    public void verifyQuickLaunchOptions() {
        String QuickLaunchOptions = driver.findElement(options).getText();
        Assert.assertTrue(QuickLaunchOptions.contains("Assign Leave"));
    }
}