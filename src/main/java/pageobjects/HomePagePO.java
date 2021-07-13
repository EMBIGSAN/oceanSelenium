package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePagePO {
    public WebDriver driver;
    By loginBtn = By.id("top-btn-login");
    public HomePagePO(WebDriver driver){
        this.driver = driver;
    }
    public WebElement loginBtn(){
        return driver.findElement(loginBtn);
    }
}
