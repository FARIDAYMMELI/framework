package scaledupit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import team2.SetUp;

public class LoginTest extends SetUp {
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void validCredential() {
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

        //check user is logged in
        String expectedHomePageHeader = "Logout";
        String actualHomePageHeader = getElementText("//a[text()='Logout']");
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");
    }

    @Test
    public void invalidUsername(){

        // navigate to scaledupit website

        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // click on login/register button
        clickOn("#menu-item-324 > a");
        log.info("click on to login/register button success");

        //enter  username, password, and click on login button


        type("#username","fari");
        log.info("enter username success");
        type("#password","hhhhh");
        log.info("enter password success");

        clickOn("#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > button");
        log.info("click on login button Success");

        //validate the error message
        String expectedError = "Error: The username fari is not registered on this site. If you are unsure of your username, try your email address instead.";
        String actualError = getElementText("#post-9 > div > div > div.woocommerce-notices-wrapper > ul > li");
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");
    }

    @Test
    public void missingUsername(){


        // navigate to scaledupit website
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // click on login/register button
        clickOn("#menu-item-324 > a");
        log.info("click on to login/register button success");

        //enter password, and click on login button


        type("#username","");
        log.info("enter username success");
        type("#password","Password14@");
        log.info("enter password success");

        clickOn("#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > button");
        log.info("click on login button Success");

        //validate the error message
        String expectedError = "Error: Username is required.";
        String actualError = getElementText("#post-9 > div > div > div.woocommerce-notices-wrapper > ul > li");
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success, username is required");

    }
    @Test
    public void missingPassword(){

        // navigate to scaledupit website
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // click on login/register button
        clickOn("#menu-item-324 > a");
        log.info("click on to login/register button success");

        //enter  username, and click on login button


        type("#username","faridaymmeli@gmail.com");
        log.info("enter username success");
        type("#password","");
        log.info("enter password success");

        clickOn("#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > button");
        log.info("click on login button Success");

        //validate the error message
        String expectedError = "Error: The password field is empty.";
        String actualError = getElementText("#post-9 > div > div > div.woocommerce-notices-wrapper > ul > li");
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success, password is required");
    }
}
