package net.patersons.gui.test.logon2.page;

import java.io.IOException;
import net.patersons.gui.test.helper.PropertyFileHelper;

public class HomePage extends BasePage {

    public HomePage() throws IOException {
        super();
        PropertyFileHelper pl = new PropertyFileHelper(testPropertiesFileName());
        this.props = pl.load();
    }
    
    public void navigateToLogonPage() throws IOException {
        if(browser.isTextPresent((props).getProperty("LOGOUT-header-menu"))) {
            browser.clickWithLinkText(props.getProperty("LOGOUT-header-menu"));
        }
        browser.wait(2000);
    }

    @Override
    protected String testPropertiesFileName() {
        return PropertyFileHelper.propertiesFileName(this.getClass());
    }
    
    public void verifyLogon() {
        verification.verifyTrue(browser.isTextPresent(props.getProperty("logon-success-message")));        
    }
    
    public void logout() {
        browser.wait(2000);
        if(browser.isTextPresent(props.getProperty("LOGOUT-header-menu"))){
            browser.hoverOver(props.getProperty("LOGOUT-header-menu"));
        }
    }

}
