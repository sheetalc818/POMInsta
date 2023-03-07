package com.bridgelabz.test;

import com.bridgelabz.baseclass.BaseClass;
import com.bridgelabz.pages.LoginPage;
import com.bridgelabz.pages.RegistrationToInsta;
import com.bridgelabz.utility.DataProviderLogic;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

@Epic("Instagram Regression")
public class InstagramTest extends BaseClass {
    RegistrationToInsta registration;
    LoginPage login;

    @BeforeMethod
    public void initialization(){
        setUp();
        registration = new RegistrationToInsta(driver);
        login = new LoginPage(driver);
    }

    @Test(priority = 0)
    @Severity(value = SeverityLevel.NORMAL)
    @Step("Redirect to Signup screen")
    public void redirectOnSignup() throws InterruptedException {
        log.debug("signUp");
        String title = registration.redirectOnToSignUpScreen();
        Thread.sleep(1000);
        Assert.assertEquals("Sign up • Instagram", title);
        log.info("redirectOnSignup");
    }

    @Test(priority = 1)
    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Registration")
    public void insertTheDataIntoTheRegistrationField() throws InterruptedException {
        log.debug("insert");
        Thread.sleep(1000);
        boolean isEnable = registration.enterDataInToTheFields();
        Assert.assertEquals(true,isEnable);
        log.info("success insert data");
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Step("Login to insta")
    @Test(priority = 2, dataProvider = "testData", dataProviderClass = DataProviderLogic.class)
    public void loginToInsta(String userName, String pass) throws InterruptedException {
        login.loginToInsta(userName,pass);
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }
}
