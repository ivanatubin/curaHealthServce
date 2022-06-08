package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AppointmentPage extends BasePage{
    private By facilitySelect = By.id("combo_facility");
    private By readmissionBtn = By.id("chk_hospotal_readmission");
    private By radioMedicare = By.id("radio_program_medicare");
    private By radioMedicaid = By.id("radio_program_medicaid");
    private By radioNone = By.id("radio_program_none");
    private By visitDate = By.id("txt_visit_date");
    private By comment = By.id("txt_comment");
    private By bookApointementBtn = By.id("btn-book-appointment");


    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public String getAppointmentData() {
        return getSelectedFacility()+ " " +
                getHospitalReadmissionSelected() + " " +
                getSelectedHelathProgram() + " " +
                getDate() + " " +
                getComment();
    }

    public void fillAppointmentForm(String facility, boolean hospitalReadmission, String izborPrograma, String datum, String komentar) {
        chooseFacilitySelect(facility);
        setHospitalReadmission(hospitalReadmission);
        setHealthProgram(izborPrograma);
        setDate(datum);
        setComment(komentar);

    }
    public boolean isFormPresented () {
        List<WebElement> list = getDriver().findElements(By.id("appointment"));

        if (list.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void clickBookApp() {
        getDriver().findElement(bookApointementBtn).click();
    }

    public String getSelectedFacility() {
        return getDriver().findElement(facilitySelect).getAttribute("value");
    }

    public void chooseFacilitySelect (String izbor) {
        Select selectCategory = new Select(getDriver().findElement(facilitySelect));
        selectCategory.selectByVisibleText(izbor);
    }

    public String getHospitalReadmissionSelected() {
        String readmisionYN;
        if (getDriver().findElement(readmissionBtn).isSelected()) {readmisionYN = "Yes";}
        else {readmisionYN="No";}
        return readmisionYN;

    }

    public void setHospitalReadmission(boolean hospital) {
        if (hospital){
            getDriver().findElement(readmissionBtn).click();}

    }

    public String getSelectedHelathProgram() {
        if (getDriver().findElement(radioMedicaid).isSelected()) {
            return "Medicaid";
        } else if (getDriver().findElement(radioMedicare).isSelected()) {
            return "Medicare";
        } else return "None";
    }

    public void setHealthProgram (String izbor) {
        if (izbor.equalsIgnoreCase(getDriver().findElement(radioNone).getAttribute("value"))) {
            selectNone();
        } else if (izbor.equalsIgnoreCase(getDriver().findElement(radioMedicaid).getAttribute("value"))) {
            selectMedicaid();
        } else if (izbor.equalsIgnoreCase(getDriver().findElement(radioMedicare).getAttribute("value"))) {
            selectMedicare();
        }
    }

    public String getDate () {
        return getDriver().findElement(visitDate).getAttribute("value");
    }
    public void setDate (String datum) {
        getDriver().findElement(visitDate).sendKeys(datum);
    }

    public void setComment(String comm) {
        getDriver().findElement(comment).sendKeys(comm);
    }


    public String getComment() {
        return getDriver().findElement(comment).getAttribute("value") ;
    }


    public void selectMedicare () {
        getDriver().findElement(radioMedicare).click();
    }

    public void selectMedicaid () {
        getDriver().findElement(radioMedicaid).click();
    }

    public void selectNone () {
        getDriver().findElement(radioNone).click();
    }

}
