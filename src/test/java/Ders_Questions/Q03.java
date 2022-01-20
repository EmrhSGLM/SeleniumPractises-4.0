package Ders_Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03 {

    //2. Amazon soyfasina gidelim. https://www.amazon.com/
    //3. Sayfanin konumunu ve boyutlarini yazdirin
    //4. Sayfayi simge durumuna getirin
    //5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
    //6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
    //7. Sayfayi fullscreen yapin
    //8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
    //9. Sayfayi kapatin

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");
        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Position => "+driver.manage().window().getPosition());
        System.out.println("Size => "+driver.manage().window().getSize());
        //4. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();
        //5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();
        //6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Maximize Situation Position =>"+driver.manage().window().getPosition());
        System.out.println("Maximize Situation Size =>"+driver.manage().window().getSize());
        //7. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();
        //8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("FullScreen Situation Position =>"+driver.manage().window().getPosition());
        System.out.println("FullScreen Situation Size =>"+driver.manage().window().getSize());
        //9. Sayfayi kapatin
        driver.quit();

    }
}
