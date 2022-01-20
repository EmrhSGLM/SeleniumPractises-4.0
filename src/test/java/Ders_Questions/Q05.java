package Ders_Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q05 {
    //a. http://a.testaddressbook.com adresine gidiniz.
    //b. Sign in butonuna basin
    //c. email textbox,password textbox, and signin button elementlerini locate
    //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign i n)buttonunu tıklayın:
    //      i. Username :testtechproed@gmail.com
    //      ii. Password : Test1234!
    //e. Expected user id nin
    //testtechproed@gmail.com oldugunu dogrulayin(verify).
    //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
    //Sayfayi kapatin

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        //b. Sign in butonuna basin
        WebElement sigInButton =  driver.findElement(By.id("sign-in"));
        sigInButton.click();
        //c. email textbox,password textbox, and signin button elementlerini locate
        WebElement emailTextBox = driver.findElement(By.xpath("//input[@name='session[email]']"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@name='session[password]']"));


        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign i n)buttonunu tıklayın:
        //      i. Username :testtechproed@gmail.com
        //      ii. Password : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        driver.findElement(By.xpath("//input[@name='commit']")).click();

        //e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement actualText =  driver.findElement(By.className("navbar-text"));
        String expectedText = "testtechproed@gmail.com";
        System.out.println(actualText.getText().contains(expectedText) ? "Email test PASS" : "Email test FAIL");

        //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement actualAdres = driver.findElement(By.xpath("//a[@class='nav-item nav-link'][1]"));
        String expectedAdres="Addresses";
        System.out.println(actualAdres.getText().contains(expectedAdres) ? "Adres testi PASS" : "Adres testi FAIL");
        WebElement actualSignOut = driver.findElement(By.xpath("//a[@class='nav-item nav-link'][2]"));
        String expectedSignOut="Sign out";
        System.out.println(actualSignOut.getText().contains(expectedSignOut) ? "Sign Out testi PASS" : "Sign Out testi FAIL");

        //Sayfayi kapatin
        driver.close();
    }

}
