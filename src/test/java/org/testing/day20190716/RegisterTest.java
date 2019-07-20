package org.testing.day20190716;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegisterTest {
    //document.getElementById("kw").setAttribute("value","webdriver")
    private WebDriver driver;

    @BeforeMethod
    public void openChorme() {
        System.setProperty("webdriver.chrome.driver", "D:\\deaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //延时等待 全局等待
        driver.get("https://mail.163.com/");
    }

    @AfterMethod
    public void quitChorme() throws InterruptedException {
        Thread.sleep(1000);  //线程等待
        driver.quit();

    }

    /**
     * 打开163 首页
     * 点击注册
     * 进行一次失败的注册
     * @throws InterruptedException
     */
    @Test
    public void regeister163() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"appLoginTab\"]/div[3]/a[2]")).click();
        String handlel = driver.getWindowHandle();  //获取当前driver 所在的 handle值
        for (String handles :
                driver.getWindowHandles()) {
            if (handles.equals(handlel)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
        String time = String.valueOf(System.currentTimeMillis()/100);  //时间戳
        driver.findElement(By.xpath("//*[@id=\"nameIpt\"]")).sendKeys("email"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.id("vcodeIpt")).sendKeys("1234");
        Thread.sleep(1000);
        driver.findElement(By.id("mainMobileIpt")).sendKeys("15723345676");
        Thread.sleep(1000);
        driver.findElement(By.id("mainAcceptIpt")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("mainRegA")).click();
    }

    @Test
    public void regeister163Test() throws InterruptedException {
        //   driver.get("https://reg.mail.163.com/unireg/call.do?cmd=register.entrance&from=163mail_right");
        driver.findElement(By.xpath("//*[@id=\"appLoginTab\"]/div[3]/a[2]")).click();
        String handlel = driver.getWindowHandle();  //获取当前driver 所在的 handle值
        for (String handles :
                driver.getWindowHandles()) {
            if (handles.equals(handlel)) {
                continue;
            }
            driver.switchTo().window(handles);
        }
        String time = String.valueOf(System.currentTimeMillis());  //时间戳
        driver.findElement(By.xpath("//*[@id=\"nameIpt\"]")).sendKeys("123456");
        driver.findElement(By.id("mainPwdIpt")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.id("vcodeIpt")).sendKeys("1234");
        Thread.sleep(1000);
        driver.findElement(By.id("mainMobileIpt")).sendKeys("15723345676");
        Thread.sleep(1000);
        driver.findElement(By.id("mainAcceptIpt")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("mainRegA")).click();
    }

}
