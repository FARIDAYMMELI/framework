package orange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import team2.SetUp;

public class Feature1 extends SetUp {
    Logger log = LogManager.getLogger(Feature1.class.getName());
    @Test
    public void validCred() throws InterruptedException {

       // String expectedTitle = "OrangeHRM";
       // String actualTitle = getCurrentTitle();
       // Assert.assertEquals(expectedTitle,actualTitle);

        //enter username, password, and click on login button
        type("input[name='username']","Admin");
        log.info("enter username success");
        type("input[type='password']","admin123");
        log.info("enter password success");
        clickOn(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button");
        log.info("click on login button Success");

        //check user is logged in
        String expectedHomePageHeader = "Dashboard";
        String actualHomePageHeader = getElementText(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");
    }

    @Test
    public void invalidUsername(){
        String expectedTitle = "OrangeHRM";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        type("input[name='username']","Admingo");
        log.info("enter username success");
        type("input[type='password']","admin123");
        log.info("enter password success");
        clickOn(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button");
        log.info("click on login button Success");

        //validate the error message
        String expectedError = "Invalid credentials";
        String actualError = getElementText(".oxd-text.oxd-text--p.oxd-alert-content-text");
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");
    }

    @Test
    public void missingUsername(){
        String expectedTitle = "OrangeHRM";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        type("input[name='username']","");
        log.info("enter username success");
        type("input[type='password']","admin123");
        log.info("enter password success");
        clickOn(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button");
        log.info("click on login button Success");

        //validate the error message
        String expectedError = "Required";
        String actualError = getElementText(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message");
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");
    }
    @Test
    public void missingPassword(){
        String expectedTitle = "OrangeHRM";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        type("input[name='username']","Admin");
        log.info("enter username success");
        type("input[type='password']","");
        log.info("enter password success");
        clickOn(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button");
        log.info("click on login button Success");

        //validate the error message
        String expectedError = "Required";
        String actualError = getElementText(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message");
        Assert.assertEquals(expectedError, actualError);
        log.info("validate error success");
    }


    }



