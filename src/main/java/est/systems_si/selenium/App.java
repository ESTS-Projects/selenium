package est.systems_si.selenium;

import org.openqa.selenium.WebDriver;


public class App {
    public static void main(String[] args) throws InterruptedException {
        WebDriver page = Helper.getDriver();
        
        page.get(Config.Url);
        automateRegister(page);
        automateLogout(page);
        automateLogin(page);
        automateShoping(page);
        Thread.sleep(Config.pause);

        page.quit();
    }

    private static void automateRegister(WebDriver page) throws InterruptedException {
        Helper.click(page, "//*[@id=\"top-links\"]/ul/li[2]/a");
        Helper.click(page, "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");
        Helper.type(page, "//*[@id=\"input-firstname\"]", Config.firstName);
        Helper.type(page, "//*[@id=\"input-lastname\"]", Config.lastName);
        Helper.type(page, "//*[@id=\"input-email\"]", Config.email);
        Helper.type(page, "//*[@id=\"input-telephone\"]", Config.phoneNumber);
        Helper.type(page, "//*[@id=\"input-password\"]", Config.password);
        Helper.type(page, "//*[@id=\"input-confirm\"]", Config.password);
        Helper.click(page, "//*[@id=\"content\"]/form/div/div/input[1]");
        Helper.click(page, "//*[@id=\"content\"]/form/div/div/input[2]");
        Helper.click(page, "//*[@id=\"content\"]/div/div/a");
    }

    private static void automateLogout(WebDriver page) throws InterruptedException {
        Helper.click(page, "//*[@id=\"top-links\"]/ul/li[2]/a");
        Helper.click(page, "//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a");
        Helper.click(page, "//*[@id=\"content\"]/div/div/a");
    }

    private static void automateLogin(WebDriver page) throws InterruptedException {
        Helper.click(page, "//*[@id=\"top-links\"]/ul/li[2]/a");
        Helper.click(page, "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
        Helper.type(page, "//*[@id=\"input-email\"]", Config.email);
        Helper.type(page, "//*[@id=\"input-password\"]", Config.password);
        Helper.click(page, "//*[@id=\"content\"]/div/div[2]/div/form/input");
    }

    private static void automateShoping(WebDriver page) throws InterruptedException {
        Helper.type(page, "//*[@id=\"search\"]/input", "phone");
        Helper.click(page, "//*[@id=\"search\"]/span/button");
        Helper.click(page, "//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]");
        page.get("http://tutorialsninja.com/demo/index.php?route=checkout/cart");
        Helper.click(page, "//*[@id=\"content\"]/div[3]/div[2]/a");
    }
}
