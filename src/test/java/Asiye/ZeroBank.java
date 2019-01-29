package Asiye;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBank {

    /*
    1.Open browser
    2.Go to http://zero.webappsecurity.com/login.html
    3.Enter username username
    4.Enter password password
    5.Click sign in button
    6.Verify username is displayed on page
    7.Verify the title Zero -Account Summary
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();

        String expect = "username";
        String actual = driver.findElement(By.linkText("username")).getText();
        if(expect.equals(actual)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expect result: " + expect);
            System.out.println("actual result: " + actual);
        }

        String expectTitle = "Zero - Account Summary";
        String actualTitle = driver.getTitle();
        if(expectTitle.equals(actualTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expect result: " + expectTitle);
            System.out.println("actual result: " + actualTitle);
        }



    }


}
