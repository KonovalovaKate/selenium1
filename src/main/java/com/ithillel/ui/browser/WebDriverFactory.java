package com.ithillel.ui.browser;

import com.ithillel.ui.utils.ConfigProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class WebDriverFactory {
    public  static WebDriver driver;
    public static WebDriver getDriver() {
        driver = getDriver(Browser.valueOf(ConfigProvider.BROWSER.toUpperCase()));
        return driver;

    };
   private static WebDriver getDriver (Browser browser){
        switch (browser) {
            case CHROME:
              return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            default:
                throw new IllegalArgumentException("Wrong browser type provider. Choices are: Chrome, Firefox");

        }

    }

    private static WebDriver getFirefoxDriver() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;}


    public static WebDriver getChromeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;}

}
