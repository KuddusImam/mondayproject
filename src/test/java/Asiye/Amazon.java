package Asiye;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
    /*Search Amazon
    1.Open browser
    2.Go to https://amazon.com
    3.Enter any search term
    4.Click on search button
    5.Verify title contains the search term
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("soccer ball");
        driver.findElement(By.className("nav-input")).click();

        String expectTitle = "Amazon.com: soccer ball";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains("soccer ball")){
            //if(expectTitle.equals(actualTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expect title: " + expectTitle);
            System.out.println("actual title: " + actualTitle);
        }
        
        //This line I add from Git Hub

    }
}
