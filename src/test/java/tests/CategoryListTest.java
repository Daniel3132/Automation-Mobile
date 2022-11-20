package tests;

import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.DashBoardScreen;
import screens.MapScreen;
import util.screens.BaseScreen;
import util.tests.BaseMobileTest;

public class CategoryListTest extends BaseMobileTest {

    /**
     * Validate Map Screen Navigation.
     */
    @Description(value = "Map screen Navigation test")
    @Test()
    public void navigateToMapScreen() {
        log.info("Start Navigation to Map Screen");
        DashBoardScreen dashBoard = loadDashBoardScreen();
        MapScreen map = (MapScreen) dashBoard.goToAScreen("map");

        log.info("Validate Show List Button");
        Assert.assertTrue(map.showListIsDisplayed(), "Show List not displayed");

        log.info("Validate Category Button");
        Assert.assertTrue(map.categoryIsDisplayed(), "Category not displayed");

        log.info("Validate Filter Button");
        Assert.assertTrue(map.filterIsDisplayed(), "Filter not displayed");

        tapCategoryList(map);
    }

    public void tapCategoryList(MapScreen map) {
        log.info("Validate Attractions option is selected by default");
        Assert.assertTrue(map.attractionIsSelected(), "Attractions option not selected");

        log.info("Open the list to check is a List container");
        Assert.assertTrue(map.categoryListIsDisplayed(), "Categories container not displayed");

        log.info("Validate there are eleven options");
        Assert.assertTrue(map.categoriesOptionSizeIs11(), "There are not eleven options");

        log.info("Validate there is a 'Hotels' Option");
        Assert.assertTrue(map.checkHotelsOptionIsAvailable(), "'Hotels' option is missing");

        log.info("Validate there are all categories named correct");
        Assert.assertTrue(map.allCategoriesAreIncluded(), "There is one or more categories missing");
    }

}
