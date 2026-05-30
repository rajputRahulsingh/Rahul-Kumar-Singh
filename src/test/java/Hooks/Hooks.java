package Hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {

        // Create browser object
        driver = new ChromeDriver();

        // Maximize browser
        driver.manage().window().maximize();

        // Open application
        driver.get("https://demo.opencart.com/");
    }

    @After
    public void closestmt() {

        // Close browser
        driver.quit();
    }
}