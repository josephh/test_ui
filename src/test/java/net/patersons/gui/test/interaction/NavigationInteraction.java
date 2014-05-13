package net.patersons.gui.test.interaction;

import java.io.IOException;
import net.patersons.gui.test.entity.UserLogonDetails;
import net.patersons.gui.test.logon2.page.HomePage;

public class NavigationInteraction {

    public LogonInteraction navigateToLogonPage(UserLogonDetails userLogonDetails) throws IOException {
        HomePage homePage = new HomePage();
        homePage.navigateToLogonPage();
        return new LogonInteraction(userLogonDetails);
    }

}
