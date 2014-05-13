package net.patersons.gui.test.logon2.page;

import java.io.IOException;
import net.patersons.gui.test.entity.UserLogonDetails;
import net.patersons.gui.test.helper.PropertyFileHelper;

public class LogonPage extends BasePage {

    private UserLogonDetails userLogonDetails;

    public void logon() {
        browser.wait(2000);
        browser.input(props.getProperty("username-field-id"), userLogonDetails.getUsername());
        browser.input(props.getProperty("password-field-id"), userLogonDetails.getUserpassword());
        browser.input(props.getProperty("company-number-field-id"), userLogonDetails.getCompanyNo());
        browser.click(props.getProperty("login-input-id"));
    }
    
    public void open() {
        browser.open(props.getProperty("url"));
    }

    public LogonPage(UserLogonDetails userLogonDetails) throws IOException {
        super();
        this.userLogonDetails = userLogonDetails;
        PropertyFileHelper pl = new PropertyFileHelper(testPropertiesFileName());
        this.props = pl.load();
    }

    @Override
    protected String testPropertiesFileName() {
        return PropertyFileHelper.propertiesFileName(this.getClass());
    }
    
    public void verifyLogout() {
        verification.verifyTrue(browser.isTextPresent(props.getProperty("logout-success-message")));        
    }

    public void changePassword() {
        // TODO Auto-generated method stub
        
    }
}
