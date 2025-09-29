package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage {
    WebDriver driver;

    // Localizadores
    private By number1Field = By.id("number1Field");
    private By number2Field = By.id("number2Field");
    private By operationDropdown = By.id("selectOperationDropdown");
    private By calculateButton = By.id("calculateButton");
    private By resultField = By.id("numberAnswerField");

    // Constructor
    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    // Métodos de acción
    public void ingresarNumeros(String num1, String num2) {
        WebElement number1 = driver.findElement(number1Field);
        WebElement number2 = driver.findElement(number2Field);
        number1.clear();
        number1.sendKeys(num1);
        number2.clear();
        number2.sendKeys(num2);
    }

    public void seleccionarOperacion(String operacion) {
        Select dropdown = new Select(driver.findElement(operationDropdown));
        dropdown.selectByVisibleText(operacion);
    }

    public void calcular() {
        driver.findElement(calculateButton).click();
    }

    public String obtenerResultado() {
        return driver.findElement(resultField).getAttribute("value");
    }
}
