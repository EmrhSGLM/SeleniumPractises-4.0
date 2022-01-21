package Ders_Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork_01 {

    //1.Yeni bir class olusturalim (Homework_01)
    //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
    //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
    //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
    //4. https://www.walmart.com/ sayfasina gidin.
    //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
    //6. Tekrar “facebook” sayfasina donun
    //7. Sayfayi yenileyin
    //8.Sayfayi tam sayfa (maximize) yapin
    //9.Browser’i kapatin

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        System.out.println(actualTitle.contains(expectedTitle) ? "Title testing PASSED" :
                "Title testing FAILED\nActual Title => "+driver.getTitle());
        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "facebook";
        System.out.println(actualURL.contains(expectedURL) ? "URL testing PASSED" : "URL testing FAILED");
        //4. https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com");
        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String actualTitle1 = driver.getTitle();
        String expectedTitle1= "Walmart.com";
        System.out.println(actualTitle1.contains(expectedTitle1) ? "Title testing PASSED" : "Title testing FAILED");
        //6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        //7. Sayfayi yenileyin
        driver.navigate().refresh();
        //8.Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        //9.Browser’i kapatin
        driver.close();
    }
}
