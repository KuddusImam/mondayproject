package Asiye;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddressBook {
    /*
    1.Open browser
    2.Go to http://a.testaddressbook.com/sign_in
    3.Enter username kexesobepu@zsero.com
    4.Enter password password
    5.Click sign in button
    6.Verify username is displayed on page
    7.Verify the title does not include Sign In
     */

    public static void main(String[] args) {

        //This is the first step we do when request to open browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //To use open specific URL
        driver.get("http://a.testaddressbook.com/sign_in");

        //Enter username kexesobepu@zsero.com
        //driver.findElement(By.id("session_email")).sendKeys("kexesobepu@zsero.com");// this is the one way

        WebElement email = driver.findElement(By.id("session_email"));
        email.sendKeys("kexesobepu@zsero.com"); // this is another way

        //Enter password password
        driver.findElement(By.id("session_password")).sendKeys("password");

        //Click sign in button
        driver.findElement(By.name("commit")).click();

        //Verify username is displayed on page
        String expect = "kexesobepu@zsero.com";
        String actual = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[2]/span")).getText();

        if(expect.equals(actual)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expect result: "+ expect);
            System.out.println("actual result: "+ actual);
        }

        //Verify the title does not include Sign In
        String expectTitle = "Address Book";
        String actualTitle = driver.getTitle();

        if(expectTitle.equals(actualTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expect result: "+ expectTitle);
            System.out.println("actual result: "+ actualTitle);
        }



    }
}
