package Ders_Questions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q09 {

    //Class Work Amazon Search Test

    //1. https://www.amazon.com/ sayfasina gidelim
    //2. arama kutusunu locate edelim
    //3. --“Samsung headphones” ile arama yapalim
    //4. Bulunan sonuc sayisini yazdiralim
    //5. Ilk urunu tiklayalim
    //6. Sayfadaki tum basliklari yazdiralim

    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //1. https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com");
        //2. arama kutusunu locate edelim
       // WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement searchBox1 = driver.findElement(By.cssSelector("input[type=\"text\"]"));
        //3. --“Samsung headphones” ile arama yapalim
        searchBox1.sendKeys("Samsung headphones" + Keys.ENTER);
        //4. Bulunan sonuc sayisini yazdiralim
        String resultNumber = driver.findElement(By.xpath("(//span[@dir='auto'])[1]")).getText();
        String[] result=resultNumber.split(" ");
        System.out.println("Result Number : " + result[2]);
        //5. Ilk urunu tiklayalim
       driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
       //6. Sayfadaki tum sayfalari kapatalim
        driver.close();
    }
}
