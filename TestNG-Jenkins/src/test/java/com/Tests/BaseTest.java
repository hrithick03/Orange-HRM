package com.Tests;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class BaseTest {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public WebDriver getDriver() {
        return driver.get();
    }
	@SuppressWarnings("deprecation")
	@BeforeMethod
    public void setup() {
        WebDriver localDriver = new ChromeDriver();
        localDriver.manage().window().maximize();
        localDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        localDriver.get("https://opensource-demo.orangehrmlive.com/");
        driver.set(localDriver);
    }
    @AfterMethod
    public void close() {
        getDriver().quit();
    }
}