package est.systems_si.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Selenium demo for systémes SI
 */
public class App 
{
    public static void main( String[] args )
    {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Create a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to Google
        driver.get("https://www.google.com/");

        // Print the page title
        System.out.println("Page title: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
