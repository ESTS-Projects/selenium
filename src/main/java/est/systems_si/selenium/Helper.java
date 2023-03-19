package est.systems_si.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Helper {
    public static void click(WebDriver page, String xpath) throws InterruptedException {
        page.findElement(By.xpath(xpath)).click();
        Thread.sleep(Config.timeout);
    }

    public static void type(WebDriver page, String xpath, String content) throws InterruptedException {
        page.findElement(By.xpath(xpath)).sendKeys(content);
        Thread.sleep(Config.timeout);
    }

    public static WebDriver getDriver() {
        System.setProperty("webdriver." + Config.driverType + ".driver", Config.driverPath);

        if (Config.driverType == "edge") {
            return new EdgeDriver();
        } else {
            return new ChromeDriver();
        }
    }
}
