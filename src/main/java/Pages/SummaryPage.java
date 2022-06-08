package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage{
    private By facility = By.id("facility");
    private By readmission = By.id("hospital_readmission");
    private By program = By.id("program");
    private By visitDate = By.id("visit_date");
    private By commentar = By.xpath("//*[@id=\"comment\"]");



    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public String getAllFromSummary () {
        return getFacility() + " " +
                isReadmissionChecked() + " " +
                getProgram() + " " +
                getDate() + " " +
                getComment();
    }

    public String getFacility () {
        return getDriver().findElement(facility).getText();

    }
    public String isReadmissionChecked () {
        return getDriver().findElement(readmission).getText();
    }
    public String getProgram() {
        return getDriver().findElement(program).getText();
    }
    public String getDate () {
        return getDriver().findElement(visitDate).getText();
    }
    public String getComment () {
        return getDriver().findElement(commentar).getText();
    }
}
