package page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalculatorPage {
    public void clickButton(String button) {
        $x(String.format("//button[@value='%s']", button)).click();
    }

    public void clickEqual() {
        $x("//button[@class='calculator__key calculator__key--equal equal__button']").click();
    }


    public String getResult() {
        return $(".calculator__display").getAttribute("value");
    }

    public void performCalculation(String num1, String operation, String num2) {
        clickButton(num1);
        clickButton(operation);
        clickButton(num2);
        clickEqual();
    }

    public void clear() {
        $x("//button[@class='calculator__key calculator__clear del__button']").click();
    }
}
