package net.patersons.gui.test.control;

import org.openqa.selenium.WebElement;

/**
 * Concrete implementation providing 'interaction' with a web GUi element. <code>TEXTAREA</code>
 * "...can hold an unlimited number of characters...".
 * @author josephjobbings
 */
public class TextAreaControl extends UiControl {

    public TextAreaControl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
        webElement.clear();
        webElement.sendKeys(value);
    }
}
