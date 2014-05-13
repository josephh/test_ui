package net.patersons.gui.test.control;

import org.openqa.selenium.By;

/**
 * Concrete {@link Find} implementation - looking for DOM element id.
 * @author josephjobbings
 */
public class FindById implements Find {

    private String id;

    public FindById(String id) {
        this.id = id;
    }

    public By by() {
        return By.id(id);
    }

}
