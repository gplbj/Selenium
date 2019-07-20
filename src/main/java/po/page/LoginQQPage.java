package po.page;

import org.openqa.selenium.By;

/***
 * QQ邮箱登录工具类
 */
public class LoginQQPage {
    public static String QQYX_URL = "https://mail.qq.com/"; //qq邮箱url
    public static String LOGIN_FRAME = "login_frame";  //登录时要进入的iframe
    public static By SWITCHER_PLOGIN = By.id("switcher_plogin");//登录时要点击的账号密码登录
    public static By YHM = By.id("u"); //用户名
    public static By PWD = By.id("p");  //密码
    public static By DL_BUTTON = By.id("login_button");  //登录按钮
}
