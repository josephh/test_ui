package net.patersons.gui.test.control;

import org.openqa.selenium.WebElement;

/**
 * Concrete implementation providing 'interaction' with a web GUi element.
 * @author josephjobbings
 */
public class SpanControl extends UiControl {

    public SpanControl(WebElement webElement) {
        super(webElement);
    }

    /**
     * <p>
     * TODO - consider how to do this... <br/>
     * <br/>
     * If we have a span element like the following, <br/>
     * <blockquote> {@code <span id="exampleSpanId">Text value inside span</span>} </blockquote><br/>
     * then it can be located and manipulated in an automated test in a couple of ways.
     * </p>
     * <p>
     * <ol>
     * <li>Use the Selenium web driver libraries:
     * {@link org.openqa.selenium.WebElement#getAttribute(java.lang.String name)}.</br>Call getAttribute if the element
     * can be found, for example, <blockquote>
     * <code>driver.findElement(By.id("exampleSpanId")).getAttribute("innerHTML");</code> </blockquote> or access the
     * text value directly,<blockquote> <code>driver.findElement(By.id("exampleSpanId")).getText()</code> </blockquote></li>
     * <li>If the concrete web driver implementation supports javascript execution, cast the driver and use the Selenium
     * web driver libraries: {@link org.openqa.selenium.JavascriptExecutor#executeScript(String, Object...)}. For
     * example, <blockquote>
     * 
     * <pre>
     * <code>String js = "return document.getElementById('exampleSpanId').innerHTML;";
     * String s = (String) ((JavascriptExecutor) driver).executeScript(js);</code>
     * </pre>
     * 
     * </blockquote></li>
     * </ol>
     */
    @Override
    public void setValue(String value) {

    }
}
