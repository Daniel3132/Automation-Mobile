package screens.menu;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

public class MenuScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "My Profile button")
    private AndroidElement myProfileButton;
    @AndroidFindBy(accessibility = "Property Rules button")
    private AndroidElement propertyRulesButton;
    @AndroidFindBy(accessibility = "Cast Compliment button")
    private AndroidElement castComplimentButton;
    @AndroidFindBy(accessibility = "Link to Account button")
    private AndroidElement linkToAccountButton;
    @AndroidFindBy(accessibility = "Car Locator button")
    private AndroidElement carLocatorButton;
    @AndroidFindBy(accessibility = "Help button")
    private AndroidElement helpButton;
    @AndroidFindBy(accessibility = "Privacy & Legal button")
    private AndroidElement privacyAndLegalButton;

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public MenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean myProfileIsDisplayed() {
        return isElementAvailable(myProfileButton);
    }

    public boolean propertyRulesIsDisplayed() {
        return isElementAvailable(propertyRulesButton);
    }

    public boolean castComplimentIsDisplayed() {
        return isElementAvailable(castComplimentButton);
    }

    public boolean linkToAccountIsDisplayed() {
        return isElementAvailable(linkToAccountButton);
    }

    public boolean carLocatorIsDisplayed() {
        return isElementAvailable(carLocatorButton);
    }

    public boolean helpIsDisplayed() {
        return isElementAvailable(helpButton);
    }

    public boolean privacyAndLegalIsDisplayed() {
        return isElementAvailable(privacyAndLegalButton);
    }

    public PrivacyAndLegalScreen goToPrivacyAndLegal(){
        click(privacyAndLegalButton);
        return new PrivacyAndLegalScreen(driver);
    }
}
