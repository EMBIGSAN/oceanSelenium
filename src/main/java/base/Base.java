package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//全局变量来起浏览器 兼容性测试
public class Base {
    public WebDriver driver;

    //定义启动浏览器方法
    public void startBrowser() throws IOException {
        //首先要做的是从磁盘上读取全局配置文件
        FileInputStream file = new FileInputStream("Configs/GlobalData.properties");
        //创建对象 读取配置文件的内容
        Properties prop = new Properties();
        prop.load(file);
        //读取配置文件里面配置的值
        String browser = prop.getProperty("browser");
        //获取url
        String url = prop.getProperty("eteams_url");
        //驱动路径
        String driverpath = "F:/Python27/";//不写具体名是因为后面可以搭


        if (browser.equals("chrome")) {
            //启动谷歌浏览器
            System.setProperty("webdriver.chrome.driver", driverpath + "chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            //启动火狐浏览器
            System.setProperty("webdriver.gecko.driver", driverpath + "火狐驱动路径");
            driver = new FirefoxDriver();
        } else if (browser.equals("IE")) {
            //启动IE浏览器
            System.setProperty("webdriver.ie.driver", driverpath + "IE驱动路径");
            driver = new InternetExplorerDriver();
        }
        //访问首页操作也是base类
        driver.get(url);
        //最大化窗口
        driver.manage().window().maximize();
        //全局隐式等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //    //截图方法
//    public void takeScreenshot(String screenshotname,WebDriver driver) throws IOException {
//        //对象是通过使用webdriver对象转型得到的 因为take是web的子类 不转型会不提供方法
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        //截图保存文件(临时文件)
//        File srcFile = ts.getScreenshotAs(OutputType.FILE);
//        //设定路径保存在项目下 相对路径
//        //user.dir是当前项目在电脑上的具体路径 是具体到这个项目的文件路径
//        File desFile = new File(System.getProperty("user.dir")+"//Screenshots//"+screenshotname+".png");
//        //把src的文件覆盖到des里面
//        FileHandler.copy(srcFile,desFile);
//
//
//    }
    public void takeScreenshot(String screenshotname, WebDriver driver) throws IOException {

        //定义TakesScreenshot引用变量，将当前的driver实例转型为TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        //调用getScreenshotAs方法实现截图，截图保存在临时文件夹中
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        //指定截图文件永久保存的路径
        File desFile = new File(System.getProperty("user.dir") + "//Screenshots//" + screenshotname + ".png");

        //将截图文件复制到指定的路径
        FileHandler.copy(srcFile, desFile);


    }

}
