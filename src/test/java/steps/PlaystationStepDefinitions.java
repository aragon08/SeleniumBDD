package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LPConsolasPage;
import pages.LPHomePage;
import pages.LPPlaystationDetailPage;
import pages.LPPlaystationPage;
import utilities.CommonFlowsLIverpool;

public class PlaystationStepDefinitions {
    private final CommonFlowsLIverpool commonFlowsLIverpool = new CommonFlowsLIverpool();
    private final LPHomePage lpHomePage = new LPHomePage();
    private final LPPlaystationPage lpPlaystationPage = new LPPlaystationPage();
    private final LPConsolasPage lpConsolasPage = new LPConsolasPage();
    private final LPPlaystationDetailPage lpPlaystationDetailPage = new LPPlaystationDetailPage();

    @Given("El usuario navega a la pagina de Liverpool")
    public void goToLPHomePage() {
        commonFlowsLIverpool.goToHomePage();
    }

    @Then("El usuario verifica que la pagina Liverpool sea correcta")
    public void verifyPlaystationUI() {
        lpHomePage.verifyPage();
    }

    @When("El usuario ingresa {string} en la barra de busqueda")
    public void searchPlaystationItem(String item) {
        lpHomePage.fillSearchbar(item);
    }

    @Then("El usuaro es redirigido a la pagina de resultados de playstation")
    public void verifyPlaystationResultPage() {
        lpPlaystationPage.waitPageToLoad();
        lpPlaystationPage.verifyPage();

    }

    @And("El usuario hace click en el link consolas")
    public void clickToConsolasOption() {
        lpPlaystationPage.clickConsolasOption();
    }

    @Then("El usuario verifica que la página de consolas muestra la lista de consolas disponibles")
    public void verifyConsolasPageUI() {
        lpConsolasPage.waitPageToLoad();
        lpConsolasPage.verifyPage();
    }

    @And("El usuario hace clic en el primer artículo de la lista")
    public void clickFirstResult() {
        lpConsolasPage.clickFirstResult();
    }

    @Then("El usuario verifica que la página de detalles del artículo muestra el título {string}")
    public void verifyDetailpageUITitle(String arg0) {
        lpPlaystationDetailPage.waitPageToLoad();
        lpPlaystationDetailPage.verifyPage();
    }

    @And("El usuario verifica que el precio del artículo es {string}")
    public void verifyDetailpageUITitlePrice(String arg0) {
        lpPlaystationDetailPage.verifyitemPrice("9999.00");
    }
}
