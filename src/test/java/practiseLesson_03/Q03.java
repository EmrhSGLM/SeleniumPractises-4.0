package practiseLesson_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03 {

    //   ...Exercise5...
    //  @BeforeClass ın icerisinde driver i kuralim
    //  maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
    //  Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
    //  Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
    //  @AfterClass ta driver ı kapatalim
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        //  Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
        driver.get("https://www.google.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertTrue("It does not contain Google",actualTitle.contains(expectedTitle));
        //  Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
        driver.get("https://www.amazon.com");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "www.amazon.com";
        Assert.assertTrue("It does not contain amazon",actualUrl.contains(expectedUrl));
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }


}
