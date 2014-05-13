package net.patersons.gui.test.control;

import org.openqa.selenium.WebElement;

/**
 * Concrete implementation providing 'interaction' with a web GUi element.
 * @author josephjobbings
 */
public class RadioControl extends UiControl {

    public RadioControl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
        webElement.click();
    }
}
