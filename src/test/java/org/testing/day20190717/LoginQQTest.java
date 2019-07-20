package org.testing.day20190717;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import po.page.LoginQQPage;

import java.util.concurrent.TimeUnit;


public class LoginQQTest {
    private WebDriver driver;

    @BeforeMethod
    public void openChorme() {
        System.setProperty("webdriver.chrome.driver", "D:\\deaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.qq.com/");
    }

    @AfterMethod
    public void quitChorme() throws InterruptedException {
        Thread.sleep(1000);  //线程等待
        driver.quit();

    }

    /**
     * 打开qq邮箱首页
     * 进行qq邮箱登录
     * 登录进去后点击退出按钮
     */
    @Test
    public void loginQQTest() {
        login(driver,"2602251350@qq.com", "gxl123456789");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出"))); //智能等待
        driver.findElement(By.linkText("退出")).click();
    }

    /**
     * 打开qq邮箱
     * 进行邮箱错误登录
     * 获取提示的错误信息 并进行校验
     */
    @Test
    public void loginError() {
        login(driver,"2602251350@qq.com", "gxl123456789");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("err_m")));
        String error = driver.findElement(By.id("err_m")).getText();
        System.out.println(error);
        //  Assert.assertEquals(error,"你输入的账号或密码不正确,请重新输入。");
    }

    public void login(WebDriver driver,String email, String pwd) {
        driver.switchTo().frame("login_frame");
        driver.findElement(By.id("switcher_plogin")).click();
        driver.findElement(By.id("u")).clear();
        driver.findElement(By.id("u")).sendKeys(email);
        driver.findElement(By.id("p")).clear();
        driver.findElement(By.id("p")).sendKeys(pwd);
        driver.findElement(By.id("login_button")).click();
    }

    /**
     * 加入常量池之后的登录方法
     * @param driver webdriver
     * @param email 邮箱
     * @param pwd 密码
     */
    public void login1(WebDriver driver,String email, String pwd) {
        driver.switchTo().frame(LoginQQPage.LOGIN_FRAME);
        driver.findElement(LoginQQPage.SWITCHER_PLOGIN).click();
        driver.findElement(LoginQQPage.YHM).clear();
        driver.findElement(LoginQQPage.YHM).sendKeys(email);
        driver.findElement(LoginQQPage.PWD).clear();
        driver.findElement(LoginQQPage.PWD).sendKeys(pwd);
        driver.findElement(LoginQQPage.DL_BUTTON).click();
    }
}
