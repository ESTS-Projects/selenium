package est.systems_si.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class App {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", Config.driver);
        WebDriver page = new EdgeDriver();
        
        page.get(Config.Url);
        automateRegister(page);
        automateLogout(page);
        automateLogin(page);
        automateShoping(page);
        Thread.sleep(Config.pause);

        // page.quit();
    }

    private static void automateRegister(WebDriver page) throws InterruptedException {
        click(page, "//*[@id=\"top-links\"]/ul/li[2]/a");
        click(page, "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");
        type(page, "//*[@id=\"input-firstname\"]", Config.firstName);
        type(page, "//*[@id=\"input-lastname\"]", Config.lastName);
        type(page, "//*[@id=\"input-email\"]", Config.email);
        type(page, "//*[@id=\"input-telephone\"]", Config.phoneNumber);
        type(page, "//*[@id=\"input-password\"]", Config.password);
        type(page, "//*[@id=\"input-confirm\"]", Config.password);
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
        type(page, "//*[@id=\"input-email\"]", Config.email);
        type(page, "//*[@id=\"input-password\"]", Config.password);
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
        Thread.sleep(Config.timeout);
    }

    private static void type(WebDriver page, String xpath, String content) throws InterruptedException {
        page.findElement(By.xpath(xpath)).sendKeys(content);
        Thread.sleep(Config.timeout);
    }
}
