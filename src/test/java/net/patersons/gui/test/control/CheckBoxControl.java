package net.patersons.gui.test.control;

import org.openqa.selenium.WebElement;

public class CheckBoxControl extends UiControl {

    public CheckBoxControl(WebElement webElement) {
        super(webElement);
    }

    /**
     * Test whether a checkbox is selected or not via code along the lines of, <blockquote> <code>if(
     * !driver.findElement(By.id("idOfTheElement").isSelected() ) {
     * driver.findElement(By.id("idOfTheElement").click();
     * } </code></blockquote>
     */
    @Override
    public void setValue(String value) {
        webElement.click();
    }
}
