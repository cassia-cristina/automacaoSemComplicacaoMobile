package br.com.chronosAcademy.appium.calculator;

import br.com.chronosAcademy.appium.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class Calculadora {

    @AndroidFindBy(id = "digit_0")
    public MobileElement dig0;

    @AndroidFindBy(id = "digit_1")
    public MobileElement dig1;

    @AndroidFindBy(id = "digit_2")
    public MobileElement dig2;

    @AndroidFindBy(id = "digit_7")
    public MobileElement dig7;

    @AndroidFindBy(id = "digit_9")
    public MobileElement dig9;

    @AndroidFindBy(id = "op_mul")
    public MobileElement mult;

    @AndroidFindBy(id = "op_add")
    public MobileElement soma;

    @AndroidFindBy(id = "op_sub")
    public MobileElement sub;

    @AndroidFindBy(id = "op_div")
    public MobileElement div;

    @AndroidFindBy(id = "eq")
    public MobileElement eq;

    @AndroidFindBy(id = "result")
    public MobileElement result;

    public Calculadora(DriverFactory driverFactory) {
        PageFactory.initElements(new AppiumFieldDecorator(driverFactory.getDriver()), this);
    }

    public int multiplicacao() {
        dig7.click();
        mult.click();
        dig9.click();
        eq.click();
        String resultado = result.getText();
        return Integer.parseInt(resultado);
    }

    public int soma() {
        dig7.click();
        soma.click();
        dig9.click();
        eq.click();
        String resultado = result.getText();
        return Integer.parseInt(resultado);
    }

    public int subtracao() {
        dig9.click();
        sub.click();
        dig7.click();
        eq.click();
        String resultado = result.getText();
        return Integer.parseInt(resultado);
    }

    public int divisao() {
        dig1.click();
        dig0.click();
        dig0.click();
        div.click();
        dig2.click();
        eq.click();
        String resultado = result.getText();
        return Integer.parseInt(resultado);
    }

}