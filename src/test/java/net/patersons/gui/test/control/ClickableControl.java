package net.patersons.gui.test.control;

import org.openqa.selenium.WebElement;

/**
 * Concrete implementation providing 'interaction' with a web GUi element.
 * @author josephjobbings
 */
public class ClickableControl extends UiControl {

    public ClickableControl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
        webElement.click();
    }
}
