package TestCase;

import base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.BaiduPagePO;
import pageobjects.ResultPagePO;

import java.io.IOException;

public class SearchTest extends Base {
    private static final Logger log = LogManager.getLogger();
    @BeforeClass
    public void beforeClass() throws IOException {
        startBrowser();
        log.info("中文版日志信息-成功启动浏览器");
    }
    @Test
    public void searchTest(){
        //中途想换链接的时候可以直接get
        driver.get("https://www.baidu.com");
        BaiduPagePO baiduPagePO = new BaiduPagePO(driver);
        baiduPagePO.textBox().sendKeys("Selenium");
        baiduPagePO.search().click();
//        log.info("成功登陆");

        ResultPagePO resultPagePO = new ResultPagePO(driver);
//        Assert.assertEquals("百度首页",resultPagePO.Home().getText());
        //让用例失败 测试失败截图

        try{
            Assert.assertEquals("百度首页1",resultPagePO.Home().getText());
            log.info("断言通过");
        }catch (AssertionError e){
            log.error("断言失败"+ e);
            Assert.fail("断言失败"+ e);
        }

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
