package gruop_Working;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- Amazon sitesine gidelim
        driver.get("https://www.amazon.com");
        // 2- Nutella Aratalim
        WebElement box = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement clk = driver.findElement(By.id("nav-search-submit-button"));
        // 3- Nutella: Die 30 besten Rezepte
        box.sendKeys("Nutella");
        box.submit(); // Enter'a basar
        // clk.click(); // Tik
        Thread.sleep(3000);
        driver.close();
    }

}
