package org.testing.day20190714;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    private WebDriver driver;

    @BeforeMethod
    public void openChorme() {
        System.setProperty("webdriver.chrome.driver", "D:\\deaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 1 打开测试页面
     * 2 点击Alert按钮
     * 3 在alert警告框点击确定按钮
     * 4 获取警告框文本值
     */
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("D:\\deaProjects\\Selenium\\.idea\\selenium_html\\index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        //把控制权交给alert
        Alert alert = driver.switchTo().alert();  //仅限于js弹窗 无法用来定位
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals(text,"请点击确定");

    }

    /**
     * 1 打开测试页面
     * 2 点击Confirm按钮
     * 3 在Confirm警告框点击取消按钮
     * 4 再次点击确定按钮
     */
    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("D:\\deaProjects\\Selenium\\.idea\\selenium_html\\index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        //driver 控制权转交给 alert
        Alert alert = driver.switchTo().alert();
        alert.dismiss(); //点击取消
        Thread.sleep(3000);
        alert.accept(); //点击确定
        Thread.sleep(1000);
    }
    /**
     * 1 打开测试页面
     * 2 点击Prompt按钮
     * 3 在Prompt 弹窗中 输入 "这是个Prompt"
     * 4 点击确定按钮
     * 5 再次点击确定按钮
     */
    @Test
    public void promptTest() throws InterruptedException {
        driver.get("D:\\deaProjects\\Selenium\\.idea\\selenium_html\\index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这是个Prompt");  //chrome 不会输出文字
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();  //再次点击确定按钮
    }
    @AfterMethod
    public void quitChorme() {
        driver.quit();
    }
}
