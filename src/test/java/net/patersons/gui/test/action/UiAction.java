package net.patersons.gui.test.action;

import net.patersons.gui.test.control.UiControl;
import net.patersons.gui.test.functional.UiDriver;

/**
 * @author josephjobbings
 */
public abstract class UiAction {

    protected UiControl element;
    protected UiDriver driver;

    public UiAction( UiDriver uiDriver, UiControl element) {
        this.driver = uiDriver;
    }

}
