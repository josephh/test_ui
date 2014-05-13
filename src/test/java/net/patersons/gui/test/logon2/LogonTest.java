package net.patersons.gui.test.logon2;

import java.io.IOException;
import net.patersons.gui.test.entity.UserLogonDetails;
import net.patersons.gui.test.helper.TestDataHelper;
import net.patersons.gui.test.interaction.LogonInteraction;
import org.junit.Test;

public class LogonTest extends GuiIntegrationTest {

    @Test
    public void verifyLogon() throws IOException {
        UserLogonDetails userLogonDetails = new TestDataHelper().getUserLogonDetails(false);
        new LogonInteraction(userLogonDetails).enterLogonDetails().verifyLogon();
    }
    
    @Test
    public void verifyLogout() throws IOException {
        UserLogonDetails userLogonDetails = new TestDataHelper().getUserLogonDetails(false);
        new LogonInteraction(userLogonDetails).enterLogonDetails().verifyLogon().logout().verifyLogout();
    }

    @Test
    public void verifyChangePassword() throws IOException {
        UserLogonDetails userLogonDetails = new TestDataHelper().getUserLogonDetails(false);
//        new LogonAction(userLogonDetails).enterLogonDetails().verifyLogon().changePassword();
        new LogonInteraction(userLogonDetails).enterLogonDetails().verifyLogon().verifyLogout();
    }
    
       
    
}
