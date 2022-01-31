package practiseLesson_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Q02 {

   //         ...Exercise2...
   //http://www.bestbuy.com 'a gidin,
   //Sayfa basliginin "Best" icerdigini(contains) dogrulayin
   //Ayrica Relative Locator kullanarak;
   //logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
   //mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test(){
        //http://www.bestbuy.com 'a gidin,
        driver.get("http://www.bestbuy.com");
        //Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Best";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //Ayrica Relative Locator kullanarak;
        //logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
        //mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
        WebElement logoText = driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        WebElement mexicoText = driver.findElement(By.xpath("(//*[@alt='Mexico'])[3]"));
        Assert.assertTrue(logoText.isDisplayed());
        WebElement link = driver.findElement(By.xpath("(//img[@alt='United States'])[2]"));
        WebElement usaLink = driver.findElement(with(By.tagName("img")).toRightOf(link));
        Assert.assertTrue(usaLink.isDisplayed());
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
}
