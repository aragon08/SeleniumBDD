package steps;

import data.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelos.ItemProduct;
import org.checkerframework.checker.units.qual.C;
import pages.ShoppingPage;
import utilities.CommonFlows;

import java.util.List;

public class ShoppingStepDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private List<ItemProduct> productList;

    @Given("El usuario entre logueado a la pagina de Shopping")
    public void goToShoppingPage() {
        commonFlows.goToShoppingPage();
    }

    @Then("El usuario verifica que la UI de la pagina de Shopping sea correcta")
    public void verifyUIShoppingPage() {
        shoppingPage.verifyPage();
    }

    @When("Leo los productos esperados del Excel")
    public void readExcelProductList() {
        productList = ExcelReader.leerListaProductoExcel();
    }

    @Then("Verifico que los productos del Excel sean los mismo que la pagina")
    public void verifyPrices() {
        shoppingPage.verifyProductsPrice(productList);
    }
}
