package practiseLesson_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02 {

    //...Exercise4...
    //https://www.teknosa.com/ adresine gidiniz
    //arama cubuguna oppo yazip enter deyiniz
    //sonuc sayisini yazdiriniz
    //cikan ilk urune tiklayiniz
    //sepete ekleyiniz
    //sepetime git e tiklayiniz
    //consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
    //Alisverisi tamamlayiniz
    //son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
    //driver i kapatiniz

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        //https://www.teknosa.com/ adresine gidiniz
        driver.get("https://www.teknosa.com/");
        //arama cubuguna oppo yazip enter deyiniz
        driver.findElement(By.id("search-input")).sendKeys("oppo" + Keys.ENTER);
        //sonuc sayisini yazdiriniz
        System.out.println("Result number : " + driver.findElement(By.className("plp-info")).getText());
        //cikan ilk urune tiklayiniz
        driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();
        //sepete ekleyiniz
        driver.findElement(By.id("addToCartButton")).click();
        //sepetime git e tiklayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();
        //consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
        System.out.println("Text : " + driver.findElement(By.className("cart-sum-title")).getText());
        //Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();
        //son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
        System.out.println(driver.findElement(By.xpath("(//div[@class='lrl-title'])[1]")).getText());
    }
    @AfterClass
    public static void teardown(){
        //driver i kapatiniz
        driver.close();
    }
}
