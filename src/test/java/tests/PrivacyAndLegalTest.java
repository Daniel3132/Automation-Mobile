package tests;

import org.testng.annotations.Test;
import screens.DashBoardScreen;
import util.tests.BaseMobileTest;

public class PrivacyAndLegalTest extends BaseMobileTest {

    @Test
    public void navigateDashboard(){
        DashBoardScreen dashBoard = loadDashBoardScreen();

    }
}
