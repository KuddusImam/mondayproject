package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase4 {

    // 1.Open browser
    // 2.Go to https://the-internet.herokuapp.com/
    // 3.Click link File download
    // 4.Verify title contains on download
    // 5.Navigate to previous page
    // 6.Click link File upload
    // 7.Verify title contains on upload

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void gotoPage(){

        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test // 3.Click link File download
    public void click(){

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[14]/a")).click();
    }

    @Test // 4.Verify title contains on download
    public void title(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[14]/a")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("download"));
    }

    @Test // 5.Navigate to previous page
    public void back(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[14]/a")).click();
        driver.navigate().back();
    }

    @Test // 6.Click link File upload
    public void upload(){

        driver.findElement(By.linkText("File Upload")).click();
    }

    @Test // 7.Verify title contains on upload
    public void title2(){
        upload();
        Assert.assertTrue(driver.getCurrentUrl().contains("upload"));
    }


}
