package Ders_Questions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04 {

    //2. Amazon soyfasina gidelim. https://www.amazon.com/
    //3. Sayfanin konumunu ve boyutlarini yazdirin
    //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
    //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
    //6. Sayfayi kapatin

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");
        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Position => "+driver.manage().window().getPosition());
        System.out.println("Size => "+driver.manage().window().getSize());
        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(100,100));
        driver.manage().window().setSize(new Dimension(100,100));
        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        int x = driver.manage().window().getPosition().getX();
        int y = driver.manage().window().getPosition().getY();
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        System.out.println("width : "+width + " height : "+height);
        if(x==100 && y==100 ){System.out.println("Position testi PASS");}else { System.out.println("Position testi FAIL");}
        if(width==100 && height==100 ){System.out.println("Size testi PASS");}else { System.out.println("Size testi FAIL");}
        //6. Sayfayi kapatin
        driver.quit();
    }
}
