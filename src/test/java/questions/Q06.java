package questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q06 {
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
        String actualText = driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals("Text Opening a new window degil",actualText, expectedText);
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals("Title The Internet degil",expectedTitle, actualTitle);
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "New Window";
        System.out.println(actualTitle1.equals(expectedTitle1) ? "Title 1 PASS" : "Title 1 FAIL");

        String actualText1= driver.findElement(By.className("example")).getText();
        String expectedText1 = "New Window";

        driver.get("https://the-internet.herokuapp.com/windows");
        String actualTitle2= driver.getTitle();
        String expectedTitle2="The Internet";
        Assert.assertEquals(expectedTitle2, actualTitle2);
        driver.quit();
    }
}
