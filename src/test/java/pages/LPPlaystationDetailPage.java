package pages;

import modelos.ItemProduct;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utilities.BasePage;
import utilities.Logs;

import java.util.List;

public class LPPlaystationDetailPage extends BasePage {
    private final By itemTitle = By.
            xpath("//div[@class='o-product__description liverpool']//p[text()='PLAYSTATION']");
    private final By priceLabel = By.cssSelector(".m-product__price-dw-promotion");

    @Override
    public void waitPageToLoad() {
        waitPage(itemTitle, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando el titulo de la pagina");

        Assertions.assertAll(
                ()-> Assertions.assertTrue(find(itemTitle).isDisplayed()),
                ()-> Assertions.assertTrue(find(priceLabel).isDisplayed())
        );
    }

    public void verifyitemPrice(String expectedPrice) {
        Logs.info("Verificando el precio del producto");

        final WebElement priceElement = find(priceLabel);
        String priceText = priceElement.getText().replace("$", "").trim();

        String centsText = "00"; // Valor predeterminado para los centavos

        try {
            WebElement centsElement = priceElement.findElement(By.tagName("sup"));
            centsText = centsElement.getText();
        } catch (NoSuchElementException e) {
            Logs.info("No se encontraron centavos para el precio.");
        }

        // Limpiar el texto del precio y los centavos
        priceText = priceText.replaceAll("[^\\d.]", ""); // Permite dígitos y puntos
        centsText = centsText.replaceAll("[^\\d]", ""); // Solo dígitos para centavos

        // Separar el precio principal y los centavos
        String[] priceParts = priceText.split("\\.");
        if (priceParts.length > 1) {
            priceText = priceParts[0];
            centsText = priceParts[1];
        }

        // Asegurar que los centavos tengan dos dígitos
        if (centsText.length() > 2) {
            centsText = centsText.substring(0, 2);
        } else if (centsText.length() == 1) {
            centsText = "0" + centsText;
        } else if (centsText.length() == 0){
            centsText = "00";
        }

        double actualPrice = Double.parseDouble(priceText + "." + centsText);
        double expectedPriceDouble = Double.parseDouble(expectedPrice);

        Assertions.assertEquals(
                expectedPriceDouble,
                actualPrice,
                String.format("fallo: precio esperado: %s, precio actual: %s", expectedPriceDouble, actualPrice)
        );
    }
}
