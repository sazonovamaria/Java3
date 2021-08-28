package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DnevnikiAuthorization {
    private static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        logIn();
        // не знаю, как обойти капчу
    }

    public static void logIn(){
        driver.get("https://diary.ru/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Maria1908");
        driver.findElement(By.id("prependedInput2")).sendKeys("dnevniki_1234");
        driver.findElement(By.xpath("//button")).click();
    }
    }

