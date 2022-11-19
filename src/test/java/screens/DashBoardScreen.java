package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

/**
 * DashBoard screen.
 *
 * @author Hans.Marquez
 */
public class DashBoardScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button2\")")
    private AndroidElement dismissPreferenceUpdateButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"dismiss-icon\")")
    private AndroidElement dismissWelcome;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").description(\"Map, Tab, 2of5\")")
    private AndroidElement mapButton;

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     * @author Hans.Marquez
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * @author Hans.Marquez
     * Navigate to Login Screen from DashBoard Screen.
     */
    public MapScreen goToMapScreen() {
        if (this.isElementAvailable(dismissWelcome, 25)) {
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)) {
            click(dismissPreferenceUpdateButton);
        }
        click(mapButton);
        return new MapScreen(driver);
    }
}
