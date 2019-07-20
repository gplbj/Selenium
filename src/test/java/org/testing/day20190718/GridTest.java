package org.testing.day20190718;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        //创建 一个 DesiredCapabilities 对象
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //实例化 一个 driver
        WebDriver driver = new RemoteWebDriver(new URL("http://10.12.2.21:5557/wd/hub"), dc);
        driver.get("https://www.baidu.com/");
        Thread.sleep(1000);
        driver.quit();
    }

    @DataProvider(name = "data4")
    public Object[][] test1() {
        return new Object[][]{
                {"phantomjs"},
                {"chrome"},
                {"firefox"}
        };
    }
    @Test(dataProvider = "data4")
    public void testGrid2(String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = null;
        if (browser.contentEquals("phantomjs")){
            dc = DesiredCapabilities.phantomjs();
        } else if (browser.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else if (browser.equals("firefox")){
            System.setProperty("webdriver.firefox.bin","F:\\FireFox47\\firefox.exe");
            dc = DesiredCapabilities.chrome();
        }else {
            System.err.println("error");
        }
        WebDriver driver = new RemoteWebDriver(new URL("http://10.12.2.21:5557/wd/hub"), dc);
        driver.get("https://www.baidu.com/");
        Thread.sleep(1000);
        driver.quit();
    }
}
