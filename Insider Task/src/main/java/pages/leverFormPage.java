package pages;

import org.openqa.selenium.WebDriver;
import util.ElementHelper;

public class leverFormPage {

    ElementHelper elementHelper;

    public leverFormPage(WebDriver driver) {
        elementHelper = new ElementHelper(driver);
    }

    public void checkLeverFormPageUrl(String url){
        elementHelper.switchWindows();
        elementHelper.checkUrlContains(url);
    }

}
