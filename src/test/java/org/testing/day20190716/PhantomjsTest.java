package org.testing.day20190716;

import org.openqa.selenium.By;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 使用phantomJS
 */
public class PhantomjsTest {
    @Test
    public void testPH() throws InterruptedException {
        //设置phantomjs driver路径
        System.setProperty("phantomjs.binary.path","D:\\deaProjects\\Selenium\\drivers\\phantomjs.exe");
        // 打开phantomJS浏览器
        PhantomJSDriver driver = new PhantomJSDriver();
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("phantomJS");
        Thread.sleep(3000);
        String title = driver.getTitle();
        Assert.assertEquals(title,"百度一下，你就知道");
        driver.quit();
    }
}
