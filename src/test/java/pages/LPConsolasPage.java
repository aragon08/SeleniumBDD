package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class LPConsolasPage extends BasePage {
    private final By consolasTitle = By.xpath("//h1[text()='Consolas']");
    private final By firstResult = By.cssSelector("[data-prodid='1150222024']");

    @Override
    public void waitPageToLoad() {
        waitPage(firstResult, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando el titulo de la pagina");

        Assertions.assertAll(
                ()-> Assertions.assertTrue(find(firstResult).isDisplayed())
        );
    }

    public void clickFirstResult(){
        Logs.info("Haciendo click en el primer resultado");
        find(firstResult).click();
    }
}
