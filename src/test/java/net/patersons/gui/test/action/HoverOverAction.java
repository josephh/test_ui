package net.patersons.gui.test.action;

import net.patersons.gui.test.control.UiControl;
import net.patersons.gui.test.functional.UiDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class HoverOverAction extends UiAction {

    public HoverOverAction(UiDriver uiDriver, UiControl control) {
        super(uiDriver, control);
    }

    public void hoverOver() {
        Actions actions = new Actions(driver);
        actions.moveToElement(element.getElement());
    }
    
}
