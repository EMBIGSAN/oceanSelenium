package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePO {
    //写页面元素 返回值是那个元素的对象 webelement对象
    public WebDriver driver;
    //username输入框
    By username = By.id("username");
    //password输入框
    By password = By.id("password");
    //login button
    By summitButton = By.xpath("//*[@id=\"loginForm\"]/div[5]/button");
    //构造函数 对driver从base里生成对象后传递过来
    public LoginPagePO(WebDriver driver) {
        //this这个是当前类的 后面的是base传过来的参数
        this.driver = driver;
    }

    //定义输入框和按钮等对应方法
    public WebElement usernameTextbox() {
        return driver.findElement(username);
    }

    public WebElement passwordTextbox() {
        return driver.findElement(password);
    }

    public WebElement summitButton() {
        return driver.findElement(summitButton);
    }
}
