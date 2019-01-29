package Asiye;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*
1.go to amazon
2.enter an item : BOOK
3.click submit botton
4.verify the result page shows BOOK


 */

public class amazonTestNG  {
WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @BeforeMethod
    public void gotowebPage(){

        driver.get("https://www.amazon.com/");
    }

    @Test
    public void searchItemInAmazon(){
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Book" + Keys.ENTER);
      String expect = "Book";
      String actual = driver.getTitle();

        Assert.assertTrue(actual.contains(expect));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
