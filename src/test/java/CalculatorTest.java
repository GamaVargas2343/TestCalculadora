import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTest {
    WebDriver driver;

    @BeforeMethod
    public void inicio() {
        driver = new EdgeDriver();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
    }
    @DataProvider(name = "DatosCalculadora")
    public Object[][] obtenerDatos() {
        return new Object[][]{
                {"5", "3", "Add", "8"},
                {"10", "4", "Subtract", "6"},
                {"7", "8", "Multiply", "56"},
                {"20", "5", "Divide", "4"},
                {"12", "34", "Concatenate", "1234"}
        };
    }

    @Test(dataProvider = "DatosCalculadora")
    public void testOperaciones(String num1, String num2, String operacion, String esperado) {
        WebElement number1 = driver.findElement(By.id("number1Field"));
        WebElement number2 = driver.findElement(By.id("number2Field"));
        WebElement dropdown = driver.findElement(By.id("selectOperationDropdown"));
        WebElement boton = driver.findElement(By.id("calculateButton"));
        WebElement resultado = driver.findElement(By.id("numberAnswerField"));

        number1.clear();
        number1.sendKeys(num1);

        number2.clear();
        number2.sendKeys(num2);

        dropdown.sendKeys(operacion);
        boton.click();

        String valor = resultado.getAttribute("value");
        System.out.println("Resultado de " + num1 + " " + operacion + " " + num2 + " = " + valor);

        Assert.assertEquals(valor, esperado, "El resultado no coincide");

    }

    @AfterMethod
    public void cerrar() {
        driver.quit();
    }
}
