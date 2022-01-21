package Ders_Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q07 {

    //1.https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    //2. Add Element butonuna basin
    //3. Delete butonu’nun gorunur oldugunu test edin
    //4. Delete tusuna basin
    //5. Add/Remove Elements ” yazisinin gorunur oldugunu test edin

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.https://the internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2. Add Element butonuna basin
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        //3. Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton =  driver.findElement(By.xpath("//button[text()='Delete']"));
        System.out.println(deleteButton.isDisplayed() ? "Delete Button test PASSED" : "Delete Button test FAILED");
        //4. Delete tusuna basin
        deleteButton.click();
        //5. Add/Remove Elements ” yazisinin gorunur oldugunu test edin
        WebElement addRemoteElement =  driver.findElement(By.xpath("//h3[text()='Add/Remove Elements']"));
        System.out.println(addRemoteElement.isDisplayed() ? "Add Remote Element tesing PASSED" : "Add Remote Element tesing FAILED");
        driver.close();
    }
}
