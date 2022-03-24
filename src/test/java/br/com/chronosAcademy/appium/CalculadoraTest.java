package br.com.chronosAcademy.appium;

import br.com.chronosAcademy.appium.calculator.Calculadora;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class CalculadoraTest {
    public DriverFactory driverFactory;
    Map<String, String> map;
    Calculadora calculadora;

    @BeforeEach
    public void inicializaDriver() throws MalformedURLException {
        driverFactory = new DriverFactory();
        map = new HashMap<>();
        map.put("platform", "Android");
        map.put("device", "emulator:5554");
        map.put("automation", "uiautomator2");
        map.put("appPackage", "com.android.calculator2");
        map.put("appActivity", "com.android.calculator2.Calculator");
        driverFactory.setCapabilities(map);
        driverFactory.setDriver();
        calculadora = new Calculadora(driverFactory);
    }

    @Test
    public void validaMultiplicacao() {
        assertEquals(63, calculadora.multiplicacao());
    }

    @Test
    public void validaSoma(){
        assertEquals(16, calculadora.soma());
    }

    @Test
    public void validaSubtracao(){
        assertEquals(2, calculadora.subtracao());
    }

    @Test
    public void validaDivisao(){
       assertEquals(50, calculadora.divisao());
    }

    @AfterEach
    public void finalizarConexao(){
        driverFactory.getDriver().quit();
    }

}