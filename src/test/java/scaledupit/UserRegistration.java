package scaledupit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import team2.SetUp;

public class UserRegistration extends SetUp {


    Logger log = LogManager.getLogger(scaledupit.UserRegistration.class.getName());
    //	Test Case ID number 1 :  Verify that the user is able to register a new account


    @Test
    public void RegistrationValidation() throws InterruptedException {

        //	 Navigate to the scaledupit.com  website
        String expected = "Automation – Automate eCommerce";
        String actual = getCurrentTitle();
        Assert.assertEquals(expected, actual);

        //Click on the "login/register button" link in the header
        //String myRegistration = clickOn ("//a[@href='https://automation.scaledupit.com/my-account/' and @aria-current='page']");

        //log.info(myRegistration);
         // String actualAccountPage = "Login/Register";
        //String expectedAccountPage = myRegistration;

        //Assert.assertEquals(expectedAccountPage, actualAccountPage);

        //clickOn(myRegistration);
        clickOn("#menu-item-324 > a");
         log.info("click on to login/register button success");
        //clickOn ("//a[@href='https://automation.scaledupit.com/my-account/' and @aria-current='page']");


        log.info("my Registration  page");
        Thread.sleep(1000);

        // scroll to register (hover hover )
        //hoverOver("/html/body/div/div[1]/div/div[3]/div/main/article/div/div/div[2]/div[2]/h2");
        //log.info("hover Over to registration  success");


        //fill registration form


        type("#reg_email", "farida892010@hotmail.fr");
        log.info("enter email name success");
        type("#reg_password", "Password14@");
        log.info("enter password success");


        // click on register button

        clickOn("button[value='Register']");
        log.info("click on registration button Success");

        //check user is registered

              String expectedHomePageHeader = "Account details";
              String actualHomePageHeader = getElementText("//a[text()=\"Account details\"]" );
              Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
              log.info("user registration  in success ");

    }

    @Test
    public void RegistrationInValid() throws InterruptedException {

        //	 Navigate to the scaledupit.com  website

        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("the link is the correct one");

        //Click on the "login/registration" link in the header

          //String myRegistration = getElementText("#menu-item-324 > a");

          //log.info(myRegistration);
           // String actualAccountPage = "Login/Register";
          //String expectedAccountPage = myRegistration;

          //Assert.assertEquals(expectedAccountPage, actualAccountPage);

         // clickOn(myRegistration);

           clickOn("#menu-item-324 > a");
           log.info("click on to login/register button success");



          Thread.sleep(1000);

          log.info("my Registration  page is open ");



       // String myAccount = getElementText("a[href='/account']");

        // scroll to register (hover hover )
        //hoverOver("/html/body/div/div[1]/div/div[3]/div/main/article/div/div/div[2]/div[2]/h2");
        //log.info("hover Over to registration  success");

        //fill registration form

        type("#reg_email", "farida@hotmail.com");
        log.info("enter email name success");
        type("#reg_password", "Password14@");
        log.info("enter password success");

        // click on register button

        clickOn("button[value='Register']");
        log.info("click on  registration button  fail, the register succeed with wrong email , a bug detected");


        //check user is  not registered

               String expectedHomePageHeader = "LOGIN/REGISTER";
               String actualHomePageHeader = getElementText("#menu-item-324 > a");
               Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
               log.info("user registration  in not  succeed");


    }
}





