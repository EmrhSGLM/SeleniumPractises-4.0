package questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q01 {

    //  Question1
    //  1.) https://www.youtube.com sayfasına gidin
    //  2.) Title i consolda yazdirin
    //  3.) Title “YouTube” a eşitse “correct title” yazdirin değilse “incorrect title yzdirin”
    //  4.) Sayfayi kapatin
    //  5.) Tum sayfalari kapatin
    //  6.) Consola “Test completed” yazdirin

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //  1.) https://www.youtube.com sayfasına gidin
        driver.get("https://www.youtube.com");
        //  2.) Title i consolda yazdirin
        System.out.println("Title => " + driver.getTitle());
        //  3.)Title “YouTube” a eşitse “correct title” yazdirin değilse “incorrect title yazdirin”
        String actualTitle=driver.getTitle();
        String expectedTitle="YouTube";
        System.out.println(actualTitle.contains(expectedTitle) ? "correct title" : "incorrect title");
        //  4.Sayfayi kapatin
        driver.close();
        //  5.Tum sayfalari kapatin
        driver.quit();
        //  6.Consola “Test completed” yazdirin
        System.out.println("Test completed");
    }
}
