package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalPagePO {
    public WebDriver driver;

    By invite = By.id("invite-m-submit");

    public PortalPagePO(WebDriver driver){
        this.driver = driver;
    }

    public WebElement inviteBtn(){
        return driver.findElement(invite);
    }
}
