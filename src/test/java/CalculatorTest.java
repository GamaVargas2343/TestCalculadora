import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import utils.reporteHelper;
import pages.CalculatorPage;

import java.lang.reflect.Method;

public class CalculatorTest {

    WebDriver driver;
    CalculatorPage page;
    ExtentTest test;
    @BeforeMethod
    public void inicio(Method metodo) {
        driver = new EdgeDriver();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        page = new CalculatorPage(driver);
        test=reporteHelper.crearTest(metodo.getName());

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
        test.log(Status.INFO,"Se digíto correctamente el número: "+num1 + " y el numero : "+num2 );
        page.seleccionarOperacion(operacion);
        test.log(Status.INFO,"Se seleccionó: " +operacion);
        page.calcular();
        test.log(Status.INFO,"Se le dio click al botón calcular");

        String resultado = page.obtenerResultado();
        Assert.assertEquals(resultado, resultadoEsperado,
                "Error en la operación: " + operacion);
    }

    @AfterMethod
    public void cerrar() {

            driver.quit();

    }
    @AfterSuite
    public void cerrarReporte(){
        reporteHelper.generarReporte();
    }

}
