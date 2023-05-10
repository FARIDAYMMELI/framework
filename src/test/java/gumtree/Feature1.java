package gumtree;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import team2.SetUp;


public class Feature1 extends SetUp {
    Logger log = LogManager.getLogger(Feature1.class.getName());

    @Test
    public void validCredential() {
        String expectedTitle = "Gumtree | Free classified ads from the #1 classifieds site in the UK";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        clickOn("//span[@class='icon icon--person css-0 eom5h670']");
        type("#email", "Tamannabegum70294@gmail.com");
        log.info("enter username success");
        type("input[type='password']", "Apples123!");
        log.info("enter password success");
        clickOn(".btn-primary.btn-full-width");
        log.info("click on login button Success");

        //check user is logged in
        String expectedHomePageHeader = "Gumtree";
        String actualHomePageHeader = getElementText(".logo-text.gumtree-text-svg.hide-fully-to-s");
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");
    }

    @Test
    public void invalidUsername() {
        clickOn(".button.button--dark.button--bottom-label.css-hw87r6.e137x0or0");
        String expectedTitle = "Gumtree | Free classified ads from the #1 classifieds site in the UK";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        type("#email", "invalid_username");
        log.info("enter username success");
        type("input[type='password']", "Apples123!");
        log.info("enter password success");
        clickOn(".btn-primary.btn-full-width");
        log.info("click on login button Success");

        //validate the error message
        String expectedError = "Please enter a valid email address.";
        String actualError = getElementText(".error-messages");
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");
    }

    @Test
    public void missingUsername() {
        clickOn(".button.button--dark.button--bottom-label.css-hw87r6.e137x0or0");
        String expectedTitle = "Gumtree | Free classified ads from the #1 classifieds site in the UK";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        type("#email", "");
        log.info("enter username success");
        type("input[type='password']", "Apples123!");
        log.info("enter password success");
        clickOn(".btn-primary.btn-full-width");
        log.info("click on login button Success");

        //validate the error message
        String expectedError = "Please enter a valid email address.";
        String actualError = getElementText(".error-messages");
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");
    }

    @Test
    public void missingPassword() {
        clickOn(".button.button--dark.button--bottom-label.css-hw87r6.e137x0or0");
        String expectedTitle = "Gumtree | Free classified ads from the #1 classifieds site in the UK";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        type("#email", "Tamannabegum70294@gmail.com");
        log.info("enter username success");
        type("input[type='password']", "");
        log.info("enter password success");
        clickOn(".btn-primary.btn-full-width");
        log.info("click on login button Success");

        //validate the error message
        String expectedError = " Please enter your password";
        String actualError = getElementText(".error-messages");
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");
    }


}


