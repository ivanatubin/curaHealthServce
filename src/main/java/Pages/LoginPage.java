package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private By userName = By.id("txt-username");
    private By password = By.id("txt-password");
    private By loginButton = By.id("btn-login");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void enterUsername (String username) {
        getDriver().findElement(userName).sendKeys(username);
    }

    public void enterPassword (String pass) {
        getDriver().findElement(password).sendKeys(pass);
    }

    public void clickLogin () {
        getDriver().findElement(loginButton).click();
    }
}

