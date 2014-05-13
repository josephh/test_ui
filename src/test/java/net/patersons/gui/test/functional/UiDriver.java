package net.patersons.gui.test.functional;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that forwards on calls to {@link WebDriver} to the wrapped, browser-specific instance passed into this class
 * via its constructor.
 * @author josephjobbings
 */
public class UiDriver implements WebDriver {

    private  WebDriver webDriver;

    private  Logger log = LoggerFactory.getLogger(UiDriver.class);

    /**
     * Parameterised constructor.
     * @param webDriver the concrete, browser-specific implementation.
     */
    public UiDriver( WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void get( String url) {
        webDriver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return webDriver.getTitle();
    }

    @Override
    public List<WebElement> findElements(  final By by) {
         WebDriverWait wait = new WebDriverWait(webDriver, 30);

        try {
            wait.until(new ExpectedCondition<Boolean>() {

                public Boolean apply( WebDriver _webDriver) {
                    return (_webDriver.findElement(by) != null);
                }
            });
        } catch( TimeoutException e) {
            log.info(e.getMessage() + "findElement for " + by + ": " + e);
        }
        return webDriver.findElements(by);
    }

    @Override
    public WebElement findElement( final By by) {
         WebDriverWait wait = new WebDriverWait(webDriver, 30);

        try {
            wait.until(new ExpectedCondition<Boolean>() {

                public Boolean apply(WebDriver _webDriver) {
                    return (_webDriver.findElement(by) != null);
                }
            });
        } catch(  TimeoutException e) {
            log.info(e.getMessage() + "findElement for " + by + ": " + e);
        }
        return webDriver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return webDriver.getPageSource();
    }

    @Override
    public void close() {
        webDriver.close();
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return webDriver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return webDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return webDriver.navigate();
    }

    /**
     * Method to take a screen shot and store it on disk. (This might be helpful for test results or problem diagnosis).
     * <p>
     * The screen shot is held in a file in memory before being written out to a file on disk.
     * </p>
     * <p>
     * Note, if the {@link WebDriver} in play doesn't have the capability to take a screenshot, a casting exception may
     * be seen at runtime.
     * </p>
     * @param file the file to write the screenshot out to.
     */
    public void captureScreen(  String file) {
          File screenShotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File(file));
        } catch(  IOException e) {
            e.printStackTrace();
        }
    }

    public void ExecuteJavascript(  String jCommand) {
          JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript(jCommand);
    }

    @Override
    public Options manage() {
        return null;
    }

}
