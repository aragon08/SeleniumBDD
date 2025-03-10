package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;
import utilities.Logs;

import java.time.Duration;

public class LPCategoriasMenu extends BasePage {
    private final By categoriasMenu = By.id("categories-sidebarMenu");
    private final By mujerCategory = By.cssSelector("li[data-submenu-id='CATST4003072']");
    private final By hombreCategry = By.cssSelector("li[data-submenu-id='CAT5020003']");
    private final By ninoNinaCategory = By.cssSelector("li[data-submenu-id='CATST18406782']");
    private final By bebesCategory = By.cssSelector("li[data-submenu-id='CATST5620308']");
    private final By zapatosCategory = By.cssSelector("li[data-submenu-id='CAT5040494']");
    private final By bellezaCategory = By.cssSelector("li[data-submenu-id='CAT5020010']");


    @Override
    public void waitPageToLoad() {
        waitPage(categoriasMenu, this.getClass().getSimpleName());

        Logs.info("Esperando que sea clickeable por la animacion");
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(categoriasMenu));
    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando el menu burger");

        Assertions.assertAll(
                () -> Assertions.assertTrue(find(categoriasMenu).isDisplayed()),
                () -> Assertions.assertTrue(find(mujerCategory).isDisplayed()),
                () -> Assertions.assertTrue(find(bellezaCategory).isDisplayed())
        );
    }

    public void clickMujerCategory(){
        Logs.info("Haciendo click en Mujer");
        find(mujerCategory).click();
    }

    public void clickHombreCategory(){
        Logs.info("Haciendo click en Hombre");
        find(hombreCategry).click();
    }
    public void clickNinosNinasCategory(){
        Logs.info("Haciendo click en Ninos y Ninas");
        find(ninoNinaCategory).click();
    }

    public void clickBebesCategory(){
        Logs.info("Haciendo click en Bebes");
        find(bebesCategory).click();
    }

    public void clickZapatosCategory(){
        Logs.info("Haciendo click en Zapatos");
        find(zapatosCategory).click();
    }

    public void clickBellezaCategory(){
        Logs.info("Haciendo click en Belleza");
        find(bellezaCategory).click();
    }
}
