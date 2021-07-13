package TestCase;


import base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagelibraries.LoginPageLib;
import pageobjects.HomePagePO;
import pageobjects.LoginPagePO;
import pageobjects.PortalPagePO;

import java.io.IOException;

public class LoginTest extends Base {
    private static final Logger log = LogManager.getLogger();


    @BeforeClass
    public void beforeClass() throws IOException {
        //调用base类的方法
        startBrowser();
        log.info("中文版日志信息-成功启动浏览器");
    }
    @Test
    public void LoginTest() throws IOException {
        //因为只能继承一个父类所以只能new一个对象来继承PO的方法
        //1.先去homepage点登陆按钮
        HomePagePO homePage = new HomePagePO(driver);
        homePage.loginBtn().click();
        //等待时间
        WebDriverWait wait = new WebDriverWait(driver,60);
        LoginPagePO loginpage = new LoginPagePO(driver);
        wait.until(ExpectedConditions.elementToBeClickable(loginpage.summitButton()));
        //2.登陆操作
        LoginPageLib loginPagelib = new LoginPageLib(driver);
        loginPagelib.login();
        log.info("成功登陆");
        //assert
        PortalPagePO portalPagePO = new PortalPagePO(driver);
        String btnText = portalPagePO.inviteBtn().getText();
//        System.out.println(btnText);
        //成功or失败时在日志里的的表现 如果只用try-catch的话 testng就判定不了失败了 所以在catch失败的时候要让用例fail
        try{
            Assert.assertEquals("邀请",btnText);
            log.info("断言通过");
        }catch (AssertionError e){
            log.error("断言失败"+ e);
            Assert.fail("断言失败"+ e);
        }

    }
    @AfterClass
    public void afterClass() {
        //退出浏览器
        driver.quit();
    }
}
