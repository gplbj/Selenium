package org.testing.day20190715;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {
    private WebDriver driver;

    @BeforeMethod
    public void openChorme() {
        System.setProperty("webdriver.chrome.driver", "D:\\deaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开测试页面
     * 点击下拉框
     * 选择huawei,iphone
     */
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("D:\\deaProjects\\Selenium\\.idea\\selenium_html\\index.html");
        WebElement selectEl = driver.findElement(By.id("moreSelect"));
        Select select = new Select(selectEl);
        select.selectByIndex(2); //通过索引
        Thread.sleep(3000);
        select.selectByValue("huawei");  //通过value来选择下拉框
        Thread.sleep(3000);
        select.selectByVisibleText("iphone");  //通过文本值来选择
        Thread.sleep(1000);
    }
    @AfterMethod
    public void quitChorme() {
        driver.quit();
    }
}
