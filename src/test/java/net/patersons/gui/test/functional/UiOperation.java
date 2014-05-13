package net.patersons.gui.test.functional;

import net.patersons.gui.test.action.HoverOverAction;
import net.patersons.gui.test.control.ControlProvider;
import net.patersons.gui.test.control.FindByClass;
import net.patersons.gui.test.control.FindByCssSelector;
import net.patersons.gui.test.control.FindById;
import net.patersons.gui.test.control.FindByLinkText;
import net.patersons.gui.test.control.FindByName;
import net.patersons.gui.test.control.FindByXpath;
import net.patersons.gui.test.control.UiControl;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class providing methods to manage and execute user interaction and user events (by providing mappings to HTML/DOM and
 * calling the Selenium library).
 * @author josephjobbings
 */
public class UiOperation {

    protected UiDriver uiDriver;
    private static final Logger LOGGER = LoggerFactory.getLogger(UiOperation.class);

    public UiOperation(UiDriver uiDriver) {
        this.uiDriver = uiDriver;
    }

    public void clickWithLinkText(final String linkText) {
        final UiControl control = new ControlProvider(uiDriver).getControl(new FindByLinkText(linkText));
        control.setValue(linkText);
    }

    public void clickWithCssSelector(final String cssSelector) {
        final UiControl control = new ControlProvider(uiDriver).getControl(new FindByCssSelector(cssSelector));
        control.setValue(cssSelector);
    }

    public void clickWithClass(final String className) {
        final UiControl control = new ControlProvider(uiDriver).getControl(new FindByClass(className));
        control.setValue(className);
    }

    public void clickWithXpath(final String xpath) {
        final UiControl control = new ControlProvider(uiDriver).getControl(new FindByXpath(xpath));
        control.setValue(xpath);
    }

    public void open(final String url) {
        uiDriver.switchTo().defaultContent();
        uiDriver.get(url);
    }

    public void input(final String elementId, final String value) {
        final UiControl control = new ControlProvider(uiDriver).getControl(new FindById(elementId));
        control.setValue(value);
    }

    public void inputByName(final String name, final String value) {
        final UiControl control = new ControlProvider(uiDriver).getControl(new FindByName(name));
        control.clearValue();
        control.setValue(value);
    }

    public void click(final String elementId) {
        final UiControl control = new ControlProvider(uiDriver).getControl(new FindById(elementId));
        control.setValue(elementId);
    }

    public void clickWithName(final String name) {
        final UiControl control = new ControlProvider(uiDriver).getControl(new FindByName(name));
        control.setValue(name);
    }

    public void enter() {
        uiDriver.findElement(By.xpath("//div[@id='submit']")).click();
    }

    public void selectWindow(final String windowTitle) {
        uiDriver.switchTo().window(windowTitle);
    }

    public void switchToDefaultContent() {
        uiDriver.switchTo().defaultContent();
    }

    public void selectWindowById(final int windowId) {
        uiDriver.switchTo().frame(windowId);
    }

    public void executeJavascript(final String javascript) {
        uiDriver.ExecuteJavascript(javascript);
    }

    public void clearCookies() {
        try {
            if(uiDriver.manage().getCookies() != null) {
                uiDriver.manage().deleteAllCookies();
            }
        } catch(NullPointerException exception) {
            LOGGER.error(exception.getMessage());
        }
    }

    public void closeAlert() {
        final Alert alert = uiDriver.switchTo().alert();
        if(alert.getText() != null) {
            alert.accept();
        }
    }

    public void wait(final int time) {
        try {
            Thread.sleep(time);
        } catch(final InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void captureScreen(final String file) {
        uiDriver.captureScreen(file);
    }

    public boolean isElementVisible(final String elementId) {
        WebElement webElement;
        webElement = uiDriver.findElement(By.id(elementId));
        if(webElement.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean isElementVisibleWithXpath(final String xPath) {
        try {
            WebElement webElement;
            webElement = uiDriver.findElement(By.xpath(xPath));
            if(webElement.isDisplayed()) {
                return true;
            }

        } catch(final NoSuchElementException ex) {
            return false;
        }
        return false;
    }

    public void inputWithName(final String name, final String value) {
        final UiControl control = new ControlProvider(uiDriver).getControl(new FindByName(name));
        control.setValue(value);
    }

    public void selectFromDropDown(final String locatorType, final String locator, final String value) {
        if(locatorType == "id") {
            new ControlProvider(uiDriver).getControl(new FindById(locator)).setValue(value);
        } else {
            new ControlProvider(uiDriver).getControl(new FindByName(locator)).setValue(value);
        }
    }

    public String getText(final String locator) {
        return uiDriver.findElement(By.id(locator)).getText();
    }

    public String getTextByXpath(final String xPath) {
        return uiDriver.findElement(By.xpath(xPath)).getText();
    }

    public boolean isTextPresent(final String text) {
        LOGGER.info(uiDriver.getPageSource());
        if(uiDriver.getPageSource().contains(text)) {
            return true;
        }
        return false;
    }

    public String getURL() {
        return uiDriver.getCurrentUrl();
    }

    public void inputByXpath(final String xPath, final String value) {
        final UiControl control = new ControlProvider(uiDriver).getControl(new FindByXpath(xPath));
        control.setValue(value);
    }
    
    public void hoverOver(String elementText){
        final UiControl control = new ControlProvider(uiDriver).getControl(new FindByLinkText(elementText));
        new HoverOverAction(uiDriver , control).hoverOver();
    }
}
