package org.testing.day20190712;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementTest {
    private WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "D:\\deaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开百度页面
     * 定位搜索文本框(通过id)
     * 输入hello world
     * 等待3秒
     * 点击百度搜索
     * 等待三秒
     * 关闭浏览器
     */
    @Test
    public void findElementById() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("hello world");
        Thread.sleep(3000);
        driver.findElement(By.id("su")).click();
        Thread.sleep(3000);

    }

    /**
     * 打开百度页面
     * 通过name定位搜索文本框
     */
    @Test
    public void byNameTest() {
        driver.get("https://www.baidu.com/");
        WebElement keyField = driver.findElement(By.name("wd"));
    }


    @Test
    public void byLinkText() {
        driver.get("https://www.baidu.com/");
        WebElement keyField = driver.findElement(By.linkText("新闻"));
    }

    /**
     * 打开百度页面
     * 通过tagname定位搜索框
     */
    @Test
    public void byTagName() {
        driver.get("https://www.baidu.com/");
        List<WebElement> elements = driver.findElements(By.tagName("input"));
        System.out.println(elements.size());
    }

    /**
     * 打开百度页面
     * 通过xpath定位 百度一下按钮
     */
    @Test
    public void byXpath(){
        driver.get("https://baidu.com/");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"su\"]"));

    }

    /**
     * 打开百度页面
     * 通过css定位百度图片
     */
    @Test
    public void byCssSelector(){
        driver.get("https://www.baidu.com/");
        WebElement element = driver.findElement(By.cssSelector("#lg > map:nth-child(3) > area:nth-child(1)"));
    }

    /**
     * 打开百度页面
     * 通过xpath定位所有搜索链接
     * 获取所有定位链接的文本
     */
    @Test
    public void byXpathGetAllLink(){
        driver.get("https://www.baidu.com/");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"u1\"]/a"));
        for (WebElement element:
             elements) {
            String text = element.getText();
            System.out.println(text);
        }
    }
    @AfterMethod
    public void quitWebBrower() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
