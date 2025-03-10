package utilities;

import data.DataGiver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.*;

public class CommonFlows{
    private WebDriver getDriver(){
        return new WebDriverProvider().get();
    }

    private void assignLoginCookie(){
        Logs.debug("Asignando la cookie de login");
        getDriver().get("https://www.saucedemo.com/404");
        final var credencialesValidas = DataGiver.getValidCredentials();
        final var loginCookie =
                new Cookie("session-username", credencialesValidas.getUsername());
        getDriver().manage().addCookie(loginCookie);
    }

    public void goToLoginPage(){
        Logs.info("Navegando a la pagina");
        getDriver().get("https://www.saucedemo.com/");
        new LoginPage().waitPageToLoad();
    }

    public void goToShoppingPage(){
//        goToLoginPage();
//        final var credentialsValid = DataGiver.getValidCredentials();
//        new LoginPage().fillLogin(
//                credentialsValid.getUsername(),
//                credentialsValid.getPassword()
//        );
        assignLoginCookie();
        getDriver().get("https://www.saucedemo.com/inventory.html");
        new  ShoppingPage().waitPageToLoad();
    }

    public void openBurgerMenu(){
        goToShoppingPage();
        new TopBar().openMenuBurger();
        new MenuBurger().waitPageToLoad();
    }

    public void goToItemDetail(String itemName){
        goToShoppingPage();
        new ShoppingPage().goToItemDetail(itemName);
        new ItemDetailPage().waitPageToLoad();
    }

    public void goYourCartPage(){
        goToShoppingPage();
        new TopBar().clickShoppingCart();
        new YourCartPage().waitPageToLoad();
    }

    public void goYourInformationPAge(){
        goYourCartPage();
        new YourCartPage().clickCheckout();
        new YourInformationPage().waitPageToLoad();
    }


}
