package net.patersons.gui.test.logon2;

import net.patersons.gui.test.functional.WebDriverProvider;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;

/**
 * Base integration test class. This class coordinates objects that help create and manage test fixtures.
 * @author josephjobbings
 */
public class GuiIntegrationTest {

    @Rule
    public static ErrorCollector collector = new ErrorCollector(); // must be public

    /**
     * TODO - logon to logon2 as a 'Before' pre-condition in this superclass?
     */
    @Before
    public void setup() {
        // call the code to new up a web driver instance and get a new session - previous tests will have torn it down
        WebDriverProvider.instance().makeDriver();
    }

    @After
    public void tearDown() {
        WebDriverProvider.instance().quitDriver();
    }

    public static ErrorCollector getCollector() {
        return collector;
    }

}
