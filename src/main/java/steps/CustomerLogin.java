package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CustomerLogin {
    private WebDriver driver;

    public CustomerLogin() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\U173499\\Desktop\\Workspace\\chromedriver.exe");
        driver = new ChromeDriver();

    }


    @Given("^customer is on home page$")
    public void customer_is_on_home_page() {
        driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");

    }

    @When("^customer clicks customer login button$")
    public void customerClicksCustomerLoginButton() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement customerLoginButton = driver.findElement(By.xpath("//*[@ng-click=\"customer()\"]"));
        customerLoginButton.click();


    }

    @And("^customer choose his name on name list$")
    public void customerChooseHisNameOnNameList() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select nameChoose = new Select(driver.findElement(By.name("userSelect")));
        nameChoose.selectByVisibleText("Hermoine Granger");
    }

    @And("^clicks button login$")
    public void clicksButtonLogin() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@ng-show=\"custId != ''\"]"));
        loginButton.click();

    }

    @Then("^he see his data$")
    public void heSeeHisData() {
    }

    //Step2
    @When("^customer logs in$")
    public void customerLogsIn() {
        this.customer_is_on_home_page();
        this.customerClicksCustomerLoginButton();
        this.customerChooseHisNameOnNameList();
        this.clicksButtonLogin();

    }

    @When("^customer clicks transactions button$")
    public void customerClicksTransactionsButton() {
        WebElement transactionButton = driver.findElement(By.xpath("//*[@ng-click=\"transactions()\"]"));
        transactionButton.click();

    }

    @And("^choose a different date$")
    public void chooseADifferentDate() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement dateBox = driver.findElement(By.xpath("//*[@id=\"start\"]"));
        dateBox.sendKeys("2015/01/01T00:00:00");

    }

    @Then("^he see his transactions by date$")
    public void heSeeHisTransactionsByDate() {
    }

    //Step 3
    @When("^customer logs in and goes to transaction page$")
    public void customerLogsInAndGoesToTransactionPage() {
        this.customerLogsIn();
        this.customerClicksTransactionsButton();
        this.chooseADifferentDate();
    }


    @And("^clicks reset button$")
    public void clicksResetButton() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement resetButton = driver.findElement(By.xpath("//*[@ng-click=\"reset()\"]"));
        resetButton.click();


    }

    @Then("^all transactions are deleted$")
    public void allTransactionsAreDeleted() {
    }
    //Step 3


    @When("^customer logs in and goes to transaction page and click reset$")
    public void customerLogsInAndGoesToTransactionPageAndClickReset() {
        this.customerLogsInAndGoesToTransactionPage();
        this.clicksResetButton();

    }

    @And("^customer goes back$")
    public void customerGoesBack() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement backButton = driver.findElement(By.xpath("//*[@ng-click=\"back()\"]"));
        backButton.click();
    }

    @And("^clicks deposit button$")
    public void clicksDepositButton() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement amountButton = driver.findElement(By.xpath("//*[@ng-click=\"deposit()\"]"));
        amountButton.click();

    }

    @And("^enter amount of money$")
    public void enterAmountOfMoney() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement amount = driver.findElement(By.xpath("//*[@ng-model=\"amount\"]"));
        amount.sendKeys("222222");
    }

    @And("^clicks deposit$")
    public void clicksDeposit() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement depositMoney = driver.findElement(By.cssSelector(".btn-default"));
        depositMoney.click();


    }

    @And("^he clicks transactions button$")
    public void heClicksTransactionsButton() {
        WebElement transButton = driver.findElement(By.xpath("//*[@ng-click=\"transactions()\"]"));
        transButton.click();
    }

   @Then("he see his last deposit")
   public void heSeeHisLastDeposit() {
   }
}
