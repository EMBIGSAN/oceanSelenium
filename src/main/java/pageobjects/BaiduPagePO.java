package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaiduPagePO {
    public WebDriver driver;

    By searchText = By.id("kw");

    By searchBtn = By.id("su");

    public BaiduPagePO(WebDriver driver){
        this.driver = driver;
    }

    public WebElement textBox(){
        return driver.findElement(searchText);
    }

    public WebElement search(){
        return driver.findElement(searchBtn);
    }
}
