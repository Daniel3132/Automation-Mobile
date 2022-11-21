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
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tab_animated_icon\")")
    private AndroidElement addPlansButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/actionSheetItemText\")")
    private AndroidElement reserveDiningOption;

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     * @author Hans.Marquez
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void openAddPlans() {
        click(addPlansButton);
    }

    public boolean reserveDiningOptionIsEnabled() {
        return reserveDiningOption.isEnabled();
    }

    /**
     * Check if app ask for welcome or update confirmation and skip them.
     */
    public void dismissOptions() {
        if (this.isElementAvailable(dismissWelcome, 25)) {
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)) {
            click(dismissPreferenceUpdateButton);
        }
    }

    /**
     * Go to the Map or the Menu Screen.
     *
     * @param screenName
     * @return The chosen Screen returned as a BaseScreen and needs to be cast.
     */
    public BaseScreen goToAScreen(String screenName) {
        dismissOptions();
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
