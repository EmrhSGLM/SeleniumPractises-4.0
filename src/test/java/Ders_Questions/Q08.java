package Ders_Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q08 {

    // a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
    // b. Locate email textbox
    // c. Locate password textbox ve
    // d. Locate signin button
    // e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
    //          i. Username : testtechproed@gmail.com
    //          ii. Password : Test1234!
    // Sayfayi kapatin
    // NOT: cssSelector kullanarak elementleri locate ediniz.

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");
        //        // b. Locate email textbox
        WebElement emailCss = driver.findElement(By.cssSelector("input[type='email']"));
        //        // c. Locate password textbox ve
        WebElement passwordCss = driver.findElement(By.cssSelector("input[type='password']"));
        //        // d. Locate signin button
        WebElement signIn = driver.findElement(By.cssSelector("input[type='submit']"));
        //        // e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
        //        //          i. Username : testtechproed@gmail.com
        //        //          ii. Password : Test1234!
        emailCss.sendKeys("testtechproed@gmail.com");
        passwordCss.sendKeys("Test1234!");
        Thread.sleep(3000);
        signIn.click();
        Thread.sleep(3000);
        // Sayfayi kapatin
        driver.close();
    }
}
