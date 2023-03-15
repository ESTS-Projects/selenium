package est.systems_si.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * @author Oussama Essamadi
 * Selenium demo for systémes SI
 */
public class App 
{
    public static void main( String[] args )
    {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\EOussama\\Documents\\études\\modules\\management des sI\\tps\\selenium\\drivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.google.com/");
        System.out.println("Page title: " + driver.getTitle());

        driver.quit();
    }
}
