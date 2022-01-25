package practiseLesson_01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03 {

    // ...Exercise3...
// go to url : https://www.techlistic.com/p/selenium-practice-form.html
//fill the firstname
//fill the firstname
//check the gender
//check the experience
//fill the date
//choose your profession -> Automation Tester
//choose your tool -> Selenium Webdriver
//choose your continent -> Antartica
//choose your command  -> Browser Commands
//click submit button
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.xpath("//a[text()='Tamam']")).click();
        //fill the firstname
        WebElement first = driver.findElement(By.xpath("//input[@name='firstname']"));
        first.sendKeys("Emrah");
        //fill the lastname
        WebElement last = driver.findElement(By.xpath("//input[@name='lastname']"));
        last.sendKeys("SGLM");
        //check the gender
        WebElement cinsiyet = driver.findElement(By.xpath("//input[@id='sex-0']"));
        cinsiyet.click();
        //check the experience
        WebElement experience =driver.findElement(By.xpath("//input[@id='exp-0']"));
        experience.click();
        //fill the date
        WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
        date.sendKeys("12.12.2020");
        //choose your profession -> Automation Tester
        WebElement profession = driver.findElement(By.xpath("//input[@id='profession-1']"));
        profession.click();
        //profession.sendKeys(Keys.PAGE_DOWN);
        //choose your tool -> Selenium Webdriver
        WebElement tool = driver.findElement(By.xpath("//input[@id='tool-2']"));
        tool.click();
        //choose your continent -> Antartica
        driver.findElement(By.xpath("//option[text()='Antartica']")).click();
        //choose your command  -> Browser Commands
        driver.findElement(By.xpath("//option[text()='Browser Commands']")).click();
        //click submit button
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        driver.close();
    }
}
