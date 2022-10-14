package com.ithillel.ui;

import com.ithillel.ui.browser.WebDriverFactory;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BaseUiTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start (){
        // System.setProperty ("webdriver.chrome.driver","C:/dev/driver/chromedriver.exe");
        driver = WebDriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        BasicConfigurator.configure();

    }
    @Test
    public void test (){
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElements(By.name("btnK")).get(1).click();
        Assert.assertEquals(driver.getTitle(), "webdriver - Поиск в Google");

    }
    @AfterTest
    public void stop (){
        driver.quit();
    }

}
