import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CalculatorPage;
import utils.waithelper;

public class CalculatorTest {

    WebDriver driver;
    CalculatorPage page;

    @BeforeMethod
    public void inicio() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        page = new CalculatorPage(driver); //
    }
'Dataprovider'
    @DataProvider(name = "DatosCalculadora")
    public Object[][] obtenerDatos() {
        return new Object[][]{
                {"5", "3", "Add", "8"},
                {"10", "4", "Subtract", "6"},
                {"6", "7", "Multiply", "42"},
                {"20", "5", "Divide", "4"},
                {"9", "2", "Concatenate", "92"}
        };
    }

    @Test(dataProvider = "DatosCalculadora")
    public void testCalculadora(String num1, String num2, String operacion, String resultadoEsperado) {
        page.ingresarNumeros(num1, num2);
        page.seleccionarOperacion(operacion);
        page.calcular();

        String resultado = page.obtenerResultado();
        Assert.assertEquals(resultado, resultadoEsperado,
                "Error en la operación: " + operacion);
    }

    @AfterMethod
    public void cerrar() {
        if (driver != null) {
            driver.quit();
        }
    }
}
