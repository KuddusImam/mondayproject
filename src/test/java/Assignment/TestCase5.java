package Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase5 {

    // 1.Open browser
    // 2.Go to http://the-internet.herokuapp.com/checkboxes
    // 3.Verify the first checkbox is not selected
    // 4.Verify the second checkbox is selected
    // 5.Click on the first checkbox
    // 6.Verify the first checkbox is selected
    // 7.Verify the second checkbox is selected
    // 8.Click on the second checkbox
    // 9.Verify the first checkbox is selected
    // 10.Verify the second checkbox is not selected

    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // implicity wait it makes timeout for find element(s) only
        wait=new WebDriverWait(driver,10);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void gotoPage() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");

    }

    @Test
    public void Test1() {
        new Actions(driver).pause(3000).perform();
        WebElement myele = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        myele.click();
        wait.until(ExpectedConditions.elementToBeClickable(myele));

        new Actions(driver).pause(3000).perform();
        WebElement myele2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        myele2.click();
        wait.until(ExpectedConditions.elementToBeClickable(myele2));


    }


}
