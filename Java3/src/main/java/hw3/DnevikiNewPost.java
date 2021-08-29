package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DnevikiNewPost {
    private static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        logIn();
        // без капчи дальше не пройти, поэтому не могу проверить, работает ли код
        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Новая запись']"));
        driver.findElement(By.xpath("//a/span[text()='Новая запись']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("BlogsPosts[title]")));
        driver.findElement(By.name("BlogsPosts[title]")).sendKeys("Заголовок");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'massage_ifr')]")));
        driver.findElement(By.xpath("//body")).sendKeys("test");
        driver.findElement(By.xpath("//button[contains(text(),'Опубликовать')]")).click();
    }
    public static void logIn(){
        driver.get("https://diary.ru/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Maria1908");
        driver.findElement(By.id("prependedInput2")).sendKeys("dnevniki_1234");
        driver.findElement(By.xpath("//button")).click();
    }
}
