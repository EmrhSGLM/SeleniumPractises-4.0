package practiseLesson_03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q01 {

     //...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test(){
        // http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        // click on the "Add Element" button 100 times
        WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));
        for(int i=1;i<=100;i++){
            addElement.click();
        }
        List<WebElement> deleteButtonBefore = driver.findElements(By.xpath("(//button[.='Delete'])"));
        // write a function that takes a number, and clicks the "Delete" button
        for(int i=1;i <= 60;i++){
            WebElement delete=driver.findElement(By.xpath("(//button[.='Delete'])[1]"));
            delete.click();
        }
        // given number of times, and then validates that given number of
        List<WebElement> deleteButtonAfter = driver.findElements(By.xpath("(//button[.='Delete'])"));
        // buttons was deleted
        System.out.println("Silinen delete sayisi : "+(deleteButtonBefore.size()-deleteButtonAfter.size()));
        System.out.println("Kalan delete sayisi : "+deleteButtonAfter.size());
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

}
