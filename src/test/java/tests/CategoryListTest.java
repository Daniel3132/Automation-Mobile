package tests;

import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.MapScreen;
import util.tests.BaseMobileTest;

public class CategoryListTest extends BaseMobileTest {

    /**
     * Validate categories are listed.
     */
    @Description(value = "tab category list")
    @Test()
    public void tapCategoryList() {
        log.info("open the list and check is a List container");
        MapScreen map = new MapScreen(getDriver());
        Assert.assertTrue(map.categoryListIsDisplayed(), "Categories container not displayed");
    }
}
