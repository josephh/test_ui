package net.patersons.gui.test.control;

import org.openqa.selenium.WebElement;

/**
 * Concrete implementation providing 'interaction' with a web GUi element. This implementation is intended to support
 * <code>INPUT</code> elements of type <code>text</code>.
 * @author josephjobbings
 */
public class TextBoxControl extends UiControl {

    public TextBoxControl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
        webElement.clear();
        webElement.sendKeys(value);
    }

    public void click() {
        webElement.click();
    }
}
