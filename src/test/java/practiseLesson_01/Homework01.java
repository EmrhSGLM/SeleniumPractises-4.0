package practiseLesson_01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework01 {

    // ...Exercise4...
// Navigate to website  https://testpages.herokuapp.com/styled/index.html
// Under the  ORIGINAL CONTENTS
// click on Alerts
// print the URL
// navigate back
// print the URL
// Click on Basic Ajax
// print the URL
// enter value-> 20 and Enter
// and then verify Submitted Values is displayed open page
// close driver
    public static void main(String[] args) {
        // ...Exercise4...
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//a[@id='alerts']")).click();
        System.out.println("URL = " + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("URLthat after back = " + driver.getCurrentUrl());
        driver.findElement(By.xpath("//a[@id='basicajax']")).click();
        System.out.println("URL that after Basic Ajax click = " + driver.getCurrentUrl());
        WebElement box = driver.findElement(By.id("lteq30"));
        box.sendKeys("20" + Keys.ENTER);
        WebElement writing = driver.findElement(By.xpath("//p[text()='Submitted Values']"));
        System.out.println(writing.isDisplayed() ? "PASS" : "FAIL");
        driver.close();
    }
}