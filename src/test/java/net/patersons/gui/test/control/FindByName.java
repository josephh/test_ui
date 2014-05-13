package net.patersons.gui.test.control;

import org.openqa.selenium.By;

/**
 * Concrete {@link Find} implementation - looking for DOM element name.
 * @author josephjobbings
 */
public class FindByName implements Find {

    private String name;

    public FindByName(String name) {
        this.name = name;
    }

    public By by() {
        return By.name(name);
    }

}
