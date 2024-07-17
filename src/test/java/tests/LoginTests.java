package tests;

import dto.UserDTO;
import manager.ApplicationManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends ApplicationManager {

    UserDTO user = UserDTO.builder()
            .email("liduska2004@ukr.net")
            .password("=6mw3#CUaB@s3JZ")
            .build();

    @Test
    public void loginTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin()
        .typeEmail(user)
                .typePassword(user);
    }
    }
