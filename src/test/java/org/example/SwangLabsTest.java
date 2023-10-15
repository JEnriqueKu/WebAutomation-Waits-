package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwangLabsTest {
    WebDriver driver;
    Wait<WebDriver> wait;

    @Test
    public void implicityWaitLogin(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();

        WebElement userNameBox = driver.findElement(By.id("user-name"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        WebElement logInButton = driver.findElement(By.id("login-button"));

        userNameBox.sendKeys("standard_user");
        passwordBox.sendKeys("secret_sauce");
        logInButton.click();

        WebElement title = driver.findElement(By.className("product_label"));

        Assert.assertEquals(title.getText(), "Products");
        driver.quit();
    }

    @Test
    public void explicitWaitLogin(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();

        WebElement userNameBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("user-name")  ));
        WebElement passwordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("password")  ));
        WebElement logInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("login-button")  ));

        userNameBox.sendKeys("standard_user");
        passwordBox.sendKeys("secret_sauce");
        logInButton.click();

        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("product_label")  ));

        Assert.assertEquals(title.getText(), "Products");
        driver.quit();
    }

    @Test
    public void fluentWaitLogin(){
        driver = new ChromeDriver();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();

        WebElement userNameBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("user-name")  ));
        WebElement passwordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("password")  ));
        WebElement logInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("login-button")  ));

        userNameBox.sendKeys("standard_user");
        passwordBox.sendKeys("secret_sauce");
        logInButton.click();

        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("product_label")  ));

        Assert.assertEquals(title.getText(), "Products");
        driver.quit();
    }
}
