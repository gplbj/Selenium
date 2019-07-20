package org.testing.day20190714;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {
    private WebDriver driver;

    @BeforeMethod
    public void openChorme() {
        System.setProperty("webdriver.chrome.driver", "D:\\deaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 点击百度首页的新闻链接
     * 那么我打开了新闻页面
     */
    @Test
    public void clickTest() {
        driver.get("https://www.baidu.com/");
        WebElement newslink = driver.findElement(By.name("tj_trnews"));
        newslink.click();
        //获取当前页面的url
        String url = driver.getCurrentUrl();
        //校验当前页面是不是新闻页面
        Assert.assertEquals(url, "http://news.baidu.com/");

    }

    /**
     * 打开百度首页
     * 输入关键字selenium
     * 点击百度一下进行搜索
     * 校验title 是否等于"selenium_百度搜索"
     */
    @Test
    public void sendkeysTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        WebElement keys = driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        WebElement baiduButton = driver.findElement(By.id("su"));
        baiduButton.click();
        Thread.sleep(3000);//自动化执行速度过快 不进行线程等待 获取到的title标题为当前页面的title
        //获取页面标题
        String title = driver.getTitle();
        Assert.assertEquals(title, "selenium_百度搜索");
    }

    /**
     * 打开百度首页
     * 输入关键字selenium
     * 等待3秒
     * 清空selenium
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void clearTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        WebElement keys = driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        Thread.sleep(3000);
        keys.clear();
        Thread.sleep(3000);
    }

    /**
     * 打开百度首页
     * 定位超连接新闻
     * 获取超链接文本
     */
    @Test
    public void getTextTest() {
        driver.get("https://www.baidu.com/");
        String text = driver.findElement(By.name("tj_trnews")).getText();
        Assert.assertEquals(text, "新闻");
    }

    /**
     * 打开百度首页
     * 定位搜索框
     * 判断标签值是不是input
     */
    @Test
    public void getTagNameTest() {
        driver.get("https://www.baidu.com/");
        String tagName = driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName, "input");
    }

    /**
     * 打开百度页面
     * 判断按钮显示的value值为百度一下
     */
    @Test
    public void getAttributeTest() {
        driver.get("https://www.baidu.com/");
        String attributeName = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attributeName, "百度一下");
    }

    /**
     * 打开百度首页
     * 判断是否显示百度一下按钮
     */
    @Test
    public void isDisplayedTest() {
        driver.get("https://www.baidu.com/");
        Boolean flag = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(flag);
    }

    /**
     * 打开测试页面
     * 判断Volvo单选框被选中
     */
    @Test
    public void isSelectTest() {
        driver.get("D:\\deaProjects\\Selenium\\.idea\\selenium_html\\index.html");
        WebElement element = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[4]/td[2]/div/input[1]"));
        //点击
        element.click();
        Boolean flag = element.isSelected();
        Assert.assertTrue(flag);
    }

    /**
     * 打开测试页面
     * 判断 submit 按钮处于未激活状态
     */
    @Test
    public void isEnabledTest(){
        driver.get("D:\\deaProjects\\Selenium\\.idea\\selenium_html\\index.html");
        Boolean b = driver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(b);
    }

    /**
     * 截图百度首页
     */
    @Test
    public void shotTest(){
        driver.get("https://www.baidu.com/");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\test1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void quitChorme() {
        driver.quit();
    }

}
