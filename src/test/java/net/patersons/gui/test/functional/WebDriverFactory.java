package net.patersons.gui.test.functional;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteStatus;

/**
 * <p>
 * Class to new up different web driver implementations (IE, Chrome, Opera etc).
 * </p>
 * @see http://www.seleniumhq.org/docs/01_introducing_selenium.jsp#brief-history-of-the-selenium-project
 * @author josephjobbings
 */
public class WebDriverFactory {

    public enum browserType {
        firefox
    }

    /**
     * Parameterised constructor.
     * @param browsertype a hint to the factory about which implementation of {@link WebDriver} to instantiate.
     * @return a browser-specific implementation of {@link WebDriver}
     */
    public WebDriver getDriver(final browserType browsertype) {

        /**
         * TODO Use the parameter to add other browser types to the enumeration above and load drivers accordingly...
         */
        return getDriver(); // for the moment...

    }

    /**
     * Constructor.
     * @return a browser-specific implementation of {@link WebDriver}
     */
    public WebDriver getDriver() {
        FirefoxDriver fd = new FirefoxDriver(new FirefoxProfile());

        for(Object key : fd.getCapabilities().asMap().keySet()) {
            System.out.println("key=" + key + " : value=" + fd.getCapabilities().asMap().get(key));
        }

        // fd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        return fd;
    }
}
