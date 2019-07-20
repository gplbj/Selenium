package org.testing.day20190717;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class sendEmail {
    private WebDriver driver;

    @BeforeMethod
    public void openChorme() {
        System.setProperty("webdriver.chrome.driver", "D:\\deaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //延时等待 全局等待
        driver.get("https://mail.qq.com/");
    }

    @AfterMethod
    public void quitChorme() throws InterruptedException {
        Thread.sleep(3000);  //线程等待
        driver.quit();

    }

    /**
     * 邮箱登录
     *
     * @param driver 驱动
     * @param email  用户名
     * @param pwd    密码
     */
    public void login(WebDriver driver, String email, String pwd) {
        driver.switchTo().frame("login_frame");
        driver.findElement(By.id("switcher_plogin")).click();
        driver.findElement(By.id("u")).clear();
        driver.findElement(By.id("u")).sendKeys(email);
        driver.findElement(By.id("p")).clear();
        driver.findElement(By.id("p")).sendKeys(pwd);
        driver.findElement(By.id("login_button")).click();
    }

    @Test
    public void sendEmail() {
        login(driver, "2602251350@qq.com", "gxl123456789");
        driver.findElement(By.id("composebtn")).click();
        driver.switchTo().frame(driver.findElement(By.id("mainFrame"))); //控制权转交
        WebElement address = driver.findElement(By.xpath("//*[@id=\"toAreaCtrl\"]")); //定位收件人地址
        Actions actions = new Actions(driver);
        actions.moveToElement(address).sendKeys("260225130").perform();  //因为是一个div 不是文本框 不能直接对 元素进行sendkeys 所以需要将鼠标移到该元素上面
        driver.findElement(By.xpath("//*[@title=\"主题是一封邮件的标题，可不填。\"]")).sendKeys("自动化测试发送邮件");
        driver.findElement(By.xpath("//*[@title=\"添加小于 50M 的文件作为附件\"]/span/input")).sendKeys("C:\\Users\\GPLBJ\\Desktop\\2.gif");
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#QMEditorArea iframe")));  //iframe转交
        driver.findElement(By.tagName("body")).sendKeys("你好!");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("mainFrame")));
        driver.findElement(By.xpath(".//*[text()='发送']")).click();  //通过文本内容 进行xpath定位
    }

    @Test
    public void sendEmail2() {
        login(driver, "2602251350@qq.com", "gxl123456789");
        driver.findElement(By.id("composebtn")).click();
        driver.switchTo().frame(driver.findElement(By.id("mainFrame")));
        WebDriver d1 = driver.switchTo().frame(driver.findElement(By.cssSelector("div#QMEditorArea iframe")));  //iframe转交
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("mainFrame")));
      //  driver.findElement(By.name("sendbtn")).click();
      driver.findElement(By.xpath(".//*[text()='发送']")).click();  //通过文本内容 进行xpath定位

    }

    /**
     * 邮件发送封装
     */
    public void sendQQEmailUtil(String sendEmail,String pwd,String receiverQQ,String filePath,String theme,String context) {
        login(driver, sendEmail, pwd); //进行登录
        driver.findElement(By.id("composebtn")).click();
        driver.switchTo().frame(driver.findElement(By.id("mainFrame"))); //控制权转交
        WebElement address = driver.findElement(By.xpath("//*[@id=\"toAreaCtrl\"]")); //定位收件人地址
        Actions actions = new Actions(driver);
        actions.moveToElement(address).sendKeys(receiverQQ).perform();  //因为是一个div 不是文本框 不能直接对 元素进行sendkeys 所以需要将鼠标移到该元素上面
        driver.findElement(By.xpath("//*[@title=\"主题是一封邮件的标题，可不填。\"]")).sendKeys("自动化测试发送邮件");
        driver.findElement(By.xpath("//*[@title=\"添加小于 50M 的文件作为附件\"]/span/input")).sendKeys(filePath);
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#QMEditorArea iframe")));  //iframe转交
        driver.findElement(By.tagName("body")).sendKeys("你好!");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("mainFrame")));
        driver.findElement(By.xpath(".//*[text()='发送']")).click();  //通过文本内容 进行xpath定位
        String success=driver.findElement(By.id("sendinfomsg")).getText();
        Assert.assertEquals(success,"您的邮件已发送");
    }

    @Test
    public void send(){
        sendQQEmailUtil("2602251350@qq.com","gxl123456789","2437044740","C:\\Users\\GPLBJ\\Desktop\\22.gif","傻丫头 考研加油啊","这是我近些天来自学的成果啊 这个邮件是自动发送的 我这么慵懒的一个人都用心了 你也要加油啊!!");
    }
}
