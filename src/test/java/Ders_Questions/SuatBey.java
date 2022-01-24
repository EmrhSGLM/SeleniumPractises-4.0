package Ders_Questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SuatBey {
    //          test1
    //n11 sayfasına git,
    //JBL kulaklık arat,
    //gelen ilk ürünü tıkla
    //ürünü sepete ekle
    //          test2
    //JBL Blutoth hoparlör arat,
    //gelen ilk ürüne tıkla
    //ürünü sepete ekle
    //          test3
    //sepete git,
    //kaç tane ürün olduğuna bak,
    //ürünlerin seçilen ürün olup olmadığını doğrula
    static WebDriver driver;
    static WebElement searchBox;
    static String eklenenUrun1;
    static String eklenenUrun2;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.n11.com");
    }
    @Test
    public void test01() throws InterruptedException {
        searchBox = driver.findElement(By.xpath("//input[@id='searchData']"));
        searchBox.sendKeys("JBL kulaklık" + Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//h3[@class='productName'])[1]")).click();
        eklenenUrun1=driver.findElement(By.xpath("(//h3[@class='productName'])[1]")).getText();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Sepete Ekle']")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test02() throws InterruptedException {
        searchBox = driver.findElement(By.xpath("//input[@id='searchData']"));
        searchBox.sendKeys("JBL Bleutoth hoparlör"+ Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//img[@class='lazy'])[9]")).click();
        eklenenUrun2=driver.findElement(By.xpath("(//h3[@class='productName'])[1]")).getText();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Sepete Ekle']")).click();
        Thread.sleep(2000);
    }
    @Test
    public void test03(){
        driver.findElement(By.xpath("//i[@class='icon iconBasket']")).click();
        driver.findElement(By.xpath("//span[text()='Tamam']")).click();
        List<WebElement> sepettekiUrunSayisi=driver.findElements(By.xpath("(//a[@class='prodDescription'])"));
        System.out.println("Sepetteki Urun Sayisi : " + sepettekiUrunSayisi.size());
        String sepetUrun2=driver.findElement(By.xpath("(//a[@class='prodDescription'])[1]")).getText();
        String sepetUrun1=driver.findElement(By.xpath("(//a[@class='prodDescription'])[2]")).getText();
       // Ternary ile Cozum
        System.out.println(eklenenUrun1.equals(sepetUrun1) ? "Sepet Urun 1 testi PASS" : "Sepet Urun 1 testi FAIL");
        System.out.println(eklenenUrun2.equals(sepetUrun2) ? "Sepet Urun 2 testi PASS" : "Sepet Urun 2 testi FAIL");

        // Assert Class'indan kullanılan hazir methodlar ile cozum
        //Assert.assertTrue("1.eklenen urun ile sepetteki urun uyusmadi",eklenenUrun1.equals(sepetUrun1));
        //Assert.assertTrue("2.eklenen urun ile sepetteki urun uyusmadi",eklenenUrun2.equals(sepetUrun2));
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
}
