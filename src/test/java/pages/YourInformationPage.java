package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class YourInformationPage extends BasePage {
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By errorLabel = By.cssSelector("h3[data-test='error']");

    @Override

    public void waitPageToLoad() {
        waitPage(firstNameInput, this.getClass().getSimpleName());
    }

    @Override

    public void verifyPage() {
        Logs.info("Verificando la pagina de your information");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(firstNameInput).isDisplayed()),
                () -> Assertions.assertTrue(find(lastNameInput).isDisplayed()),
                () -> Assertions.assertTrue(find(zipCodeInput).isDisplayed()),
                () -> Assertions.assertTrue(find(continueButton).isDisplayed())
        );
    }


    public void fillData(String name, String lastname, String zipcode){
        if (!name.isEmpty()) {
            Logs.info("Escribiendo el firstname");
            find(firstNameInput).sendKeys(name);
        }

        if (!lastname.isEmpty()) {
            Logs.info("Escribiendo el firstname");
            find(lastNameInput).sendKeys(lastname);
        }

        if (!zipcode.isEmpty()) {
            Logs.info("Escribiendo el firstname");
            find(zipCodeInput).sendKeys(zipcode);
        }

        Logs.info("Haciendo click en continue");
        find(continueButton).click();
    }


    public void verifyErrorMessage(String erroMessage){
        Logs.info("Verificando el mensaje de error");
        final var errorLabelElement = find(errorLabel);

        Assertions.assertAll(
                () -> Assertions.assertTrue(errorLabelElement.isDisplayed()),
                () -> Assertions.assertEquals(errorLabelElement.getText(), erroMessage)
        );
    }
}
