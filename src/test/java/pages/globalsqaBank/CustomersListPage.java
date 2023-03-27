package pages.globalsqaBank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomersListPage {
    WebDriver driver;

    public CustomersListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()=\"Customers\"]")
    WebElement customersButton;

    @FindBy(xpath = "//input[@type=\"text\"]")
    WebElement searchField;

    @FindBy(xpath = "//tr[@class=\"ng-scope\"]")
    WebElement searchResult;

    public void clickToCustomersButton() throws InterruptedException {
        Thread.sleep(200);
        customersButton.click();
    }

    public void getCustomerSearch(String firstName) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys(firstName);
    }

    public String getCustomerSearchData() {
        return searchResult.getText();
    }
}
