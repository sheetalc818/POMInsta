package com.bridgelabz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationToInsta {
    WebDriver driver;

    @CacheLookup
    @FindBy(linkText = "Sign up")
    WebElement singUpLink;

    @CacheLookup
    @FindBy(name = "emailOrPhone")
    WebElement mobileNo;

    @CacheLookup
    @FindBy(name = "fullName")
    WebElement fullName;

    @CacheLookup
    @FindBy(name = "username")
    WebElement userName;

    @CacheLookup
    @FindBy(name = "password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    WebElement signUpButton;

    public RegistrationToInsta(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String redirectOnToSignUpScreen() throws InterruptedException {
        Thread.sleep(1000);
        singUpLink.click();
        Thread.sleep(2000);
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public boolean enterDataInToTheFields() throws InterruptedException {
        singUpLink.click();
        Thread.sleep(2000);
        mobileNo.sendKeys("704676767");
        fullName.sendKeys("abcjhf");
        userName.sendKeys("test46556");
        password.sendKeys("878878@jjkjf");
        Thread.sleep(500);
        boolean flag = signUpButton.isEnabled();
        return flag;
    }
}
