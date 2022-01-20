package myWorking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {

    // https://www.youtube.com sayfasina gidin
    // Search kismina "Neşet ERTAŞ İki Büyük Nimetim var" yazdir
    // Aranmasini istedigin text'i yazdirdiktan sonra click/submit yaparak arat
    // Ilk cikan arama sonucuna click yap
    // Sarkiyi ac

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.youtube.com sayfasina gidin
        driver.get("https://www.youtube.com");

        // Search kismina "Neşet ERTAŞ İki Büyük Nimetim var" yazdir
        WebElement searchBox=  driver.findElement(By.xpath("//input[@name='search_query']"));
        searchBox.sendKeys("Neşet ERTAŞ İki Büyük Nimetim var");

       // Aranmasini istedigin text'i yazdirdiktan sonra click/submit yaparak arat
       searchBox.submit();

        // Ilk cikan arama sonucuna click yap
        WebElement picture = driver.findElement(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer'][1]"));
        picture.click();

        // Sayfayi kapat
        driver.close();
    }
}
