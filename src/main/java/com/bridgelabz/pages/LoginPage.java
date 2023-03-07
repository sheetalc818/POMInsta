package com.bridgelabz.pages;

import com.bridgelabz.utility.ReadPropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends ReadPropertyFile {
        WebDriver driver;

        @CacheLookup
        @FindBy(name = "username")
        WebElement userName;

        @CacheLookup
        @FindBy(name = "password")
        WebElement password;

        @CacheLookup
        @FindBy(xpath = "//div[contains(text(), 'Log in')]")
        WebElement loginBtn;

        public LoginPage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver,this);
        }

        public void loginToInsta(String userN , String pass) throws InterruptedException {
            driver.findElement(By.name(properties.getProperty("loginUsernameData"))).sendKeys(userN);
            //userName.sendKeys(userN);
            password.sendKeys(pass);
            loginBtn.click();
            Thread.sleep(2000);
            checkRedirectOnHomePage();
        }
        public void checkRedirectOnHomePage(){
            String title = driver.getTitle();
            Assert.assertEquals("Instagram",title);
        }

}
