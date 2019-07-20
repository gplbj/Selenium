package org.testing.day20190715;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AcitonsTest {
    private WebDriver driver;

    @BeforeMethod
    public void openChorme() {
        System.setProperty("webdriver.chrome.driver", "D:\\deaProjects\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //延时等待 全局等待

    }

    @AfterMethod
    public void quitChorme() throws InterruptedException {
        Thread.sleep(1000);  //线程等待
        driver.quit();
    }
    /**
     * 打开百度首页
     * 在百度一下按钮上右键
     */
    @Test
    public void rightClickTest(){
        driver.get("https://www.baidu.com/");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        //实例化Actions
        Actions actions = new Actions(driver);
        //在百度一下按钮 右键
        actions.contextClick(buttonBaidu).perform();
    }
    /**
     * 打开百度页面
     * 双击百度一下按钮
     */
    @Test
    public void doubleClickTest() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.doubleClick(buttonBaidu).perform();  //不传参数 在当前位置做双击
    }
    /**
     * 打开测试页面
     * 鼠标移动到 action 按钮
     * 那么显示 hello world
     */
    @Test
    public void moveToElementTest() throws InterruptedException {
        driver.get("file:///D:/deaProjects/Selenium/.idea/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(2000);
        String hello = driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        Assert.assertEquals(hello,"Hello World!");

    }
    /**
     * 打开测试页面
     * 进行元素拖动操作
     */
    @Test
    public void testDrop() throws InterruptedException {
        driver.get("D:\\deaProjects\\Selenium\\.idea\\selenium_html\\dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.dragAndDropBy(element,500,500).perform();  //后面两个参数指的是元素的位置


    }
    /**
     * 打开测试页面
     * 把方框拖在文字上面
     *   步骤:
     *      1:点击fangkaung
     *      2 拖动
     *      3 松开
     */
    @Test
    public void testDrop2() throws InterruptedException {
        driver.get("D:\\deaProjects\\Selenium\\.idea\\selenium_html\\dragAndDrop.html");
        WebElement e1 = driver.findElement(By.xpath("//*[@id=\"drag\"]"));
        WebElement e2 = driver.findElement(By.xpath("/html/body/h1"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.clickAndHold(e1)
                .moveToElement(e2)
                .release(e1)
                .perform();
    }
    /**
     * 打开百度页面
     * 保存当前页面 模拟 Ctrl+s
     * 按住 enter 建进行确定
     */
    @Test
    public void saveHtml() throws AWTException, InterruptedException {
        driver.get("https://www.baidu.com/");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL); //按下 ctrl键 keyPress()方法传值为 ASCII码
        int keyS = (int)new Character('S');
        robot.keyPress(keyS);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER); //按下 enter 键
        robot.keyRelease(KeyEvent.VK_CONTROL); //释放 ctrl 键
    }
    /**
     * 打开测试界面
     * 进行文件上传
     */
    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("D:\\deaProjects\\Selenium\\.idea\\selenium_html\\index.html");
        driver.findElement(By.id("load"))
                .sendKeys("C:\\Users\\GPLBJ\\Desktop\\3.png");
        Thread.sleep(5000);
    }
}
