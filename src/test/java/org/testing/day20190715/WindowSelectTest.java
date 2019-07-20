package org.testing.day20190715;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowSelectTest {
    private WebDriver driver;

    @BeforeMethod
    public void openChorme() {
        System.setProperty("webdriver.chrome.driver", "D:\\deaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开测试页面
     * 点击open new window
     * 点击百度
     */
    @Test
    public void windowTest() throws InterruptedException {
        driver.get("file:///D:/deaProjects/Selenium/.idea/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
        String handle = driver.getWindowHandle();  //获取当前句柄
        System.out.println("当前句柄是" + handle);
        for (String handles :
                driver.getWindowHandles()) {
        if(handles.equals(handle)){
            continue;
        }else {
            driver.switchTo().window(handles);
        }
        }
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(1000);
    }

    @AfterMethod
    public void quitChorme() {
        driver.quit();
    }
}
