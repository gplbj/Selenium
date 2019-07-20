package org.testing.day20190711;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

/**
 * 打开不同的浏览器
 */
public class OpenBrowserTest {
    @Test
    public void openFireFox(){
        System.setProperty("webdriver.firefox.bin","F:\\FireFox47\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
    }
    @Test
    public void openChorme(){
        //C:\Users\GPLBJ\AppData\Local\Google\Chrome\Application
        System.setProperty("webdriver.chrome.driver","D:\\deaProjects\\Selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

    }
    @Test
    public void openIe(){
        System.setProperty("webdriver.ie.driver","D:\\deaProjects\\Selenium\\drivers\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();
    }
    @Test
    public void openEdge(){
        System.setProperty("webdriver.edge.driver","D:\\deaProjects\\Selenium\\drivers\\MicrosoftWebDriver.exe");
        WebDriver webDriver = new EdgeDriver();
    }
}
