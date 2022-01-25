package practiseLesson_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Scanner;

public class Q04 {

    // ...Exercise5...
// Navigate to  https://testpages.herokuapp.com/styled/index.html
// Click on  Calculate under Micro Apps
//    Type any number in the first input
//    Type any number in the second input
// Click on Calculate
// Get the result
// Print the result
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Sayi 1'i giriniz : ");
        String sayi1=scan.next();
        System.out.print("Sayi 2'i giriniz : ");
        String sayi2=scan.next();
        System.out.println("Dort islem seciniz " +
                "\n1-)Toplama " +
                "\n2-)Carpma " +
                "\n3-)Cikarma " +
                "\n4-)Bolme" +
                "\nTercihiniz yapiniz");
        int secim=scan.nextInt();;
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.id("calculatetest")).click();
        WebElement first= driver.findElement(By.id("number1"));
        WebElement second= driver.findElement(By.id("number2"));
        first.sendKeys(sayi1);
        second.sendKeys(sayi2);
        driver.findElement(By.xpath("(//option)["+secim+"]")).click();
        driver.findElement(By.id("calculate")).click();
        String result =driver.findElement(By.xpath("//span[@id='answer']")).getText();
        System.out.println("result = " + result);
        driver.close();
    }
}
