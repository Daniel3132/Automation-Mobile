package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;


/**
 * Object of the first screen that appears when we open the application.
 *
 * @author Arley.Bolivar
 */

public class TutorialScreen extends BaseScreen {

    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/permission_primary_btn")
    private AndroidElement getStartedButton;
    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/permission_primary_btn")
    private AndroidElement shareLocationButton;
    @AndroidFindBy(id = "android:id/button1")
    private AndroidElement allowLocationButton;
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private AndroidElement allowButton;

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Arley.Bolivar
     */
    public TutorialScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * @author Hans.Marquez
     * Start permissions process.
     */
    public void startPermissionsProcess() {
        click(getStartedButton);
    }

    /**
     * @author Hans.Marquez
     * Share Location permissions process.
     */
    public DashBoardScreen shareLocationPermissions() {
        click(shareLocationButton);
        click(allowLocationButton);
        click(allowButton);
        return new DashBoardScreen(driver);
    }
}
