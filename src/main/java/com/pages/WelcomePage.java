package com.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

/**
 * Created by manisha on 28/06/15.
 */
public class WelcomePage extends PageObject {
    @FindBy(id = "validateMailForm")
    private WebElementFacade welcomePageContent;

    @FindBy(id = "centerContent")
    private WebElementFacade MyGameDuellPageContent;

    @FindBy(id = "topNaviMygdLink")
    private WebElementFacade myGdLink;

    public void assert_page(String page){
        if(page.equals("Welcome")){
            assert welcomePageContent.getText().contains("Welcome");
        }

        if(page.equals("My GameDuell")){
            assert MyGameDuellPageContent.getText().contains("My GameDuell overview");
        }
    }

    public void navigate(String page){
        if(page.equals("My GameDuell")){
            myGdLink.click();
            waitForRenderedElementsToBePresent(By.id("centerContent"));
        }
    }

    public void assert_email_validation(){
        assert getDriver().getCurrentUrl().contains("/gd/emailManagement/emailValidation.xhtml");
    }
}
