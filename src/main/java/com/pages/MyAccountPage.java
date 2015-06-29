package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.jruby.RubyProcess;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by manisha on 28/06/15.
 */
public class MyAccountPage extends PageObject {
    @FindBy(className = "amount")
    private WebElementFacade accountBalance;

    @FindBy(className = "innerDivAccount")
    private WebElementFacade myOverViewElement;

    @FindBy(id = "logoutLink")
    private WebElementFacade logout;

    public void verify_balance(){
        List<WebElement> links = accountBalance.findElements(By.tagName("a"));
        String accountBalance = links.get(0).getText();

        WebElement we = myOverViewElement.findElements(By.tagName("p")).get(0);
        String myOverviewBalance = we.findElements(By.tagName("span")).get(0).getText();

        assert accountBalance.equals(myOverviewBalance);
    }

    public void log_out(){
        logout.click();
    }
}
