package questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q05 {
//● https://www.amazon.com/ adresine gidin.
//              - Test 1
//    Arama kutusunun yanindaki kategori menusundeki kategori
//    sayisinin 45 oldugunu test edin
//              -Test 2
//1. Kategori menusunden Books secenegini secin
//2. Arama kutusuna Java yazin ve aratin
//3. Bulunan sonuc sayisini yazdirin
//4. Sonucun Java kelimesini icerdigini test edin
    static WebDriver driver;
    @Test
    public void test01(){
        //    https://www.amazon.com/ adresine gidin.
        //              - Test 1
        //    Arama kutusunun yanindaki kategori menusundeki kategori
        //    sayisinin 45 oldugunu test edin
        List<WebElement> kategoriSayisi = driver.findElements(By.xpath("//option"));
        System.out.println("Test 01");
        System.out.println(kategoriSayisi.size() == 45 ? "Kategori Sayisi testi PASS" :
                "Kategori Sayisi testi FAIL \nKategori Sayisi : " + kategoriSayisi.size());
    }

    @Test
    public void test02(){
        //              -Test 2
        //1. Kategori menusunden Books secenegini secin
        //2. Arama kutusuna Java yazin ve aratin
        //3. Bulunan sonuc sayisini yazdirin
        //4. Sonucun Java kelimesini icerdigini test edin
        System.out.println("Test 02");
        driver.findElement(By.xpath("(//option)[6]")).click();
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);
        List<WebElement> javaResultNumber = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println("Result Numbers : " + javaResultNumber.size());
        String actualWriting = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).getText();
        String expected = "Java";
        System.out.println(actualWriting.contains(expected) ? "Java testi PASSED" : "Java testi FAILED");
    }
    @BeforeClass
    public static void aracGerec(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public void finish(){
    driver.close();
    }
}
