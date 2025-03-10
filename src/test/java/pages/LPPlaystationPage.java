package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class LPPlaystationPage extends BasePage {
    private final By searchLabel = By.cssSelector(".m-title-leftMenu-currentCategory");
    private final By consolasLabel = By.xpath("//a[text()='Consolas']");
    private final By juegosLabel = By.xpath("//a[text()='Juegos']");

    @Override
    public void waitPageToLoad() {
        waitPage(searchLabel, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando las opciones del sidebar");

        Assertions.assertAll(
                ()-> Assertions.assertTrue(find(consolasLabel).isDisplayed()),
                ()-> Assertions.assertTrue(find(juegosLabel).isDisplayed())
        );
    }

    public void goToJuegosDetail(){
        Logs.info("Navegando al detalle de juegos: %s");
        find(juegosLabel).click();
    }

    public void goToConsolasDetail(){
        Logs.info("Navegando al detalle del item: %s");
        find(consolasLabel).click();
    }

    public void verifySideOptions(){
        Logs.info("Verificando las opciones del left side");
        Assertions.assertAll(
                ()-> Assertions.assertTrue(find(consolasLabel).isDisplayed()),
                ()-> Assertions.assertTrue(find(juegosLabel).isDisplayed())
        );
    }

    public void clickConsolasOption(){
        Logs.info("Haciendo click en la opcion de consolas");
        find(consolasLabel).click();
    }
}
