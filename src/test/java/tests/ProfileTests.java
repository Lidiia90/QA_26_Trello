package tests;

import manager.ApplicationManager;
import helper.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProfileAndVisibility;

public class ProfileTests extends ApplicationManager {

//    UserDTO user = UserDTO.builder()
//            .email("liduska2004@ukr.net")
//            .password("=6mw3#CUaB@s3JZ")
//            .build();

    ProfileAndVisibility profileAndVisibility;

    @BeforeMethod
    public void loginBeforeProfile() {
        HomePage homePage = new HomePage(getDriver());
        profileAndVisibility = homePage.clickBtnLogin()
                .typeEmail(user)
                .typePassword(user)
                .goToProfileAndVisibility();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void changeProfilePhotoPositiveTest() {
        Assert.assertTrue(profileAndVisibility.changeAvatar("cute-small-dog_881317-363.jpg")
                .isTextInElementPresent_AvatarAdded());
    }

    @Test(invocationCount = 1)
    public void changeProfilePhotoNegativeTest_wrongFileFormat() {
        Assert.assertTrue(profileAndVisibility.changeAvatar("log-20240731T190855.log")
                .isTextInElementPresent_WrongFileFormat());

    }
}