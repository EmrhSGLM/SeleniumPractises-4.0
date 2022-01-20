package Ders_Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02 {

    //2. Youtube ana sayfasina gidelim . https://www.youtube.com/
    //3. Amazon soyfasina gidelim. https://www.amazon.com/
    //4. Tekrar YouTube’sayfasina donelim
    //5. Yeniden Amazon sayfasina gidelim
    //6. Sayfayi Refresh(yenile) yapalim
    //7. Sayfayi tam ekran yapalim
    //8. Sayfayi kapatalim / Tum sayfalari kapatalim

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        //driver.get("https://www.youtube.com"); navigate() gore daha yavas
        driver.navigate().to("http://www.youtube.com");
        //3. Amazon soyfasina gidelim. https://www.amazon.com/
        //driver.get("https://www.amazon.com");
        driver.navigate().to("https://www.amazon.com");
        //4. Tekrar YouTube’sayfasina donelim
        driver.navigate().back();
        //5. Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
        //6. Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        //7. Sayfayi tam ekran yapalim
        driver.manage().window().fullscreen();
        //8. Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit();
    }
}
