package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

import java.util.ArrayList;
import java.util.List;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

// TODO: Auto-generated Javadoc

/**
 * Map screen.
 *
 * @author Hans.Marquez
 */
public class MapScreen extends BaseScreen {

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filterTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filter\")")
    private AndroidElement filterButton;
    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*toggleTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Show List\")")
    private AndroidElement showListButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle\")")
    private AndroidElement categoryListTitle;
    @AndroidFindBy(id = "com.disney.wdpro.dlr:id/facilityTypeList")
    private AndroidElement categoryListContainer;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.LinearLayout\").descriptionContains(\"Category\")")
    private List<AndroidElement> categoriesOptionsList;

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Hans.Marquez
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * @author Hans.Marquez
     * return true if Category List element is displayed in screen, otherwise false.
     */
    public boolean categoryIsDisplayed() {
        return isElementAvailable(categoryListTitle);
    }

    /**
     * @author Hans.Marquez
     * return true if Filter Button element is displayed in screen, otherwise false.
     */
    public boolean filterIsDisplayed() {
        return isElementAvailable(filterButton);
    }

    /**
     * @author Hans.Marquez
     * return true if Show List Button element is displayed in screen, otherwise false.
     */
    public boolean showListIsDisplayed() {
        return isElementAvailable(showListButton);
    }

    /**
     * @author Daniel.Correa
     * Open the list and check is a List container
     */
    public boolean categoryListIsDisplayed() {
        click(categoryListTitle);
        return isElementAvailable(categoryListContainer);
    }

    /**
     * @author Daniel.Correa
     * Check the Title to prove attractions is selected
     */
    public boolean attractionIsSelected() {
        return categoryListTitle.getText().equals("Attractions");
    }

    /**
     * @author Daniel.Correa
     * Check the Title to prove attractions is selected
     */
    public boolean checkHotelsOptionIsAvailable() {
        for (AndroidElement androidElement : categoriesOptionsList) {
            if (androidElement.getTagName().contains("Hotels")) {
                return true;
            }
        }
        return false;
    }

    /**
     * @author Daniel.Correa
     * Open the list and check is a List container
     */
    public boolean categoriesOptionSizeIs11() {
        return categoriesOptionsList.size() == 11;
    }

    /**
     * @author Daniel.Correa
     * Validate all categories name
     */
    public boolean allCategoriesAreIncluded() {
        List<String> categoriesNameList = new ArrayList<>();
        categoriesNameList.add("Attractions");
        categoriesNameList.add("Characters");
        categoriesNameList.add("Dining");
        categoriesNameList.add("Entertainment");
        categoriesNameList.add("Restrooms");
        categoriesNameList.add("Events and Tours");
        categoriesNameList.add("PhotoPass");
        categoriesNameList.add("Guest Services");
        categoriesNameList.add("Shops");
        categoriesNameList.add("Hotels");
        categoriesNameList.add("Spa and Recreation");

        StringBuilder failedCases = new StringBuilder();
        boolean isValid = true;

        for (int i = 0; i < categoriesOptionsList.size(); i++) {
            if (!categoriesOptionsList.get(i).getTagName().contains(categoriesNameList.get(i))) {
                isValid = false;
                failedCases.append(categoriesOptionsList.get(i).getTagName()).append("\n");
            }
        }

        if (!isValid) {
            log.warn("Categories missing: \n" + failedCases);
        }
        return isValid;
    }


}
