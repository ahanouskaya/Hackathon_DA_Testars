package czechitas.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestLogIn {

    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
    }

    @Test
    public void uzivatelSeMusiBytSchopenSeZaregistrovat() throws InterruptedException {

        prohlizec.navigate().to("http://czechitas-datestovani-hackathon.cz/en/");

        WebElement clickPrihlaseni = prohlizec.findElement(By.className("hide_xs"));
        clickPrihlaseni.click();
        vyplnEmailRegistraci("ahanouski@yahoo.com");//idealne bych tady mel byt generator nahodych email, ale to bohuzel nestiham casove!
        buttonSubmitCreate();
        Thread.sleep(6000);// Musi cekat dokut se nenacita stranka
        vyplnFirstNameRegistraci("Viktoria");
        vyplnLastNameRegistraci("Ahanouski");
        vyplnPasswordRegistrace("Ovechkin8");
        buttonRegister();

        Assertions.assertNotNull(prohlizec.findElement(By.xpath("//h1[text() = 'My account']")));

    }
    @Test
    public void uzivatelSeMusiBytSchopenPrihlasitNaHlavniStranceAPresmerovanNaMyAccountPage() {

        prohlizec.navigate().to("http://czechitas-datestovani-hackathon.cz/en/");

        WebElement clickPrihlaseni = prohlizec.findElement(By.className("hide_xs"));
        clickPrihlaseni.click();

        vyplnEmailSignIn("ahanouskaya@gmail.com");
        vyplnPassword("Ovechkin8");

        buttonSignIn();

        Assertions.assertNotNull(prohlizec.findElement(By.xpath("//h1[text() = 'My account']")));

    }

    @Test
    public void uzivatelSeMusiBytSchopenOdhlasit() throws InterruptedException {

        prohlizec.navigate().to("http://czechitas-datestovani-hackathon.cz/en/");
        WebElement clickPrihlaseni = prohlizec.findElement(By.className("hide_xs"));
        clickPrihlaseni.click();
        vyplnEmailSignIn("ahanouskaya@gmail.com");
        vyplnPassword("Ovechkin8");
        buttonSignIn();

        WebElement clickUserName = prohlizec.findElement(By.id("user_info_acc"));
        clickUserName.click();
        Thread.sleep(1000);
        WebElement clickLogOut = prohlizec.findElement(By.xpath("//a[text() = 'Logout']"));
        clickLogOut.click();

        Assertions.assertNotNull(prohlizec.findElement(By.xpath("//h1[text() = 'Authentication']")));
    }


    public void vyplnEmailRegistraci(String userName) {
        WebElement polickoEmailRegistraci = prohlizec.findElement(By.id("email_create"));
        polickoEmailRegistraci.sendKeys(userName);
    }
    public void buttonSubmitCreate() {
        WebElement buttonSubmitCreate = prohlizec.findElement(By.id("SubmitCreate"));
        buttonSubmitCreate.click();
    }
    public void vyplnFirstNameRegistraci(String userName) {
        WebElement polickoFirstNameRegistraci = prohlizec.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        polickoFirstNameRegistraci.sendKeys(userName);
    }
    public void vyplnLastNameRegistraci(String userName) {
        WebElement polickoLastNameRegistraci = prohlizec.findElement(By.id("customer_lastname"));
        polickoLastNameRegistraci.sendKeys(userName);
    }
    public void vyplnPasswordRegistrace(String password) {
        WebElement polickoPasswordRegistrace = prohlizec.findElement(By.id("passwd"));
        polickoPasswordRegistrace.sendKeys(password);
    }
    public void buttonRegister() {
        WebElement buttonRegister = prohlizec.findElement(By.id("submitAccount"));
        buttonRegister.click();
    }



    public void vyplnEmailSignIn(String userName) {
        WebElement polickoEmailSignIn = prohlizec.findElement(By.id("email"));
        polickoEmailSignIn.sendKeys(userName);
    }
    public void vyplnPassword(String password) {
        WebElement polickoPassword = prohlizec.findElement(By.id("passwd"));
        polickoPassword.sendKeys(password);
    }

    public void buttonSignIn() {
        WebElement buttonSignIn = prohlizec.findElement(By.id("SubmitLogin"));
        buttonSignIn.click();
    }

}
