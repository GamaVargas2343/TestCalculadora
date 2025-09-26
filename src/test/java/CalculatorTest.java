import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class CalculatorTest {
    WebDriver driver;

    @BeforeMethod
    public void inicio() {
        driver = new EdgeDriver();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
    }

    @Test
    public void testSuma() {
        WebElement number1 = driver.findElement(By.id("number1Field"));
        WebElement number2 = driver.findElement(By.id("number2Field"));
        WebElement dropdown = driver.findElement(By.id("selectOperationDropdown"));
        WebElement boton = driver.findElement(By.id("calculateButton"));
        WebElement resultado = driver.findElement(By.id("numberAnswerField"));

        number1.sendKeys("5");
        number2.sendKeys("3");

        // seleccionamos la opción "Add" del dropdown
        dropdown.sendKeys("Add");

        boton.click();

        String valor = resultado.getAttribute("value");
        System.out.println("Resultado suma: " + valor);
    }

    @Test
    public void testResta() {
        WebElement number1 = driver.findElement(By.id("number1Field"));
        WebElement number2 = driver.findElement(By.id("number2Field"));
        WebElement dropdown = driver.findElement(By.id("selectOperationDropdown"));
        WebElement boton = driver.findElement(By.id("calculateButton"));
        WebElement resultado = driver.findElement(By.id("numberAnswerField"));

        number1.sendKeys("10");
        number2.sendKeys("4");

        dropdown.sendKeys("Subtract");

        boton.click();

        String valor = resultado.getAttribute("value");
        System.out.println("Resultado resta: " + valor);
    }
    @Test
    public void testMultiplicar() {
        WebElement number1 = driver.findElement(By.id("number1Field"));
        WebElement number2 = driver.findElement(By.id("number2Field"));
        WebElement dropdown = driver.findElement(By.id("selectOperationDropdown"));
        WebElement boton = driver.findElement(By.id("calculateButton"));
        WebElement resultado = driver.findElement(By.id("numberAnswerField"));

        number1.sendKeys("5");
        number2.sendKeys("3");

        // seleccionamos la opción "Multiply" del dropdown
        dropdown.sendKeys("Multiply");

        boton.click();

        String valor = resultado.getAttribute("value");
        System.out.println("Resultado multiplicar: " + valor);
    }
    @Test
    public void testDividir() {
        WebElement number1 = driver.findElement(By.id("number1Field"));
        WebElement number2 = driver.findElement(By.id("number2Field"));
        WebElement dropdown = driver.findElement(By.id("selectOperationDropdown"));
        WebElement boton = driver.findElement(By.id("calculateButton"));
        WebElement resultado = driver.findElement(By.id("numberAnswerField"));

        number1.sendKeys("10");
        number2.sendKeys("2");

        // seleccionamos la opción "Divide" del dropdown
        dropdown.sendKeys("Divide");

        boton.click();

        String valor = resultado.getAttribute("value");
        System.out.println("Resultado dividir: " + valor);
    }
    @Test
    public void testCombinar() {
        WebElement number1 = driver.findElement(By.id("number1Field"));
        WebElement number2 = driver.findElement(By.id("number2Field"));
        WebElement dropdown = driver.findElement(By.id("selectOperationDropdown"));
        WebElement boton = driver.findElement(By.id("calculateButton"));
        WebElement resultado = driver.findElement(By.id("numberAnswerField"));

        number1.sendKeys("5");
        number2.sendKeys("3");

        // seleccionamos la opción "Concatenate" del dropdown
        dropdown.sendKeys("Concatenate");

        boton.click();

        String valor = resultado.getAttribute("value");
        System.out.println("Combinacion: " + valor);
    }
    @AfterMethod
    public void cerrar() {
        driver.quit();
    }
}
