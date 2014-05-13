package net.patersons.gui.test.control;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Concrete implementation providing 'interaction' with a web GUi element.
 * @author josephjobbings
 */
public class DropDownControl extends UiControl {

    public DropDownControl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setValue(String value) {
        Select listBox = new Select(webElement);
        listBox.selectByVisibleText(value);
    }
}
