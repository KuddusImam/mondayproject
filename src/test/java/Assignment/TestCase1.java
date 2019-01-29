package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 {

    // 1.Open browser
    // 2.Go to http://a.testaddressbook.com/sign_in
    // 3.Enter username kexesobepu@zsero.com
    // 4.Enter password password
    // 5.Click sign in button
    // 6.Verify username is displayed on page
    // 7.Verify the title does not include Sign In

    WebDriver driver;

    @BeforeClass
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void gotoPage(){
        driver.get("http://a.testaddressbook.com/sign_in");
    }

    @Test
    public void userName() {
//        driver.findElement(By.id("session_email")).sendKeys("kexesobepu@zsero.com");
////        driver.findElement(By.id("session_password")).sendKeys("password");
////        driver.findElement(By.name("commit")).click();
////
////        String expect = "kexesobepu@zsero.com";
////        String actual = driver.findElement(By.className("navbar-text")).getText();

        WebElement email = driver.findElement(By.id("session_email"));
        email.sendKeys("kexesobepu@zsero.com"); // this is another way
        //Enter password password
        driver.findElement(By.id("session_password")).sendKeys("password");
        //Click sign in button
        driver.findElement(By.name("commit")).click();
        //Verify username is displayed on page
        String expect = "kexesobepu@zsero.com";
        String actual = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[2]/span")).getText();
        Assert.assertTrue(actual.equals(expect));
        //Assert.assertEquals(actual,expect);
    }

    @Test // 7.Verify the title does not include Sign In
     public void title(){
        driver.findElement(By.id("session_email")).sendKeys("kexesobepu@zsero.com");
        driver.findElement(By.id("session_password")).sendKeys("password");
        driver.findElement(By.name("commit")).click();


        String expectTitle = "Address Book";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.equals(expectTitle));
       // Assert.assertEquals(actualTitle,expectTitle);

    }

    @AfterClass
    public void tearDown(){
    //  driver.quit();
    }

}



