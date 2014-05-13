package net.patersons.gui.test.functional;

import org.openqa.selenium.WebDriver;

/**
 * Class taking a driver factory and tying its use to client requests for a concrete instance of {@link WebDriver}.
 * @author josephjobbings
 */
public class WebDriverProvider {

    private static WebDriverProvider webDriverProvider;
    private UiDriver uiDriver;

    /**
     * Static method to access the provider instance (i.e. singleton)
     * @return an instance of this class
     */
    public static WebDriverProvider instance() {
        if(webDriverProvider == null) {
            webDriverProvider = new WebDriverProvider();
        }
        return webDriverProvider;
    }

    /**
     * New up and assign the driver member variable.
     * @param browser an enumeration of browser types (firefox, ie, safari etc)
     */
    public void makeDriver(WebDriverFactory.browserType browser) {
        uiDriver = new UiDriver(new WebDriverFactory().getDriver(browser));
    }

    /**
     * New up and assign the driver member variable.
     */
    public void makeDriver() {
        uiDriver = new UiDriver(new WebDriverFactory().getDriver());
    }

    /**
     * Method to get the {@link WebDriver} currently in play.
     * @return whatever the {@link this#uiDriver} currently points to...may reference null
     */
    public UiDriver getWebDriver() {
        if(uiDriver == null) {
            makeDriver();
        }
        return uiDriver;

    }

    public void quitDriver() {
        if(uiDriver != null) {
            uiDriver.quit();
            uiDriver = null;
        }
    }

}
