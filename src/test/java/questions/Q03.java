package questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Q03 {
    //1.  https://id.heroku.com/login sayfasina gidin
    //2.  Bir mail adersi giriniz
    //3.  Bir password giriniz
    //4.  Login butonuna tiklayiniz
    //5.  "There was a problem with your login." texti gorunur ise
    //6.  "kayit yapilamadi" yazdiriniz
    //7.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
    //8.  Tum sayfalari kapatiniz
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver","src/drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1.  https://app.hubspot.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");
        //2.  Bir mail adresi giriniz
        WebElement emailBox =  driver.findElement(By.xpath("//input[@class='form-control']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@class='form-control password']"));
        emailBox.sendKeys("emrh@gmail.com");
        //3.  Bir password giriniz
        passwordBox.sendKeys("Test1234!");
        //4.  Login butonuna tiklayiniz
        WebElement logIn = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']"));
        logIn.click();
        //5.  "There was a problem with your login." texti gorunur ise
        //6.  "kayit yapilamadi" yazdiriniz
        //7.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        WebElement istenenYazi =  driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        System.out.println(istenenYazi.isDisplayed() ? "Kayit yapilamadi" : "Kayit yapilamadi");
        //8.  Tum sayfalari kapatiniz
        driver.quit();
    }
}
