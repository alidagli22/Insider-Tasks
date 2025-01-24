import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;
import util.DriverFactory;




public class Insider {

    careersPage careersPage;
    general general;
    homePage homePage;
    leverFormPage leverFormPage;
    navigationBar navigationBar;
    openPositionsPage openPositionsPage;
    qualityAssurancePage qualityAssurancePage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser) {
        DriverFactory.setDriver(browser);
        WebDriver driver = DriverFactory.getDriver();
        careersPage = new careersPage(driver);
        general = new general(driver);
        homePage = new homePage(driver);
        leverFormPage = new leverFormPage(driver);
        navigationBar = new navigationBar(driver);
        openPositionsPage = new openPositionsPage(driver);
        qualityAssurancePage = new qualityAssurancePage(driver);
    }

    @Test(description = "Insider Task",priority = 0)
    public void InsiderTask() throws InterruptedException {
        homePage.clickAllCookie();
        navigationBar.clickNavItem("Company");
        navigationBar.clickNavDropdownSub("Careers");
        careersPage.checkCareesPage();
        general.goToQualityAssuranceCareerPage();
        qualityAssurancePage.clickSeeAllQAJobs();
        openPositionsPage.selectLocation("Istanbul, Turkey");
        openPositionsPage.selectDepartment("Quality Assurance");
        Thread.sleep(500);
        openPositionsPage.checkJobList();
        Thread.sleep(500);
        openPositionsPage.checkJobsPozition("Quality Assurance");
        openPositionsPage.checkJobsDepartment("Quality Assurance");
        openPositionsPage.checkJobsLocation("Istanbul, Turkey");
        openPositionsPage.clickViewRole();
        leverFormPage.checkLeverFormPageUrl("https://jobs.lever.co/useinsider");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}
