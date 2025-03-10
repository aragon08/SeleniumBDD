package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverManager {
    private final boolean runServer = System.getenv("JOB_NAME") != null;

    public void buildDriver(){
        if (runServer) {
            buildRemoteDriver();
        }else {
            buildLocalDriver();
        }
    }

    private void buildRemoteDriver(){

    }

    private void buildLocalDriver(){
        final var headlessMode = System.getProperty("headless") != null;
        var browserProperty = System.getProperty("browser");

        if (browserProperty == null) {
            Logs.info("Asignando default driver a CHROME");
            browserProperty = "CHROME";
        }

        final var browser = Browser.valueOf(browserProperty.toUpperCase());

        Logs.info("Inicializando driver: %s", browser);

        final var driver = switch (browser){
            case CHROME -> {
                final var chromeOptions = new ChromeOptions();
                if (headlessMode) {
                    chromeOptions.addArguments("--headless=new");
                }
                yield new ChromeDriver(chromeOptions);
            }
            case EDGE -> {
                final var edgeOptions = new EdgeOptions();
                if (headlessMode) {
                    edgeOptions.addArguments("--headless=new");
                }
                yield new EdgeDriver(edgeOptions);
            }
            case FIREFOX -> {
                final var firefoxOptions = new FirefoxOptions();
                if (headlessMode) {
                    firefoxOptions.addArguments("--headless");
                }
                yield new FirefoxDriver(firefoxOptions);
            }
            case SAFARI -> new SafariDriver();

        };

        Logs.debug("Maximizando la pantalla");
        driver.manage().window().maximize();

        Logs.debug("Borrrando las cookies");
        driver.manage().deleteAllCookies();

        new WebDriverProvider().set(driver);
    }

    public void killDriver(){
        Logs.debug("Matando el padre");
        new WebDriverProvider().get().quit();
    }

    private enum Browser{
        CHROME,
        FIREFOX,
        EDGE,
        SAFARI
    }
}
