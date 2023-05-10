package gumtree;

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
        String expectedTitle = "Gumtree | Free classified ads from the #1 classifieds site in the UK";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        type("#email","Tamannabegum70294@gmail.com");
        log.info("enter username success");
        type("input[type='password']","Apples123!");
        log.info("enter password success");
        clickOn(".btn-primary.btn-full-width");
        log.info("click on login button Success");

        //check user is logged in
        String expectedHomePageHeader = "Gumtree";
        String actualHomePageHeader = getElementText(".logo-text.gumtree-text-svg.hide-fully-to-s");
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");

        //click on hamburger menu
        clickOn(".header-nav-mygumtree.user-logged-in.is-open");
        log.info("click on hamburger menu success");
        Thread.sleep(1000);

        //hover hover & click on logout link
        hoverOver("(//span[contains(text(),'Logout')])[1]");
        log.info("click on logout link success");

        //check user is landed to the login page
        boolean loginPageHeaderIsDisplayed = isVisible(".header-button.header-nav-link");
        Assert.assertTrue(loginPageHeaderIsDisplayed);
        log.info("login page header is displayed");
        String expectedLoginPageHeaderText = "Gumtree";
        String actualLoginPageHeaderText = getElementText(".logo-text.gumtree-text-svg.hide-fully-to-s");
        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
        log.info("login page header text validation success");
    }
}
