package net.patersons.gui.test.control;

import org.openqa.selenium.By;

/**
 * Concrete {@link Find} implementation - looking for Css selector.
 * @author josephjobbings
 */
public class FindByCssSelector implements Find {

    private String cssSelector;

    public FindByCssSelector(String cssSelector) {
        this.cssSelector = cssSelector;
    }

    @Override
    public By by() {
        return By.cssSelector(cssSelector);
    }

}
