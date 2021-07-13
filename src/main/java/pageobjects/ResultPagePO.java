package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPagePO {
    public WebDriver driver;

    By homeBtn = By.xpath("//*[@id=\"u\"]/a[1]");

    public ResultPagePO(WebDriver driver){
        this.driver = driver;
    }

    public WebElement Home(){
        return driver.findElement(homeBtn);
    }
}
