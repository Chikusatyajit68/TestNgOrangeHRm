import orangehrm.pages.Dashbaordpage;
import orangehrm.pages.LoginPage;
import orangehrm.utils.Browser;
import orangehrm.utils.Dataconfig;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class DashboardPageTest {
    private static WebDriver driver;
    Dashbaordpage obj;
    LoginPage loginPage;
    Robot robot;

    @BeforeMethod
    public void setUp() {
        driver = Browser.LaunchBrowser();
        Browser.openUrl();
    }

    @AfterMethod
    public void tearDown() {
        Browser.closeBrowser();
    }

    @org.testng.annotations.Test(alwaysRun = true,priority = 1)
    public void verrifyLoginBtnfunctionalitywithValidCredentials() throws InterruptedException, IOException {
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);

        loginPage.setTextinUserName();
        Thread.sleep(3000);
        loginPage.setTextinPassword();
        Thread.sleep(3000);
        loginPage.clickOnLoginBtn();
        Thread.sleep(4000);
        obj = new Dashbaordpage(driver);
        // Assert.assertEquals(obj.isdashBoardvisible(),"test script failed as dashboaard is not visible");
        Assert.assertTrue(obj.isdashBoardvisible());
    }

    @Test(alwaysRun = true,priority = 2)
    public void verifyUsabilityOfAdmin() throws IOException, InterruptedException {
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);
        loginPage.setTextinUserName();
        Thread.sleep(3000);
        loginPage.setTextinPassword();
        Thread.sleep(3000);
        loginPage.clickOnLoginBtn();
        obj = new Dashbaordpage(driver);
        Thread.sleep(4000);
        obj.clickonAdmin();
        Thread.sleep(1000);

        boolean status = obj.isuserManagementvisible();

        Assert.assertTrue(status);

    }

    @Test(alwaysRun = true,priority = 3)
    public void verifyfumctonalityoffAdd() throws IOException, InterruptedException {
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);
        loginPage.setTextinUserName();
        Thread.sleep(3000);
        loginPage.setTextinPassword();
        Thread.sleep(3000);
        loginPage.clickOnLoginBtn();
        obj = new Dashbaordpage(driver);
        Thread.sleep(4000);
        obj.clickonAdmin();
        Thread.sleep(1000);
        obj.clickonAdd();
        Thread.sleep(2000);
        boolean status = obj.isadminPageVisible();
        Assert.assertTrue(status);

    }

    @Test(alwaysRun = true,priority = 4)
    public void verifyFunctionalityofsaveButtonwithvakidcredential() throws InterruptedException, IOException, AWTException {
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);
        loginPage.setTextinUserName();
        Thread.sleep(3000);
        loginPage.setTextinPassword();
        Thread.sleep(3000);
        loginPage.clickOnLoginBtn();
        obj = new Dashbaordpage(driver);
        Thread.sleep(4000);
        obj.clickonAdmin();
         Thread.sleep(1000);
        obj.clickonAdd();
        Thread.sleep(2000);
        WebElement userrole = obj.getElement("USERROLEL");
        userrole.click();
        Thread.sleep(2000);
        for (int i=1;i<3;i++)
        {
            userrole.sendKeys(Keys.ARROW_DOWN);
        }
        userrole.sendKeys(Keys.ENTER);

       WebElement status = obj.getElement("STATUSL");
       status.click();
       for (int i=1;i<3;i++)
       {
           status.sendKeys(Keys.ARROW_DOWN);
       }
       Thread.sleep(1000);
      // status.sendKeys(Keys.ARROW_DOWN);
       status.sendKeys(Keys.ENTER);
    //   robot.keyPress(KeyEvent.VK_DOWN);
     //  robot.keyRelease(KeyEvent.VK_DOWN);
    //   robot.keyPress(KeyEvent.VK_ENTER);
     //  robot.keyRelease(KeyEvent.VK_ENTER);
     //   loginPage=new LoginPage(driver);
   //  WebElement  username  = loginPage.getElement("USERNAMEL");
   //  loginPage.SETTEXT(username,"Satyajit");

         WebElement password   = obj.getElement("PASSWORDL");
         loginPage=new LoginPage(driver);
         loginPage.SETTEXT(password,"Satyajit64@gmail.com");
       //  password.sendKeys("Satyajit64@gmail.com");
            WebElement employee       = obj.getElement("EMPLOYEEL");
            Thread.sleep(3000);
            employee.sendKeys("sa");
            Thread.sleep(2000);
            for (int i=1;i<=3;i++)
            {
                employee.sendKeys(Keys.ARROW_DOWN);
            }

            Thread.sleep(1000);
           // employee.sendKeys(Keys.ARROW_DOWN);
            employee.sendKeys(Keys.ENTER);
         WebElement  username=  obj.getElement("USERNAMEL");
           loginPage=new LoginPage(driver);
           Thread.sleep(2000);
           loginPage.SETTEXT(username,"Biswajit");
           Thread.sleep(2000);
       WebElement confirmpasswpord  =  obj.getElement("CONFIRMPASSWORDL");
       loginPage=new LoginPage(driver);
       Thread.sleep(2000);
       loginPage.SETTEXT(confirmpasswpord,"Satyajit64@gmail.com");

     WebElement  save = obj.getElement("SAVEBTNL");

     save.click();
     Thread.sleep(2000);


    }
    @Test(alwaysRun = true,priority = 5)
    public void verifyfunctionalityofsaveBtneveryfieldAsBlank() throws InterruptedException, IOException {
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);
        loginPage.setTextinUserName();
        Thread.sleep(3000);
        loginPage.setTextinPassword();
        Thread.sleep(3000);
        loginPage.clickOnLoginBtn();
        obj = new Dashbaordpage(driver);
        Thread.sleep(4000);
        obj.clickonAdmin();
        Thread.sleep(1000);
        obj.clickonAdd();
        Thread.sleep(2000);
        obj.clickOnSave();
      WebElement req  =obj.getElement("REQL");
         String actcualerrorMsg     =req.getText();
         Thread.sleep(2000);
         Assert.assertEquals(actcualerrorMsg, Dataconfig.requirederrormsg);



    }
    @Test(alwaysRun = false)
    public void verifySaveBtnFunctionalityUsernameAsBlank() throws InterruptedException, IOException {
        loginPage = new LoginPage(driver);
       Thread.sleep(5000);
        loginPage.setTextinUserName();
        Thread.sleep(3000);
        loginPage.setTextinPassword();
        Thread.sleep(3000);
      loginPage.clickOnLoginBtn();
        obj = new Dashbaordpage(driver);
        Thread.sleep(4000);
        obj.clickonAdmin();
        Thread.sleep(1000);
        obj.clickonAdd();
        Thread.sleep(2000);
        WebElement userrole = obj.getElement("USERROLEL");
        userrole.click();
        Thread.sleep(2000);
        for (int i=1;i<3;i++)
        {
            userrole.sendKeys(Keys.ARROW_DOWN);
        }
        userrole.sendKeys(Keys.ENTER);

        WebElement status = obj.getElement("STATUSL");
        status.click();
        for (int i=1;i<3;i++)
        {
            status.sendKeys(Keys.ARROW_DOWN);
        }
        Thread.sleep(1000);
        // status.sendKeys(Keys.ARROW_DOWN);
        status.sendKeys(Keys.ENTER);
        //   robot.keyPress(KeyEvent.VK_DOWN);
        //  robot.keyRelease(KeyEvent.VK_DOWN);
        //   robot.keyPress(KeyEvent.VK_ENTER);
        //  robot.keyRelease(KeyEvent.VK_ENTER);
        //   loginPage=new LoginPage(driver);
        //  WebElement  username  = loginPage.getElement("USERNAMEL");
        //  loginPage.SETTEXT(username,"Satyajit");

        WebElement password   = obj.getElement("PASSWORDL");
        loginPage=new LoginPage(driver);
        loginPage.SETTEXT(password,"Satyajit64@gmail.com");
        //  password.sendKeys("Satyajit64@gmail.com");
        WebElement employee       = obj.getElement("EMPLOYEEL");
        Thread.sleep(3000);
        employee.sendKeys("sa");
        Thread.sleep(2000);
        for (int i=1;i<=3;i++)
        {
            employee.sendKeys(Keys.ARROW_DOWN);
        }

        Thread.sleep(1000);
        // employee.sendKeys(Keys.ARROW_DOWN);
       employee.sendKeys(Keys.ENTER);
       WebElement  username=  obj.getElement("USERNAMEL");
      loginPage=new LoginPage(driver);
        Thread.sleep(2000);
       loginPage.SETTEXT(username,"Bi");
       Thread.sleep(2000);
        WebElement confirmpasswpord  =  obj.getElement("CONFIRMPASSWORDL");
        loginPage=new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.SETTEXT(confirmpasswpord,"Satyajit64@gmail.com");
        obj.clickOnSave();
        Thread.sleep(2000);
         WebElement usernameerror     =  obj.getElement("USERTEXTBOXERRORL");
         Thread.sleep(1000);
        String actualerrorMsg = usernameerror.getText();
     Assert.assertEquals(actualerrorMsg,Dataconfig.usernameerror);

    }
    @Test(alwaysRun = true)
    public void verifySaveBtnFunctionalityEmployeeFieldasInvalid() throws IOException, InterruptedException {
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);
        loginPage.setTextinUserName();
        Thread.sleep(3000);
        loginPage.setTextinPassword();
        Thread.sleep(3000);
        loginPage.clickOnLoginBtn();
        obj = new Dashbaordpage(driver);
        Thread.sleep(4000);
        obj.clickonAdmin();
        Thread.sleep(1000);
        obj.clickonAdd();
        Thread.sleep(2000);
        WebElement userrole = obj.getElement("USERROLEL");
        userrole.click();
        Thread.sleep(2000);
        for (int i=1;i<3;i++)
        {
            userrole.sendKeys(Keys.ARROW_DOWN);
        }
        userrole.sendKeys(Keys.ENTER);

        WebElement status = obj.getElement("STATUSL");
        status.click();
        for (int i=1;i<3;i++)
        {
            status.sendKeys(Keys.ARROW_DOWN);
        }
        Thread.sleep(1000);
        // status.sendKeys(Keys.ARROW_DOWN);
        status.sendKeys(Keys.ENTER);
        //   robot.keyPress(KeyEvent.VK_DOWN);
        //  robot.keyRelease(KeyEvent.VK_DOWN);
        //   robot.keyPress(KeyEvent.VK_ENTER);
        //  robot.keyRelease(KeyEvent.VK_ENTER);
        //   loginPage=new LoginPage(driver);
        //  WebElement  username  = loginPage.getElement("USERNAMEL");
        //  loginPage.SETTEXT(username,"Satyajit");

        WebElement password   = obj.getElement("PASSWORDL");
        loginPage=new LoginPage(driver);
        loginPage.SETTEXT(password,"Satyajit64@gmail.com");
        //  password.sendKeys("Satyajit64@gmail.com");
        WebElement employee       = obj.getElement("EMPLOYEEL");
        employee.sendKeys("sa");
        Thread.sleep(2000);
        for (int i=1;i<=3;i++)
        {
            employee.sendKeys(Keys.ARROW_DOWN);
        }

        Thread.sleep(1000);
        // employee.sendKeys(Keys.ARROW_DOWN);
        employee.sendKeys(Keys.ENTER);


        Thread.sleep(1000);
        // employee.sendKeys(Keys.ARROW_DOWN);
        employee.sendKeys(Keys.ENTER);
        WebElement  username=  obj.getElement("USERNAMEL");
        loginPage=new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.SETTEXT(username,"Biswajit000");
        Thread.sleep(2000);
        WebElement confirmpasswpord  =  obj.getElement("CONFIRMPASSWORDL");
        loginPage=new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.SETTEXT(confirmpasswpord,"Satyajit64@gmail.com");
        WebElement employee1       = obj.getElement("EMPLOYEEL");
        Thread.sleep(3000);
        employee1.sendKeys("cxd");
        Thread.sleep(2000);


        Thread.sleep(1000);
        // employee.sendKeys(Keys.ARROW_DOWN);
        employee1.sendKeys(Keys.ENTER);
        obj.clickOnSave();
        Thread.sleep(2000);
    WebElement invaliderror  =  obj.getElement("INVL");
     Thread.sleep(6000);
    String actualError= invaliderror.getText();
         Thread.sleep(1000);
         Assert.assertEquals(actualError,Dataconfig.EmployeeNameError);
    }
    @Test(alwaysRun = true,priority = 0)
    public void verifySaveBtnFunctionalityInavalidPasswordsField() throws IOException, InterruptedException {
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);
        loginPage.setTextinUserName();
        Thread.sleep(3000);
        loginPage.setTextinPassword();
        Thread.sleep(3000);
        loginPage.clickOnLoginBtn();
        obj = new Dashbaordpage(driver);
        Thread.sleep(4000);
        obj.clickonAdmin();
        Thread.sleep(1000);
        obj.clickonAdd();
        Thread.sleep(2000);
        WebElement userrole = obj.getElement("USERROLEL");
        userrole.click();
        Thread.sleep(2000);
        for (int i=1;i<3;i++)
        {
            userrole.sendKeys(Keys.ARROW_DOWN);
        }
        userrole.sendKeys(Keys.ENTER);

        WebElement status = obj.getElement("STATUSL");
        status.click();
        for (int i=1;i<3;i++)
        {
            status.sendKeys(Keys.ARROW_DOWN);
        }
        Thread.sleep(1000);
        // status.sendKeys(Keys.ARROW_DOWN);
        status.sendKeys(Keys.ENTER);
        //   robot.keyPress(KeyEvent.VK_DOWN);
        //  robot.keyRelease(KeyEvent.VK_DOWN);
        //   robot.keyPress(KeyEvent.VK_ENTER);
        //  robot.keyRelease(KeyEvent.VK_ENTER);
        //   loginPage=new LoginPage(driver);
        //  WebElement  username  = loginPage.getElement("USERNAMEL");
        //  loginPage.SETTEXT(username,"Satyajit");

        WebElement password   = obj.getElement("PASSWORDL");
        loginPage=new LoginPage(driver);
        loginPage.SETTEXT(password,"Satya");
        //  password.sendKeys("Satyajit64@gmail.com");
        WebElement employee       = obj.getElement("EMPLOYEEL");

        WebElement  username=  obj.getElement("USERNAMEL");
        loginPage=new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.SETTEXT(username,"Biswajit000");
        Thread.sleep(2000);
        WebElement confirmpasswpord  =  obj.getElement("CONFIRMPASSWORDL");
        loginPage=new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.SETTEXT(confirmpasswpord,"Satyajit64@gmail.com");
        WebElement employee1       = obj.getElement("EMPLOYEEL");
        Thread.sleep(3000);
        employee1.sendKeys("cxd");
        Thread.sleep(2000);


        Thread.sleep(1000);
        // employee.sendKeys(Keys.ARROW_DOWN);
        employee1.sendKeys(Keys.ENTER);
        obj.clickOnSave();
        Thread.sleep(2000);
       WebElement passwordtextbox   =  obj.getElement("PASSWORDTEXTBOXERRORL1");
    String actualerrorMsg  = passwordtextbox.getText();
    Assert.assertEquals(actualerrorMsg,Dataconfig.passworderrorMsg1);

    }
    @Test(alwaysRun = true)
    public void verifySaveBtnFunctionalityPasswordFielasAsInvalidFormat() throws IOException, InterruptedException {
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);
        loginPage.setTextinUserName();
        Thread.sleep(6000);
        loginPage.setTextinPassword();
        Thread.sleep(3000);
        loginPage.clickOnLoginBtn();
        obj = new Dashbaordpage(driver);
        Thread.sleep(4000);
        obj.clickonAdmin();
        Thread.sleep(1000);
        obj.clickonAdd();
        Thread.sleep(2000);
        WebElement userrole = obj.getElement("USERROLEL");
        userrole.click();
        Thread.sleep(2000);
        for (int i=1;i<3;i++)
        {
            userrole.sendKeys(Keys.ARROW_DOWN);
        }
        userrole.sendKeys(Keys.ENTER);

        WebElement status = obj.getElement("STATUSL");
        status.click();
        for (int i=1;i<3;i++)
        {
            status.sendKeys(Keys.ARROW_DOWN);
        }
        Thread.sleep(1000);
        // status.sendKeys(Keys.ARROW_DOWN);
        status.sendKeys(Keys.ENTER);
        //   robot.keyPress(KeyEvent.VK_DOWN);
        //  robot.keyRelease(KeyEvent.VK_DOWN);
        //   robot.keyPress(KeyEvent.VK_ENTER);
        //  robot.keyRelease(KeyEvent.VK_ENTER);
        //   loginPage=new LoginPage(driver);
        //  WebElement  username  = loginPage.getElement("USERNAMEL");
        //  loginPage.SETTEXT(username,"Satyajit");

        WebElement password   = obj.getElement("PASSWORDL");
        loginPage=new LoginPage(driver);
        loginPage.SETTEXT(password,"jcxdsv€frvgJKWERG");
        //  password.sendKeys("Satyajit64@gmail.com");
        WebElement employee       = obj.getElement("EMPLOYEEL");

        WebElement  username=  obj.getElement("USERNAMEL");
        loginPage=new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.SETTEXT(username,"Biswajit000");
        Thread.sleep(2000);
        WebElement confirmpasswpord  =  obj.getElement("CONFIRMPASSWORDL");
        loginPage=new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.SETTEXT(confirmpasswpord,"Satyajit64@gmail.com");
        WebElement employee1       = obj.getElement("EMPLOYEEL");
        Thread.sleep(3000);
        employee1.sendKeys("cxd");
        Thread.sleep(2000);


        Thread.sleep(1000);
        // employee.sendKeys(Keys.ARROW_DOWN);
        employee1.sendKeys(Keys.ENTER);
        obj.clickOnSave();
        Thread.sleep(2000);
    WebElement passwordtxtbox   =  obj.getElement("PASSWORDTEXTBOXERRORL2");
                String actualError=passwordtxtbox.getText();
                Assert.assertEquals(actualError,Dataconfig.passworderrorMsg2);

    }
    @Test(alwaysRun = true)
    public void verifysaveBtnFunctionalitywithinvalidConfirmPasswordField() throws IOException, InterruptedException {
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);
        loginPage.setTextinUserName();
        Thread.sleep(3000);
        loginPage.setTextinPassword();
        Thread.sleep(3000);
        loginPage.clickOnLoginBtn();
        obj = new Dashbaordpage(driver);
        Thread.sleep(4000);
        obj.clickonAdmin();
        Thread.sleep(1000);
        obj.clickonAdd();
        Thread.sleep(2000);
        WebElement userrole = obj.getElement("USERROLEL");
        userrole.click();
        Thread.sleep(2000);
        for (int i=1;i<3;i++)
        {
            userrole.sendKeys(Keys.ARROW_DOWN);
        }
        userrole.sendKeys(Keys.ENTER);

        WebElement status = obj.getElement("STATUSL");
        status.click();
        for (int i=1;i<3;i++)
        {
            status.sendKeys(Keys.ARROW_DOWN);
        }
        Thread.sleep(1000);
        // status.sendKeys(Keys.ARROW_DOWN);
        status.sendKeys(Keys.ENTER);
        //   robot.keyPress(KeyEvent.VK_DOWN);
        //  robot.keyRelease(KeyEvent.VK_DOWN);
        //   robot.keyPress(KeyEvent.VK_ENTER);
        //  robot.keyRelease(KeyEvent.VK_ENTER);
        //   loginPage=new LoginPage(driver);
        //  WebElement  username  = loginPage.getElement("USERNAMEL");
        //  loginPage.SETTEXT(username,"Satyajit");

        WebElement password   = obj.getElement("PASSWORDL");
        loginPage=new LoginPage(driver);
        loginPage.SETTEXT(password,"Satyajit64@gmail.com");
        //  password.sendKeys("Satyajit64@gmail.com");
        WebElement employee       = obj.getElement("EMPLOYEEL");
        Thread.sleep(3000);
        employee.sendKeys("sa");
        Thread.sleep(2000);
        for (int i=1;i<=3;i++)
        {
            employee.sendKeys(Keys.ARROW_DOWN);
        }

        Thread.sleep(1000);
        // employee.sendKeys(Keys.ARROW_DOWN);
        employee.sendKeys(Keys.ENTER);
        WebElement  username=  obj.getElement("USERNAMEL");
        loginPage=new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.SETTEXT(username,"Biswajit");
        Thread.sleep(2000);
        WebElement confirmpasswpord  =  obj.getElement("CONFIRMPASSWORDL");
        loginPage=new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.SETTEXT(confirmpasswpord,"Sat");
  WebElement confirmpassword   =   obj.getElement("CONFIRMPASSWORDERRORL");
        String ERRORMSG     = confirmpassword.getText();
        Thread.sleep(1000);
        Assert.assertEquals(ERRORMSG,Dataconfig.confirmpassworderrorMsg);









    }

}
