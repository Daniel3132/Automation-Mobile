package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.DashBoardScreen;
import screens.menu.MenuScreen;
import screens.menu.PrivacyAndLegalScreen;
import util.tests.BaseMobileTest;

public class PrivacyAndLegalTest extends BaseMobileTest {

    /**
     * Open the burger menu, validate the menu screen and all it's options.
     */
    @Test
    public void navigateMenu() {
        log.info("Go to dashboard Screen");
        DashBoardScreen dashBoard = loadDashBoardScreen();

        log.info("Start Navigation to Menu Screen");
        MenuScreen menu = (MenuScreen) dashBoard.goToAScreen("menu");

        log.info("Scroll down");
        menu.swipeVerticalToEnd();

        log.info("Validate different categories are listed to select");
        validateCategories(menu);

        log.info("Go to Privacy And Legal Screen");
        PrivacyAndLegalScreen privacy = menu.goToPrivacyAndLegal();

        log.info("Validate Page Title is Displayed");
        Assert.assertTrue(privacy.checkTitleIsDisplayed(), "Title is not displayed");

        log.info("Validate options List is displayed");
        Assert.assertTrue(privacy.allOptionsAreIncluded(), "One or more options not displayed");
    }

    /**
     * A method for assert only the options in the list.
     * @param menu
     */
    public void validateCategories(MenuScreen menu){
        log.info("Validate My profile option is Displayed");
        Assert.assertTrue(menu.myProfileIsDisplayed(), "My profile option not displayed");

        log.info("Validate Property Rules option is Displayed");
        Assert.assertTrue(menu.propertyRulesIsDisplayed(), "Property Rules option not displayed");

        log.info("Validate Cast Compliment option is Displayed");
        Assert.assertTrue(menu.castComplimentIsDisplayed(), "Cast Compliment option not displayed");

        log.info("Validate Link to Account option is Displayed");
        Assert.assertTrue(menu.linkToAccountIsDisplayed(), "Link to Account option not displayed");

        log.info("Validate Car locator option is Displayed");
        Assert.assertTrue(menu.carLocatorIsDisplayed(), "Car locator option not displayed");

        log.info("Validate Help option is Displayed");
        Assert.assertTrue(menu.helpIsDisplayed(), "Help option not displayed");

        log.info("Validate Privacy and Legal option is Displayed");
        Assert.assertTrue(menu.privacyAndLegalIsDisplayed(), "Privacy and Legal option not displayed");
    }

}
