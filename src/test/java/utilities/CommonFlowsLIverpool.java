package utilities;

import data.DataGiver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.*;

public class CommonFlowsLIverpool {
    private WebDriver getDriver(){
        return new WebDriverProvider().get();
    }


    public void goToHomePage(){
        Logs.info("Navegando a la pagina");
        getDriver().get("https://www.liverpool.com.mx/tienda/home");
        new LPHomePage().waitPageToLoad();
    }

}
