package org.testing.day20190716;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSTest {
    //document.getElementById("kw").setAttribute("value","webdriver")
    private WebDriver driver;

    @BeforeMethod
    public void openChorme() {
        System.setProperty("webdriver.chrome.driver", "D:\\deaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //延时等待 全局等待

    }

    @AfterMethod
    public void quitChorme() throws InterruptedException {
        Thread.sleep(1000);  //线程等待
        driver.quit();
    }
    /***
     * 打开百度首页
     * 通过js在输入框输入 webdriver
     */
    @Test
    public void exJS(){
        driver.get("https://www.baidu.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\")\n");
    }
}
