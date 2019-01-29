package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase3 {

    // 1.Open browser
    // 2.Go to https://the-internet.herokuapp.com/forgot_password
    // 3.Enter any email
    // 4.Click on Retrieve password
    // 5.Verify url contains email_sent

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void gotoPage(){
        driver.get("https://the-internet.herokuapp.com/forgot_password");
    }

    @Test
    public void userName(){
        driver.findElement(By.id("email")).sendKeys("cybertek@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"form_submit\"]/i")).click();
    }

    @Test // 5.Verify url contains email_sent
    public void email(){
        driver.findElement(By.id("email")).sendKeys("cybertek@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"form_submit\"]/i")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("email_sent"));
    }

}
