package org.testing.day20190715;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {
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

    /**
     * 打开测试页面
     * 点击wait按钮(隐士等待)driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     * 获取文本 并判断是否 "wait for display"
     */
    @Test
    public void waitTest() {
        driver.get("file:///D:/deaProjects/Selenium/.idea/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text, "wait for display");
    }

    /**
     * 打开测试页面
     * 点击wait按钮(显示等待);
     * 获取文本 并判断是否 "wait for display"
     */
    @Test
    public void waitTest2() {
        driver.get("file:///D:/deaProjects/Selenium/.idea/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));
        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text, "wait for display");
    }
}
