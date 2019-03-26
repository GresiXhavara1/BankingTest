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


import java.util.concurrent.TimeUnit;

public class BankManagerLogin {
    private WebDriver driver;
     
    public BankManagerLogin(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\U173499\\Desktop\\Workspace\\chromedriver.exe");
         driver = new ChromeDriver();
     }

     @Given("^manager is on home page$")
    public void manager_is_on_home_Page(){
        driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");

    }
    @When("^manager clicks login button$")
    public void managerClicksLoginButton() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement  managerLoginButton = driver.findElement(By.xpath("//*[@ng-click=\"manager()\"]"));
        managerLoginButton.click();

    }

    @And("^clicks add customer button$")
    public void clicksAddCustomerButton() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement clicksAddButton = driver.findElement(By.xpath("//*[@ng-class=\"btnClass1\"]"));
        clicksAddButton.click();
    }

    @And("^fill user first name$")
    public void fillUserFirstName() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement fillUsername = driver.findElement(By.xpath("//*[@ng-model=\"fName\"]"));
        fillUsername.sendKeys("mddd");
    }

    @And("^fill user last name$")
    public void fillUserLastName() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement fillUserLastName = driver.findElement(By.xpath("//*[@ng-model=\"lName\"]"));
        fillUserLastName.sendKeys("heiei");
        
    }

    @And("^user postal code$")
    public void userPostalCode() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement postalCode = driver.findElement(By.xpath("//*[@ng-model=\"postCd\"]"));
        postalCode.sendKeys("1000");
        
    }

    @And("^click add customer$")
    public void clickAddCustomer() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement addCustomerButton = driver.findElement(By.className("btn-default"));
        addCustomerButton.click();
        
    }

    @Then("^click ok button on popup alert$")
    public void clickOkButtonOnPopupAlert() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    @Then("^the customer is added$")
    public void theCustomerIsAdded() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        System.out.println("Custer is added");
    }

    @And("^clicks on customers button to see the list of customers$")
    public void clicksOnCustomersButtonToSeeTheListOfCustomers() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement clickCustomersButton = driver.findElement(By.xpath("//*[@ng-click=\"showCust()\"]"));
        clickCustomersButton.click();
    }



    @When("manager is on customers page")
    public void managerIsOnCustomersPage() {
       this.manager_is_on_home_Page();
       this.managerClicksLoginButton();
       this.clicksAddCustomerButton();
       this.fillUserFirstName();
       this.fillUserLastName();
       this.userPostalCode();
       this.clickAddCustomer();
       this.clickOkButtonOnPopupAlert();
       this.theCustomerIsAdded();
       this.clicksOnCustomersButtonToSeeTheListOfCustomers();

    }

    @When("manager find for a customer")
    public void managerFindForACustomer() {
        WebElement customersSearch = driver.findElement(By.xpath("//*[@placeholder=\"Search Customer\"]"));
        customersSearch.sendKeys("h");
    }

    @And("he clicks delete button")
    public void heClicksDeleteButton() throws InterruptedException {
        Thread.sleep(5000);
            WebElement deleteButton = driver.findElement(By.xpath("//tbody/tr/td[5]/button[@ng-click=\"deleteCust(cust)\"]"));
            deleteButton.click();
            WebElement delete1Button = driver.findElement(By.xpath("//tbody/tr[1]/td[5]/button[@ng-click=\"deleteCust(cust)\"]"));
            delete1Button.click();


    }


    @Then("the customer is deleted")
    public void theCustomerIsDeleted() {
        System.out.println("The customer is deleted");
    }
}
