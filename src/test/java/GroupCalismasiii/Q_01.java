package GroupCalismasiii;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Q_01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");
        //4. Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());
        //5. Sayfa basliginin “Amazon” icerdigini test edin
        String actualTitle =  driver.getTitle();
        String expectedTitle = "Amazon";
        System.out.println(actualTitle.contains(expectedTitle) ? "Title test PASS" : "Title testi FAIL");

        //6. Sayfa adresini(url) yazdirin
        System.out.println("url => "+driver.getCurrentUrl());

        //7. Sayfa url’inin “amazon” icerdigini test edin.
        String actualURL =  driver.getCurrentUrl();
        String expectedURL = "amazon";
        System.out.println(actualURL.contains(expectedURL) ? "URL testi PASS" : "URL testi FAIL");

        //8. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());

        //9. Sayfa HTML kodlarinda “Customer Service” kelimesi gectigini test edin
        WebElement customer = driver.findElement(By.xpath("//a[@class='nav-a  '][2]"));
        System.out.println(customer.getText());
        System.out.println(customer.getText().contains("Customer") ? "Customer testi PASS" : "Customer testi FAIL");

        //10. Sayfayi kapatin.
        driver.close();
    }
}
