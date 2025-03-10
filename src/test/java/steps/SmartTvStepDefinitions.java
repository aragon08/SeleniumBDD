package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LPHomePage;
import utilities.CommonFlowsLIverpool;

public class SmartTvStepDefinitions {
    private final CommonFlowsLIverpool commonFlowsLIverpool = new CommonFlowsLIverpool();
    private final LPHomePage lpHomePage = new LPHomePage();

    @When("El usuario busca {string} en la barra de busqueda")
    public void searchPlaystationItem(String item) {
        lpHomePage.fillSearchbar(item);
    }

    @Then("El usuarios es redirigido a la pagina de resultados de smart tv")
    public void elUsuariosEsRedirigidoALaPaginaDeResultadosDeSmartTv() {

    }

    @And("La pagina contiene los filtros: Size y Price")
    public void laPaginaContieneLosFiltrosSizeYPrice() {

    }

    @And("el usuario seleciona los filtros: Size {int} pulgadas, price mayor a {int} y brand Sony")
    public void elUsuarioSelecionaLosFiltrosSizePulgadasPriceMayorAYBrandSony(int arg0, int arg1) {
    }
}
