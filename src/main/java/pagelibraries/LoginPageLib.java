package pagelibraries;

import org.openqa.selenium.WebDriver;
import pageobjects.LoginPagePO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//登陆公共类 可复用
public class LoginPageLib extends LoginPagePO {
    //因为父类有定义构造方法 子类也要定义本类的构造方法
    public LoginPageLib(WebDriver driver) {
        super(driver);
    }
    public void login() throws IOException {
        //获取properties配置文件内容
        FileInputStream file = new FileInputStream("Configs/GlobalData.properties");
        //创建对象 读取配置文件的内容
        Properties prop = new Properties();
        prop.load(file);

        //获取用户名等信息
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");


        usernameTextbox().sendKeys(username);
        passwordTextbox().sendKeys(password);
        summitButton().click();
    }
}
