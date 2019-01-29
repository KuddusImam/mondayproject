package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase6 {

    /*
    1.Open browser
    2.Go to http://www.newtours.demoaut.com/
    3.Login using username tutorial and password tutorial
    4.Verify Round Trip is selected by default
    5.Verify One Way is not selected by default
    6.Click one way
    7.VerifyRound Trip selected not selected
    8.VerifyOne Way is selected
     */

    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void build(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);

    }

    @BeforeMethod
    public void gotoPage(){
        driver.get("http://www.newtours.demoaut.com/");

    }

    @Test
    public void logIn(){
        driver.findElement(By.name("userName")).sendKeys("tutorial");
        driver.findElement(By.name("password")).sendKeys("tutorial");
        driver.findElement(By.name("login")).click();

        WebElement roundtrip = driver.findElement(By.xpath("//input[@value='roundtrip']"));
        Assert.assertTrue(roundtrip.isSelected());

        WebElement onewayTrip = driver.findElement(By.xpath("//input[@value='oneway']"));
        Assert.assertFalse(onewayTrip.isSelected());
        onewayTrip.click();
        Assert.assertTrue(onewayTrip.isSelected());

        Assert.assertFalse(roundtrip.isSelected());
        Assert.assertTrue(onewayTrip.isSelected());
    }



}
