package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class LPSmartTvPage extends BasePage {
    private final By sizeLabel = By.xpath("//label[text()='Tamaño']");
    private final By pricesLabel = By.xpath("//label[text()='Precios']");
    private final By moreSizeLabel = By.id("#Tamao");
    private final By size55Check = By.xpath("//input[@id='variants.normalizedSize-55 pulgadas']");
    private final By priceRatio = By.xpath("//input[@id='variants.prices.sortPrice-10000-700000']");
    private final By searchBrandText = By.id("#searchBrand");
    private final By brandCheck = By.xpath("//input[@id='brand-SONY']");


    @Override
    public void waitPageToLoad() {
        waitPage(pricesLabel, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verificando los filtros Size y prices");

        Assertions.assertAll(
                ()-> Assertions.assertTrue(find(sizeLabel).isDisplayed()),
                ()-> Assertions.assertTrue(find(pricesLabel).isDisplayed())
        );
    }

    public void selectSize(){
        find(moreSizeLabel).click();
        find(size55Check).click();
    }

    public void selectPrice(){
        find(priceRatio).click();
    }

    public void selectBrand(String item){
        find(searchBrandText).sendKeys(item);
        find(brandCheck).click();
    }
}
