package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStep {

    WebDriver driver;
    WebDriverWait wait;

    @Given("Home page of Ebooks is opened click on signup button")
    public void home_page_of_ebooks_is_opened_click_on_signup_button() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        wait =new WebDriverWait(driver,Duration.ofSeconds(15));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.ebooks.com/en-in/");

        WebElement sc=wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
    }

    @When("click on Create an Account")
    public void click_on_create_an_account() {

        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
    }

    @And("Enter on Email address")
    public void enter_on_email_address() {

        driver.findElement(By.xpath("//input[@id='Email']"))
              .sendKeys("taxeni6289@nriza.com");
    }

    @And("Enter password")
    public void enter_password() {

        driver.findElement(By.xpath("(//input[@id='Password'])[1]"))
              .sendKeys("Rahul@123");
    }

    @And("Re-enter your password")
    public void re_enter_your_password() {

        driver.findElement(By.xpath("//input[@id='ConfirmPassword']"))
              .sendKeys("Rahul@123");
    }

    @And("check on terms and conditions")
    public void check_on_terms_and_conditions() {

        driver.findElement(By.xpath("//input[@id='AgreeToTermsOfService']"))
              .click();
    }

    @Then("click on Register")
    public void click_on_register() {

        driver.findElement(By.xpath("//button[@id='register-button']"))
              .click();

        System.out.println("Registration Successful");

        driver.quit();
    }
}