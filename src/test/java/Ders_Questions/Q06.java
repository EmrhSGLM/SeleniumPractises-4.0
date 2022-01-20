package Ders_Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q06 {

    //a.amazon web sayfasına gidin. https://www.amazon.com
    //b. Search(ara) “city bike”
    //c.Amazon 'da görüntülenen ilgili sonuçların sayısını yazdırın
    //d.  Sonra karşınıza çıkan ilk sonucun resmine tıklayın.

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a.amazon web sayfasına gidin. https://www.amazon.com
        driver.get("https://www.amazon.com");
        //b. Search(ara) “city bike”
        WebElement searchBox = driver.findElement(By.xpath("//input[@autocomplete='off']"));
        WebElement searchClick = driver.findElement(By.xpath("//input[@type='submit']"));
        searchBox.sendKeys("city bike");
        searchClick.click();
        //c.Amazon 'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement number = driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println(number.getText());
        //d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.xpath("//img[@class='s-image'][1]")).click();

    }
}
