package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.BasePage;
import utilities.Logs;

public class LPHomePage extends BasePage {
    private final By searchbarInput = By.id("mainSearchbar");
    private final By categoriasMenu = By.xpath("//span[text()='Categorías']");


    @Override
    public void waitPageToLoad() {
        waitPage(searchbarInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando la pagina de login");

        Assertions.assertAll(
                ()-> Assertions.assertTrue(find(searchbarInput).isDisplayed()),
                ()-> Assertions.assertTrue(find(categoriasMenu).isDisplayed())
        );
    }

    public void fillSearchbar(String item){
        Logs.info("Escribiendo item a buscar");
        find(searchbarInput).sendKeys(item);

        Logs.info("Dando ENTER a la busqueda");
        find(searchbarInput).sendKeys(Keys.ENTER);
    }

}
