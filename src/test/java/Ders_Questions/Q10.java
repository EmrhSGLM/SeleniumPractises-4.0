package Ders_Questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q10 {

    //1.Test01 isimli bir class olusturun
    //2.https://www.walmart.com/ adresine gidin
    //3.Browseri tam sayfa yapin
    //4.Sayfayi “refresh” yapin
    //5.Sayfa basliginin “Save” ifadesi icerdigini control edin
    //6.Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
    //7.URL in walmart.com icerdigini control edin
    //8.--”Nutella” icin arama yapiniz
    //9.Kac sonuc bulundugunu yaziniz
    //10.Sayfayi kapatin
    static WebDriver driver;
    Boolean varMi;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test(){
        //2.https://www.walmart.com/ adresine gidin
        driver.get("https://www.walmart.com/");

        //3.Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4.Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5.Sayfa basliginin “Save” ifadesi icerdigini control edin
        String actualTitle = driver.getTitle();
        String expectedTitle="Save";
        varMi=actualTitle.contains(expectedTitle);
        Assert.assertTrue(varMi);

        //6.Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        String expectedTitle2="Walmart.com | Save Money.Live Better";
        Assert.assertEquals(expectedTitle2,actualTitle);

        //7.URL in walmart.com icerdigini control edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "walmart.com";
        varMi=actualUrl.contains(expectedUrl);
        Assert.assertTrue(varMi);

        //8.--”Nutella” icin arama yapiniz
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        //9.Kac sonuc bulundugunu yaziniz
    }
    @BeforeClass
    public static void teardown(){
        //10.Sayfayi kapatin
       // driver.close();
    }

}
