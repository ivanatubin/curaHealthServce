package Tests;

import Pages.AppointmentPage;
import Pages.LoginPage;
import Pages.SummaryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestRequests {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private SummaryPage summaryPage;
    private AppointmentPage appointmentPage;
    private String facilityApp;
    private String readmisBtn;
    private String healthProgram;
    private String date;
    private String comment;


    @BeforeClass
    public void setUp () {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ivana\\Desktop\\Bootcamp\\novChrome\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver,driverWait);
        appointmentPage = new AppointmentPage(driver,driverWait);
        summaryPage =new SummaryPage(driver,driverWait);

        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test(priority = 1)
    public void testLogin () {
        loginPage.moveToLogin();
        loginPage.enterUsername("John Doe");
        loginPage.enterPassword("ThisIsNotAPassword");
        loginPage.clickLogin();
        Assert.assertTrue(appointmentPage.isFormPresented());

    }


    @Test (priority = 2)
    public void setAppForm () {
        appointmentPage.fillAppointmentForm("Hongkong CURA Healthcare Center",true,
                "Medicaid", "21/09/2020", "komentar");

        facilityApp = appointmentPage.getSelectedFacility();
        readmisBtn = appointmentPage.getHospitalReadmissionSelected();
        healthProgram=appointmentPage.getSelectedHelathProgram();
        date=appointmentPage.getDate();
        comment=appointmentPage.getComment();

        appointmentPage.clickBookApp();

        Assert.assertEquals(summaryPage.getFacility(), facilityApp); }

    @Test (priority = 3)
    public void commentAssert () {
        Assert.assertEquals(summaryPage.getComment(),comment);}
    @Test (priority = 4)
    public void dateAssert () {
        Assert.assertEquals(summaryPage.getDate(),date);}
    @Test (priority = 5)
    public void applyHospitalAssert () {
        Assert.assertEquals(summaryPage.isReadmissionChecked(),readmisBtn); }
    @Test (priority = 6)
    public void healthProgramAssert () {
        Assert.assertEquals(summaryPage.getProgram(),healthProgram); }





    @AfterClass
    public void closeDriver () {
        driver.close();
    }
}
