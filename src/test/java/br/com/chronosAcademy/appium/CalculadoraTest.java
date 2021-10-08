package br.com.chronosAcademy.appium;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;


public class CalculadoraTest {
    public DriverFactory driverFactory;

    @BeforeEach
    public void inicializaDriver() throws MalformedURLException {
        driverFactory = new DriverFactory();
        driverFactory.setCapabilities("Android","CassiaDevice","uiautomator2",
                "com.android.calculator2","com.android.calculator2.Calculator");
        driverFactory.setDriver();
    }

    @Test
    public void validarMultiplicacao() throws MalformedURLException {
        click("digit_7");
        click("op_mul");
        click("digit_9");
        click("eq");
        String resultado = getText("result");
        assertEquals("63",resultado);
    }

    @Test
    public void validarSoma(){
        click("digit_7");
        click("op_add");
        click("digit_9");
        click("eq");
        String resultado = getText("result");
        assertEquals("16",resultado);
    }

    @Test
    public void validarSubtracao(){
        click("digit_9");
        click("op_sub");
        click("digit_7");
        click("eq");
        String resultado = getText("result");
        assertEquals("2",resultado);
    }

    @Test
    public void validarDivisao(){
        click("digit_1");
        click("digit_0");
        click("digit_0");
        click("op_div");
        click("digit_2");
        click("eq");
        String resultado = getText("result");
        assertEquals("50",resultado);
    }

    public void click(String id){
        driverFactory.getDriver().findElement(MobileBy.id(id)).click();
    }
    public String getText(String id) { return driverFactory.getDriver().findElement(MobileBy.id(id)).getText(); }

    @AfterEach
    public void finalizarConexao(){
        driverFactory.getDriver().quit();
    }

}