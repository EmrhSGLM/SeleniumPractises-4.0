package questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02 {

    //   1-driver olusturalim
    //   2-java class'imiza chromedriver.exe'yi tanitalim
    //   3-driver'in tum ekrani kaplamasini saglayalim
    //   4-https://github.com/ adresine gidelim
    //   5-Ardindan https://www.hepsiburada.com/ adrsine gidelim
    //   6-Title ve url console da yazdirin ve yine title ve url in "burada" kelimesini icerip icermedigini kontrol edelim
    //   7-Sonrasinda https://github.com/ adresine geri donelim ve  sayfayi yenileyelim
    //   8-Son adim olarak butun sayfalarimizi kapatmis olalim

    public static void main(String[] args) throws InterruptedException {
        //   2-java class'imiza chromedriver.exe'yi tanitalim
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        //   1-driver olusturalim
        WebDriver driver = new ChromeDriver();
        //   3-driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //   4-https://github.com/ adresine gidelim
        driver.navigate().to("https://github.com");
        //   5-Ardindan https://www.hepsiburada.com/ adrsine gidelim
        driver.navigate().to("https://www.hepsiburada.com");
        //   6-Title ve url console da yazdirin ve yine title ve url in "burada"
        //   kelimesini icerip icermedigini kontrol edelim
        String actualHepsiBuradaTitle = driver.getTitle();
        String actualHepsiBuradaUrl = driver.getCurrentUrl();
        String expected="burada";
        System.out.println("Title : "+actualHepsiBuradaTitle+"\nUrl : "+actualHepsiBuradaUrl);
        System.out.println(actualHepsiBuradaTitle.contains(expected) ? "Title testi PASS" : "Title testi FAIL");
        System.out.println(actualHepsiBuradaUrl.contains(expected) ? "Url testi PASS" : "Url testi FAIL");
        //   7-Sonrasinda https://github.com/ adresine geri donelim
        //   ve  sayfayi yenileyelim
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().refresh();
        //   8-Son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();
    }
}
