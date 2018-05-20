package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteTest {

    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void NavigateToSite() throws MalformedURLException {
        //WebDriver driver = new ChromeDriver();
        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setBrowserName("internet explorer");
        //caps.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
        //WebDriver driver2 = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
        wait = new WebDriverWait(driver, 60);
        driver.navigate().to("http://google.com");
        driver.findElement(By.name("q")).sendKeys("docker");
        driver.findElement(By.name("btnK")).submit();
        //Assert.assertTrue("Always failed",false);
    }

    @After
    public void stop() {
        driver.close();
        driver.quit();
        driver = null;
    }




}