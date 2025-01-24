package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementHelper;

public class homePage  {
    ElementHelper elementHelper;

    By btn_acceptAll = By.id("wt-cli-accept-all-btn");

    public homePage(WebDriver driver) {
        elementHelper = new ElementHelper(driver);
    }

    public void clickAllCookie(){
        elementHelper.click(btn_acceptAll);
    }
}
