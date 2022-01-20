package Ders_Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01 {
    //3. Amazon sayfasina gidelim. https://www.amazon.com/
    //4. Sayfa basligini(title) yazdirin
    //5. Sayfa basliginin “Amazon” icerdigini test edin
    //6. Sayfa adresini(url) yazdirin
    //7. Sayfa url’inin “amazon” icerdigini test edin.
    //8. Sayfa handle degerini yazdirin
    //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
    //10. Sayfayi kapatin.

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");
        //4. Sayfa basligini(title) yazdirin
        System.out.println("Title => "+driver.getTitle());
        //5. Sayfa basliginin “Amazon” icerdigini test edin
        System.out.println(driver.getTitle().contains("Amazon") ? "Title test Pass" : "Title test Fail");
        //6. Sayfa adresini(url) yazdirin
        System.out.println("URL => "+driver.getCurrentUrl());
        //7. Sayfa url’inin “amazon” icerdigini test edin.
        System.out.println(driver.getCurrentUrl().contains("amazon") ? "URL testi Pass" : "URL testi Fail");
        //8. Sayfa handle degerini yazdirin
        System.out.println("Page Handle => "+driver.getWindowHandle());
        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin

        //10. Sayfayi kapatin.
        driver.close();

    }
}
