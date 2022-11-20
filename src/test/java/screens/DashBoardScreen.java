package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import screens.menu.MenuScreen;
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
    @AndroidFindBy(accessibility = "More Options, Tab, 5of5")
    private AndroidElement menuButton;

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     * @author Hans.Marquez
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public BaseScreen goToAScreen(String screenName) {
        if (this.isElementAvailable(dismissWelcome, 25)) {
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)) {
            click(dismissPreferenceUpdateButton);
        }
        switch (screenName) {
            case "map":
                click(mapButton);
                return new MapScreen(driver);
            case "menu":
                click(menuButton);
                return new MenuScreen(driver);
            default:
                System.out.println("Incorrect screen value");
                return null;
        }
    }
}
