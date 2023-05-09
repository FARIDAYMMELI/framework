package scaledupit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import team2.SetUp;

public class LogoutTest extends SetUp {
    Logger log = LogManager.getLogger(LogoutTest.class.getName());

    @Test
    public void logout() throws InterruptedException {
        // navigate to scaledupit website
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // click on login/Register button
        clickOn("#menu-item-324 > a");
        log.info("click on login/ register button");
        //enter  email, password, and click on login button
        type("#username","faridaymmeli@gmail.com");
        log.info("enter email success");
        type("#password","Password14@");
        log.info("enter password success");
        clickOn("#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > button");
        log.info("click on login button Success");
        Thread.sleep(1000);

        //check user is landed to the login page

        String expectedLoginPageHeaderText = "Account details";
        String actualLoginPageHeaderText = getElementText("//a[text()=\"Account details\"]");
        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
        log.info("login page header text validation success");

        //check user is have logout button
        String expectedHomePageHeader = "Logout";
        String actualHomePageHeader = getElementText("//a[text()='Logout']");
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");


        clickOn("//a[text()='Logout']");
        log.info("click on logout  Success");

     // verify that logout process is working and are in home page egain

        String expectedText = "LOGIN/REGISTER";
        String actualText = getElementText("#menu-item-324 > a");
        Assert.assertEquals(expectedText, actualText);


    }

}

