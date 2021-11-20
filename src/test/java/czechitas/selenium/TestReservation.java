package czechitas.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestReservation {

    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
//      System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/Java-Training/Selenium/geckodriver");
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    }

    @Test
    public void UzivatelSeMusiBytSchopenPrepnoutNaCeskyJazyk() {
        prohlizec.navigate().to("http://czechitas-datestovani-hackathon.cz/cs/");

        WebElement clickLanguage = prohlizec.findElement(By.className("hide_xs"));
        clickLanguage.click();



 //        Assertions.assertNotNull(prohlizec.findElement(By.xpath("//h1[text() = 'My account']")));

    }




//        prohlizec.close();


}
