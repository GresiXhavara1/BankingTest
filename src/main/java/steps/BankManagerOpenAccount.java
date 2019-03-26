package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class BankManagerOpenAccount {
    private WebDriver driver;

    public BankManagerOpenAccount(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\U173499\\Desktop\\Workspace\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("^bank manager is on home page$")
    public void bank_manager_is_on_home_page(){
        driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
    }

    @When("^bank manager clicks login button$")
    public void bankManagerClicksLoginButton() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement bankManagerLogin = driver.findElement(By.xpath("//*[@ng-click=\"manager()\"]"));
        bankManagerLogin.click();

    }

    @And("^choose open account button for customer$")
    public void chooseOpenAccountButtonForCustomer() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement accountButton = driver.findElement(By.xpath("//*[@ng-click=\"openAccount()\"]"));
        accountButton.click();

    }

    @Then("^choose a customer from customer dropdownlist$")
    public void chooseACustomerFromCustomerDropdownlist() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select customerDropdown = new Select(driver.findElement(By.id("userSelect")));
        customerDropdown.selectByVisibleText("Hermoine Granger");
    }


    @And("choose the currency")
    public void chooseTheCurrency() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select currencyCustomer = new Select(driver.findElement(By.id("currency")));
        currencyCustomer.selectByVisibleText("Dollar");
    }

    @And("clicks process button")
    public void clicksProcessButton() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement processButton = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        processButton.click();
    }

    @Then("clicks ok button from a pop up alert")
    public void clicksOkButtonFromAPopUpAlert() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Alert okButton = driver.switchTo().alert();
        okButton.accept();

    }

    @Then("customers is opened an account")
    public void customersIsOpenedAnAccount() {
        System.out.println("Customer is opened an account");
    }
}
