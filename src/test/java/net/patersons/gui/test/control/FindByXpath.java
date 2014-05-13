package net.patersons.gui.test.control;

import org.openqa.selenium.By;

/**
 * Concrete {@link Find} implementation - walking the DOM with xpath (looking for an element).
 * @author josephjobbings
 */
public class FindByXpath implements Find {

    private String xpath;

    public FindByXpath(String xpath) {
        this.xpath = xpath;
    }

    public By by() {
        return By.xpath(xpath);
    }

}
