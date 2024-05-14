import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.CalculatorPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class CalculatorTests {
    private CalculatorPage calculatorPage;

    @BeforeClass
    public void setUp() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("chrome.properties"));
        Configuration.browserSize = System.getProperties().getProperty("webdriver.browser.size");
        Configuration.browser = System.getProperties().getProperty("webdriver.browser.name");
        Configuration.timeout = Long.parseLong(System.getProperties().getProperty("webdriver.timeoutSeconds")) * 1000;
        Configuration.pollingInterval = Integer.parseInt(System.getProperties().getProperty("polling.timeoutMs"));
        WebDriverManager.chromedriver().setup();
        open("https://ecalc.ru/simple/");
        calculatorPage = new CalculatorPage();
    }

    @Test
    public void testAddition() {
        calculatorPage.performCalculation("5", "+", "3");
        assertEquals(calculatorPage.getResult(), "8");
        sleep(2000);
        calculatorPage.clear();
    }

    @Test
    public void testDivision() {
        calculatorPage.performCalculation("8", "/", "2");
        assertEquals(calculatorPage.getResult(), "4");
        sleep(2000);
        calculatorPage.clear();
    }

    @Test
    public void testMultiplication() {
        calculatorPage.performCalculation("7", "*", "6");
        assertEquals(calculatorPage.getResult(), "42");
        sleep(2000);
        calculatorPage.clear();
    }

    @Test
    public void testSubtraction() {
        calculatorPage.performCalculation("9", "-", "4");
        assertEquals(calculatorPage.getResult(), "5");
        sleep(2000);
        calculatorPage.clear();
    }
}