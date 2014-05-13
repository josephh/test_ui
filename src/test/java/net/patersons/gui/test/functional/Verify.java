package net.patersons.gui.test.functional;

import java.util.List;
import org.junit.Assert;
import org.junit.rules.ErrorCollector;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertEquals;

public class Verify {

    protected ErrorCollector errorCollector;
    protected final UiDriver uiDriver;

    public Verify(final UiDriver uiDriver, ErrorCollector errorCollector) {
        this.uiDriver = uiDriver;
        this.errorCollector = errorCollector;
    }

    public void verifyTrue(boolean condition) {
        try {
            assertTrue(condition);
        } catch(Throwable e) {
            errorCollector.addError(e);
        }
    }

    public void verifyTrue(boolean condition, String message) {
        try {
            assertTrue(message, condition);
        } catch(Throwable e) {
            errorCollector.addError(e);
        }
    }

    public void verifyFalse(boolean condition) {
        try {
            assertFalse(condition);
        } catch(Throwable e) {
            errorCollector.addError(e);
        }
    }

    public void verifyFalse(boolean condition, String message) {
        try {
            assertFalse(message, condition);
        } catch(Throwable e) {
            errorCollector.addError(e);
        }
    }

    public void verifyEquals(boolean actual, boolean expected) {
        try {
            assertEquals(actual, expected);
        } catch(Throwable e) {
            errorCollector.addError(e);
        }
    }

    public void verifyEquals(Object actual, Object expected) {
        try {
            assertEquals(actual, expected);
        } catch(Throwable e) {
            errorCollector.addError(e);
        }
    }

    public void verifyEquals(Object[] actual, Object[] expected) {
        try {
            assertEquals(actual, expected);
        } catch(Throwable e) {
            errorCollector.addError(e);
        }
    }

    public void fail(String message) {
        junit.framework.Assert.fail(message);
    }
    
    public void verifyMessage(final String message) {
        final String htmlSource = uiDriver.getPageSource();

        final int firstOccurence = htmlSource.indexOf(message);
        final int lastOccurence = htmlSource.lastIndexOf(message);
        if((firstOccurence != lastOccurence) || (firstOccurence == -1)) {
            errorCollector.addError(new Throwable(String.format("Expected one occurence of message [%s].", message)));
        }
    }

    public void verifyMultipleOccurenceOfAMessage(final String message) {
        final String htmlSource = uiDriver.getPageSource();
        final int firstOccurence = htmlSource.indexOf(message);
        final int lastOccurence = htmlSource.lastIndexOf(message);
        if((firstOccurence == lastOccurence) || (lastOccurence == -1)) {
            errorCollector.addError(new Throwable(String.format("Expected more than one occurence of message [%s].",
                    message)));
        }
    }

    public void verifyMessageNotDisplayed(final String message) {
        final String htmlSource = uiDriver.getPageSource();
        final int firstOccurence = htmlSource.indexOf(message);
        if(firstOccurence != -1) {
            errorCollector.addError(new Throwable(String.format("Message not expected [%s].", message)));
        }
    }

    public void failIfMessageExists(final String message) {
        if(uiDriver.getPageSource().contains(message)) {
            errorCollector.addError(new Throwable(String.format("Message not expected [%s].", message)));
            Assert.fail();
        }
    }

    public void verifyMultipleMessages(final List<String> message) {
        for(final String error : message) {
            verifyMessage(error);
        }
    }

}
