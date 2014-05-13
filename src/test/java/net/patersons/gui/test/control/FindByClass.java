package net.patersons.gui.test.control;

import org.openqa.selenium.By;

/**
 * Concrete {@link Find} implementation - looking for Css selector.
 * @author josephjobbings
 */
public class FindByClass implements Find {

    private String className;

    public FindByClass(String className) {
        this.className = className;
    }

    public By by() {
        return By.className(className);
    }

}
