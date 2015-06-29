package com.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.jruby.RubyProcess;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.swing.StringUIClientPropertyKey;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by manisha on 28/06/15.
 */
public class HomePage extends PageObject{
    private static String  APP_URL="http://www.gameduell.com/";

    @FindBy(className = "registerLink")
    private WebElementFacade newHere;

    @FindBy(id = "loginLink")
    private WebElementFacade login;

    @FindBy(name = "j_username")
    private WebElementFacade loginName;

    @FindBy(name = "j_password")
    private WebElementFacade loginPassword;

    @FindBy(name = "commonName")
    private WebElementFacade signupName;

    @FindBy(name = "email")
    private WebElementFacade signupEmail;

    @FindBy(name = "password")
    private WebElementFacade signupPassword;

    @FindBy(id = "registrationButton")
    private WebElementFacade register;

    @FindBy(id = "infobox")
    private WebElementFacade info;

    public void login(String email,String password){
        loginName.clear();
        loginName.sendKeys(email);
        loginPassword.clear();
        loginPassword.sendKeys(password);
        login.click();
    }

    public void go_to_gameduell(){
        getDriver().get(APP_URL);
    }

    public void play_free(){
        newHere.click();
    }

    public void is_on_gameduell(){
        assert info.getText().contains("GameDuell");
    }

    public void signup(String name, String email,String password){
        String timeStamp = new SimpleDateFormat("HHmmssyyyyMMdd").format(new Date());
        signupName.type(name.concat((timeStamp)));
        String registeredEmail = email.substring(0,1).concat(timeStamp).concat("@trashmail.com");
        Serenity.getCurrentSession().put("registeredEmail", registeredEmail);
        signupPassword.type(password);
        signupEmail.type(registeredEmail);
        register.submit();
    }
}
