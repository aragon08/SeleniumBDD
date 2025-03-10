package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class Footer extends BasePage {
    private final By twittierButton = By.xpath("//a[text()='Twitter']");
    private final By linkedinButton = By.xpath("//a[text()='LinkedIn']");
    private final By facebookButton = By.xpath("//a[text()='Facebook']");

    @Override
    public void waitPageToLoad() {

    }

    @Override
    public void verifyPage() {

    }

    public void verifySocialMediaLinks(
            String twitterUrl,
            String linkedinUrl,
            String facebookUrl
    ){
        final var twitterLabel = find(twittierButton);
        final var linkedinLabel = find(linkedinButton);
        final var facebookLabel = find(facebookButton);

        Logs.info("Verificando los links de las redes sociales");

        Assertions.assertAll(
                ()-> Assertions.assertTrue(twitterLabel.isDisplayed()),
                ()-> Assertions.assertTrue(twitterLabel.isEnabled()),
                ()-> Assertions.assertEquals(
                        twitterLabel.getDomAttribute("href"),
                        twitterUrl),

                ()-> Assertions.assertTrue(linkedinLabel.isDisplayed()),
                ()-> Assertions.assertTrue(linkedinLabel.isEnabled()),
                ()-> Assertions.assertEquals(
                        linkedinLabel.getDomAttribute("href"),
                        linkedinUrl),

                ()-> Assertions.assertTrue(facebookLabel.isDisplayed()),
                ()-> Assertions.assertTrue(facebookLabel.isEnabled()),
                ()-> Assertions.assertEquals(
                        facebookLabel.getDomAttribute("href"),
                        facebookUrl)
        );
    }
}
