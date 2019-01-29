package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase2 {

    // 1.Open browser
    // 2.Go to http://zero.webappsecurity.com/login.html
    // 3.Enter username username
    // 4.Enter password password
    // 5.Click sign in button
    // 6.Verify username is displayed on page
    // 7.Verify the title Zero - Account Summary

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void gotoPage(){
        driver.get("http://zero.webappsecurity.com/login.html");
    }

    @Test // 7.Verify the title Zero-Account Summary
    public void title(){
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();

        String expectTitle = "Zero - Account Summary";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.equals(expectTitle));
    }

    @Test //6.Verify username is displayed on page
    public void userName(){
        driver.findElement(By.linkText("username")).getText();
    }


}
