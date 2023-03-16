package est.systems_si.selenium;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * @author Oussama Essamadi
 *         Selenium demo for systémes SI
 */
public class App {
    static final int CONFIG_TIMEOUT = 300;
    static final String CONFIG_URL = "http://www.tutorialsninja.com/demo";
    static final String CONFIG_EMAIL = "my_email_" + Integer.toString(new Random().nextInt(1000)) + "@gmail.com";
    static final String CONFIG_PASSWORD = "my_password";

    public static void main(String[] args) throws InterruptedException {
        // Config
        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\EOussama\\Documents\\études\\modules\\management des sI\\tps\\selenium\\drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get(CONFIG_URL);
        Thread.sleep(CONFIG_TIMEOUT);

        // Registering
        register(driver);

        // Loging-out
        logout(driver);

        // Loging-in
        login(driver);

        // Shopping
        shop(driver);

        Thread.sleep(10000);
        driver.quit();
    }

    private static void register(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        Thread.sleep(CONFIG_TIMEOUT);

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
        Thread.sleep(CONFIG_TIMEOUT);

        driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("my_first_name");
        Thread.sleep(CONFIG_TIMEOUT);

        driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("my_last_name");
        Thread.sleep(CONFIG_TIMEOUT);

        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(CONFIG_EMAIL);
        Thread.sleep(CONFIG_TIMEOUT);

        driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("0656895632");
        Thread.sleep(CONFIG_TIMEOUT);

        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(CONFIG_PASSWORD);
        Thread.sleep(CONFIG_TIMEOUT);

        driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys(CONFIG_PASSWORD);
        Thread.sleep(CONFIG_TIMEOUT);

        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
        Thread.sleep(CONFIG_TIMEOUT);

        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
        Thread.sleep(CONFIG_TIMEOUT);

        if (driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText()
                .contains("Congratulations! Your new account has been successfully created!")) {
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
            Thread.sleep(CONFIG_TIMEOUT);
        }
    }

    private static void logout(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        Thread.sleep(CONFIG_TIMEOUT);

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
        Thread.sleep(CONFIG_TIMEOUT);

        if (driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText()
                .contains("You have been logged off your account. It is now safe to leave the computer.")) {

            driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
            Thread.sleep(CONFIG_TIMEOUT);
        }
    }

    private static void login(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        Thread.sleep(CONFIG_TIMEOUT);

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
        Thread.sleep(CONFIG_TIMEOUT);

        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(CONFIG_EMAIL);
        Thread.sleep(CONFIG_TIMEOUT);

        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(CONFIG_PASSWORD);
        Thread.sleep(CONFIG_TIMEOUT);

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
        Thread.sleep(CONFIG_TIMEOUT);
    }

    private static void shop(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("mac");
        Thread.sleep(CONFIG_TIMEOUT);
        
        driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
        Thread.sleep(CONFIG_TIMEOUT);
        
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[4]/div/div[2]/div[2]/button[1]")).click();
        Thread.sleep(CONFIG_TIMEOUT);
        
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[5]/a")).click();
        Thread.sleep(CONFIG_TIMEOUT);
        
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();
        Thread.sleep(CONFIG_TIMEOUT);
    }
}
