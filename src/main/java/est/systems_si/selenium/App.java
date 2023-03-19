package est.systems_si.selenium;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class App {
    static final int CONFIG_TIMEOUT = 300;
    static final String CONFIG_URL = "http://www.tutorialsninja.com/demo";
    static final String CONFIG_DRIVER = "C:\\Users\\EOussama\\Documents\\études\\modules\\management des sI\\tps\\selenium\\drivers\\msedgedriver.exe";
    static final String CONFIG_EMAIL = "my_email_" + Integer.toString(new Random().nextInt(1000)) + "@gmail.com";
    static final String CONFIG_PASSWORD = "my_password";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", CONFIG_DRIVER);
        WebDriver page = new EdgeDriver();
        
        page.get(CONFIG_URL);
        automateRegister(page);
        automateLogout(page);
        automateLogin(page);
        automateShoping(page);

        Thread.sleep(10000);
        page.quit();
    }

    private static void automateRegister(WebDriver page) throws InterruptedException {
        click(page, "//*[@id=\"top-links\"]/ul/li[2]/a");
        click(page, "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");
        type(page, "//*[@id=\"input-firstname\"]", "my_first_name");
        type(page, "//*[@id=\"input-lastname\"]", "my_last_name");
        type(page, "//*[@id=\"input-email\"]", CONFIG_EMAIL);
        type(page, "//*[@id=\"input-telephone\"]", "0656895632");
        type(page, "//*[@id=\"input-password\"]", CONFIG_PASSWORD);
        type(page, "//*[@id=\"input-confirm\"]", CONFIG_PASSWORD);
        click(page, "//*[@id=\"content\"]/form/div/div/input[1]");
        click(page, "//*[@id=\"content\"]/form/div/div/input[2]");
        click(page, "//*[@id=\"content\"]/div/div/a");
    }

    private static void automateLogout(WebDriver page) throws InterruptedException {
        click(page, "//*[@id=\"top-links\"]/ul/li[2]/a");
        click(page, "//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a");
        click(page, "//*[@id=\"content\"]/div/div/a");
    }

    private static void automateLogin(WebDriver page) throws InterruptedException {
        click(page, "//*[@id=\"top-links\"]/ul/li[2]/a");
        click(page, "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
        type(page, "//*[@id=\"input-email\"]", CONFIG_EMAIL);
        type(page, "//*[@id=\"input-password\"]", CONFIG_PASSWORD);
        click(page, "//*[@id=\"content\"]/div/div[2]/div/form/input");
    }

    private static void automateShoping(WebDriver page) throws InterruptedException {
        type(page, "//*[@id=\"search\"]/input", "mac");
        click(page, "//*[@id=\"search\"]/span/button");
        click(page, "//*[@id=\"content\"]/div[3]/div[4]/div/div[2]/div[2]/button[1]");
        page.get("http://tutorialsninja.com/demo/index.php?route=checkout/cart");
        click(page, "//*[@id=\"content\"]/div[3]/div[2]/a");
    }

    private static void click(WebDriver page, String xpath) throws InterruptedException {
        page.findElement(By.xpath(xpath)).click();
        Thread.sleep(CONFIG_TIMEOUT);
    }

    private static void type(WebDriver page, String xpath, String content) throws InterruptedException {
        page.findElement(By.xpath(xpath)).sendKeys(content);
        Thread.sleep(CONFIG_TIMEOUT);
    }
}
