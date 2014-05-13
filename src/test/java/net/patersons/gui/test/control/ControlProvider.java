package net.patersons.gui.test.control;

import java.util.HashMap;
import java.util.NoSuchElementException;
import net.patersons.gui.test.functional.UiDriver;
import org.openqa.selenium.WebElement;

/**
 * Class containing a map of likely HTML screen elements, keyed by element name.
 * @author josephjobbings
 */
public final class ControlProvider {

    protected UiDriver uiDriver;
    private WebElement webElement;

    public ControlProvider(UiDriver uiDriver) {
        this.uiDriver = uiDriver;  
    }

    private static UiControl controlType(String elementType, WebElement webElementControl, String id) {
        HashMap<String, UiControl> controlMap = new HashMap<String, UiControl>();
        controlMap.put("text", new TextBoxControl(webElementControl));
        controlMap.put("password", new TextBoxControl(webElementControl));
        controlMap.put("textarea", new TextAreaControl(webElementControl));
        controlMap.put("checkbox", new CheckBoxControl(webElementControl));
        controlMap.put("button", new ButtonControl(webElementControl));
        controlMap.put("submit", new ButtonControl(webElementControl));
        controlMap.put("input", new ButtonControl(webElementControl));
        controlMap.put("radio", new RadioControl(webElementControl));
        controlMap.put("select", new DropDownControl(webElementControl));
        controlMap.put("a", new ClickableControl(webElementControl));
        controlMap.put("span", new SpanControl(webElementControl));
        controlMap.put("image", new ClickableControl(webElementControl));
        controlMap.put("img", new ClickableControl(webElementControl));
        controlMap.put("strong", new ClickableControl(webElementControl));
        controlMap.put("div", new ClickableControl(webElementControl));

        if(elementType == null || elementType.equals("")) {
            throw new NoSuchElementException("Control with [id] : " + id + " not found on page");
        } else {
            return (UiControl) controlMap.get(elementType);
        }
    }

    /**
     * Get a UI web element, by supplying a class that implements {@link Find#by()}.
     * @param finder the concrete class that uses Selenium's libraries - which in turn use xpath - to find elements
     *            inside an HTML Document.
     * @return the runtime implementation the UI control
     */
    public UiControl getControl(Find finder) {
        webElement = uiDriver.findElement(finder.by());
        return controlType(getElementType(webElement), webElement, "");
    }

    /**
     * Convenience method to find a form's
     * @param finder
     * @return
     */
    public UiControl getSelectControl(Find finder) {
        webElement = uiDriver.findElement(finder.by());
        return controlType("select", webElement, "");
    }

    /**
     * Make a request to {@link WebElement#getAttribute(String)} passing a character string argument of <i>type</i>.
     * @param webElement the element to query an attribute of
     * @return the web element's type.
     */
    public static String getElementType(WebElement webElement) {
        String attribute = webElement.getAttribute("type");
        if(attribute == null || attribute.equalsIgnoreCase("")) {
            attribute = webElement.getTagName();
        }
        return attribute == null ? "a" : attribute;
    }

}
