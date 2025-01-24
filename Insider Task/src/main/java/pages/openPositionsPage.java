package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.ElementHelper;

public class openPositionsPage  {
    ElementHelper elementHelper;

    By drp_Department = By.id("filter-by-department");
    By drp_Location = By.id("filter-by-location");
    By list_Job = By.id("career-position-list");
    By list_Pozitions = By.cssSelector("#jobs-list > div:nth-child(3) > div");
    By list_Department = By.cssSelector(".position-department.text-large.font-weight-600.text-primary");
    By list_Locations = By.cssSelector(".position-location.text-large");
    By list_ViewRole = By.cssSelector(".btn.btn-navy.rounded.pt-2.pr-5.pb-2.pl-5");

    public openPositionsPage(WebDriver driver) {
        elementHelper = new ElementHelper(driver);
    }


    public  void selectLocation(String location){
        elementHelper.select(drp_Location,location);
    }

    public void selectDepartment(String department){
        elementHelper.select(drp_Department,department);

    }

    public void checkJobList(){
        Assert.assertTrue(elementHelper.findElement(list_Job).isDisplayed(),"Job List is not displayed!");
    }

    public void checkJobsPozition(String pozition){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        elementHelper.checkAllElementsText(list_Pozitions,pozition);
    }

    public void checkJobsLocation(String location){
        elementHelper.checkAllElementsText(list_Locations,location);
    }

    public void checkJobsDepartment(String department){
        elementHelper.checkAllElementsText(list_Department,department);
    }

    public void clickViewRole(){
        elementHelper.click(list_ViewRole);
    }
}
