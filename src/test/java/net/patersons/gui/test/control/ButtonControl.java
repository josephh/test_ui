package net.patersons.gui.test.control;

import org.openqa.selenium.WebElement;

/**
 * Class containing a map of likely HTML screen elements, keyed by element name.
 * @author josephjobbings
 */
public class ButtonControl extends UiControl {

    public ButtonControl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
        webElement.click();
    }
}
