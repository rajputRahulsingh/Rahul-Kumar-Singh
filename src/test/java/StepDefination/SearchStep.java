package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStep {

    WebDriver driver;

    @Given("Home page of Ebooks is opened")
    public void home_page_of_ebooks_is_opened() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.ebooks.com/en-in/");
    }

    @When("click on search box and enter item")
    public void click_on_search_box_and_enter_item() {

        WebElement searchBox = driver.findElement(By.id("term"));

        searchBox.sendKeys("Neverfinsished");
    }

    @And("click on Enter")
    public void click_on_enter() throws InterruptedException {

        driver.findElement(By.id("search-submit")).click();
        Thread.sleep(3000);
              
    }

    @Then("item searched successfully")
    public void item_searched_successfully() {

       
        driver.quit();
    }
}