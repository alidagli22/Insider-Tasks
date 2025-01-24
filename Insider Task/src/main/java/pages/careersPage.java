package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.ElementHelper;

public class careersPage {
    ElementHelper elementHelper;
    By area_Teams = By.id("career-find-our-calling");
    By area_Locations = By.id("career-our-location");
    By area_LifeAtInsider = By.cssSelector(".elementor-widget-wrap.elementor-element-populated.e-swiper-container");

    public careersPage(WebDriver driver) {
        elementHelper = new ElementHelper(driver);
    }

    public void checkCareesPage(){
        checkTeamsArea();
        checkLocationsArea();
        checkLifeAtInsiderArea();
    }

    public void checkTeamsArea(){
        Assert.assertTrue(elementHelper.findElement(area_Teams).isDisplayed(),"Teams Area is not displayed!");
    }

    public void checkLocationsArea(){
        Assert.assertTrue(elementHelper.findElement(area_Locations).isDisplayed(),"Locations Area is not displayed!");
    }

    public void checkLifeAtInsiderArea(){
        Assert.assertTrue(elementHelper.findElement(area_LifeAtInsider).isDisplayed(),"Life at Inseder Area is not displayed!");
    }



}
