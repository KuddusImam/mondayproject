package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase7 {

    /*
    1.Open browser
    2.Go to http://www.newtours.demoaut.com/
    3.Login using username tutorial and password tutorial
    4.Verify default Departing From value is Acapulco
    5.Verify list of locations: Acapulco, Frankfurt, London, New York, Paris, Portland, San Francisco, Seattle, Sydney, Zurich
    6.Test Departing From dropdown functionality by changing different values
     */

    WebDriver driver;
    WebDriverWait wait;
    Select dropdown;

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


        WebElement list = driver.findElement(By.name("fromPort"));
        WebElement defualtele = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select/option[1]"));
        new Actions(driver).pause(2000).perform();
        Assert.assertTrue(defualtele.isSelected());






    }


}
