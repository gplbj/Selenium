package org.testing.day20190712;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 对浏览器的操作
 */
public class BrowserActionsTest {
    private WebDriver driver;
    @BeforeMethod
    public void openChorme(){
        //C:\Users\GPLBJ\AppData\Local\Google\Chrome\Application
        System.setProperty("webdriver.chrome.driver","D:\\deaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    /**
     * 打开chrome浏览器
     * 打开 百度首页
     * 等待3s
     * 关闭浏览器
     */
      @Test
    public void openBaiDu() throws InterruptedException {
            driver.get("https://www.baidu.com/");
            Thread.sleep(3000);

      }
    /**
     * 打开chrome浏览器
     * 打开百度首页
     * 等待3s
     * 后退
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void backBaiDu() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);

    }
    /**
     * 打开chrome浏览器
     * 打开百度首页
     * 等待3s
     * 后退
     * 等待3s
     * 前进
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void backForwordBaiDu() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);

    }
    /**
     * 打开chrome浏览器
     * 打开百度首页
     * 等待2s
     * 刷新
     * 等待2s
     * 关闭浏览器
     */
    @Test
    public void refreshBaidu() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
    /**
     * 打开chrome 浏览器
     * 设置窗口大小 300*300
     * 等待3s
     * 最大化窗口
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void windowsTest() throws InterruptedException {
        Dimension dimension = new Dimension(300,300);  //设置窗口大小
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        driver.manage().window().maximize();  //窗口最大化
        Thread.sleep(3000);
    }
    /**
     * 打开chrome浏览器
     * 打开百度首页
     * 等待3s
     * 获取当前页面的URL
     * 校验当前页面URL是不是百度地址
     * 关闭浏览器
     */
    @Test
    public  void getBaiduURL() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        System.out.println("获取到的URL是: "+url);
        Assert.assertEquals(url,"https://www.baidu.com/");
    }

    /***
     * 关闭浏览器
     */
    @AfterMethod
    public  void quitWebBrower(){
        driver.quit();
    }

}
