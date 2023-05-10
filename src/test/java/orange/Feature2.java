package orange;

import scaledupit.LogoutTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import team2.SetUp;

public class Feature2 extends SetUp {

    Logger log = LogManager.getLogger(LogoutTest.class.getName());

    @Test
    public void logout() throws InterruptedException {
        String expectedTitle = "OrangeHRM";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
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

        //click on dropdown
        clickOn(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon");
        log.info("click on dropdown success");
        Thread.sleep(1000);

        clickOn("//a[text()=\"Logout\"]");
        log.info("click on logout link success");

        //check user is landed to the login page
        boolean loginPageHeaderIsDisplayed = isVisible(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button");
        Assert.assertTrue(loginPageHeaderIsDisplayed);
        log.info("login page header is displayed");
        String expectedLoginPageHeaderText = "Login";
        String actualLoginPageHeaderText = getElementText(".oxd-text.oxd-text--h5.orangehrm-login-title");
        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
        log.info("login page header text validation success");
}
}
