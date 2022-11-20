package screens.menu;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

import java.util.ArrayList;
import java.util.List;

public class PrivacyAndLegalScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/txt_element\")")
    private List<AndroidElement> optionsList;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Privacy & Legal\")")
    private AndroidElement title;

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public PrivacyAndLegalScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean checkTitleIsDisplayed(){
        return isElementAvailable(title);
    }

    public boolean allOptionsAreIncluded() {
        List<String> optionsNameList = new ArrayList<>();
        optionsNameList.add("Privacy Policy");
        optionsNameList.add("Terms of Use");
        optionsNameList.add("Supplemental Terms and Conditions");
        optionsNameList.add("Legal Notices");
        optionsNameList.add("Property Rules");
        optionsNameList.add("Electronic Communications Disclosure");

        StringBuilder failedCases = new StringBuilder();
        boolean isValid = true;

        for (int i = 0; i < optionsNameList.size(); i++) {
            if (  !optionsList.get(i).getText().equals(optionsNameList.get(i))  ) {
                failedCases.append(optionsList.get(i).getText()).append("\n");
                isValid = false;
            }
        }

        if (!isValid){
            log.warn("Options missing: \n" + failedCases);
        }
        return isValid;
    }

}
