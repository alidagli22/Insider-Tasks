package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementHelper;

public class navigationBar  {
    ElementHelper elementHelper;

    By btn_NavItems = By.id("navbarDropdownMenuLink");
    By btn_DropdownSubs = By.cssSelector(".show .dropdown-sub");

    public navigationBar(WebDriver driver) {
        elementHelper = new ElementHelper(driver);
    }

    public void clickNavItem(String navItem){
        elementHelper.clickWithText(btn_NavItems,navItem);
    }

    public  void clickNavDropdownSub(String dropdownSub){
        elementHelper.clickWithText(btn_DropdownSubs,dropdownSub);
    }

}
