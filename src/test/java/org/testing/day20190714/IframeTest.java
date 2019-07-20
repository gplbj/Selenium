package org.testing.day20190714;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    private WebDriver driver;

    @BeforeMethod
    public void openChorme() {
        System.setProperty("webdriver.chrome.driver", "D:\\deaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开测试页面
     * 点击百度链接
     */
    @Test
    public void iframeTest() throws InterruptedException {
        //iframe窗口的跳转
        driver.get("D:\\deaProjects\\Selenium\\.idea\\selenium_html\\index.html");
        driver.findElement(By.id("user")).sendKeys("this is iframe");
        Thread.sleep(3000);
        //把控制权转交给iframe界面，，id或者属性值为aa的iframe窗口,下面一个方法是没有Id和属性值的情况
        driver.switchTo().frame("aa");
        //点击iframe窗口的Linktext为baidu的按钮
        driver.findElement(By.linkText("baidu")).click();
        //把控制权回到顶部页面
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("this is another iframe");
    }
    @AfterMethod
    public void quitChorme() {
        driver.quit();
    }
}
