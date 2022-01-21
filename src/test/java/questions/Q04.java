package questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q04 {

    // a. http://a.testaddressbook.com adresine gidiniz.
    // b. Sign in butonuna basin
    // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
    // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
    // i. Username : testtechproed@gmail.com
    // ii.Password : Test1234!
    // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
    // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
    //3. Sayfada kac tane link oldugunu bulun.
    //4.Linklerin yazisini nasil yazdirabiliriz
    //5. driver i kapatin
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        // b. Sign in butonuna basin
        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailBox = driver.findElement(By.xpath("//input[@class='form-control'][1]"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement signinButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //          i. Username : testtechproed@gmail.com
        //          ii.Password : Test1234!
        emailBox.sendKeys("testtechproed@gmail.com");
        passwordBox.sendKeys("Test1234!");
        signinButton.click();
        // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        String actualId=driver.findElement(By.xpath("//span[@class='navbar-text']")).getText();
        String expectedId="testtechproed@gmail.com";
        System.out.println(actualId.equals(expectedId) ? "Id testing PASSED" : "Id testing FAILED");
        // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement adressTitle = driver.findElement(By.xpath("//a[text()='Addresses']"));
        WebElement signOutTitle = driver.findElement(By.xpath("//a[text()='Sign out']"));
        System.out.println(adressTitle.isDisplayed() ? "Adress testing PASSED" : "Adress testing FAILED");
        System.out.println(signOutTitle.isDisplayed() ? "Sign Out testing PASSED" : "Sign Out testing FAILED");
        //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linkNumber = driver.findElements(By.tagName("a"));
        //4.Linklerin sayilarini yazdirin
        System.out.println("Link number => " + linkNumber.size());
        //5. driver i kapatin
        driver.close();
    }

}
