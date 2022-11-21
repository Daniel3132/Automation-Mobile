package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.DashBoardScreen;
import util.tests.BaseMobileTest;

public class AddPlansTest extends BaseMobileTest {

    @Test
    public void AddPlans(){
        log.info("Go to dashboard Screen");
        DashBoardScreen dashboard = loadDashBoardScreen();
        dashboard.dismissOptions();

        log.info("Navigate to Add Plans");
        dashboard.openAddPlans();

        log.info("Validate Reserve Dining option is enabled");
        Assert.assertTrue( dashboard.reserveDiningOptionIsEnabled(), "Reserve Dining option is not enabled" );
    }
}
