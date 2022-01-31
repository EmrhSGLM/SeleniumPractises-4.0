package practiseLesson_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q04 {
    //      ...Exercise6...
    //  1. Amazon.com'a gidelim.
    //  2. DropDown üzerinde Books secelim.(All yazan yerde)
    //     kategorilerin hepsini konsola yazdiralim
    //  3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
    //  4. Sonuc sayisini ekrana yazdiralim.
    //  5. Sonucların Les Miserables i icerdigini assert edelim
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
        //  1. Amazon.com'a gidelim.
        driver.get("https:www.amazon.com");

        //  2. DropDown üzerinde Books secelim.(All yazan yerde)
        //     kategorilerin hepsini konsola yazdiralim
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        List<WebElement> optionsList = select.getOptions();
        optionsList.stream().forEach(t-> System.out.println(t.getText()));
        select.selectByVisibleText("Books");

        //  3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Les Miserables" + Keys.ENTER);

        //  4. Sonuc sayisini ekrana yazdiralim.
        String actualText=driver.findElement(By.xpath("//div[@class='a-section " +
                "a-spacing-small a-spacing-top-small']")).getText();
        String[] resultNumber = actualText.split(" ");
        System.out.println("resultNumber[3] = " + resultNumber[3]);

        //  5. Sonucların Les Miserables i icerdigini assert edelim
        String expectedText = "Les Miserables";
        Assert.assertTrue(actualText.contains(expectedText));
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
}
