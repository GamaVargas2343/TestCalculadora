package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waithelper {

    private WebDriverWait wait;

    // Constructor
    public waithelper(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // Esperar a que un elemento sea clickeable
    public WebElement esperarElementoClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


}
