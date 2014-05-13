package net.patersons.gui.test.control;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * <p>
 * This abstract class has a constructor that takes a parameter which is assigned to the {@link WebElement} class member
 * variable.
 * </p>
 * <p>
 * Subclasses of <code>UIControl</code> must implement a method to set the value of the {@link WebElement} in play at
 * runtime.
 * </p>
 * @author josephjobbings
 */
public abstract class UiControl {

    protected WebElement webElement;

    public UiControl(WebElement webElement) {
        this.webElement = webElement;
    }

    /**
     * Get the value returned from calling {@link WebElement#getText()}
     * @return the character string inner text
     */
    public String getValue() {
        return webElement.getText();
    }

    public abstract void setValue(String value);

    public void clearValue() {
        webElement.clear();
    }

    /**
     * Get the DOM elements returned from calling {@link WebElement#findElement(By)}
     * @return the list of web elements.
     */
    public List<WebElement> getOptions() {
        List<WebElement> options = webElement.findElements(By.tagName("option"));
        return options;
    }

    /**
     * Make a request to {@link WebElement#sendKeys(CharSequence...)} with a <i>varargs</i> number of parameters.
     */
    public void sendKeys(Keys chars) {
        webElement.sendKeys(chars);
    }
    
    public WebElement getElement(){
        return webElement;
    }
    
}
