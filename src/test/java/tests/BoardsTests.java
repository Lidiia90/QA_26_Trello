package tests;

import dto.BoardDTO;
import dto.UserDTO;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.Random;

public class BoardsTests extends ApplicationManager {

    UserDTO user = UserDTO.builder()
            .email("liduska2004@ukr.net")
            .password("=6mw3#CUaB@s3JZ")
            .build();

    @Test
    public void createBoardPositive() {
        int i = new Random().nextInt(1000);
        BoardDTO board = BoardDTO.builder()
                .boardTitle("QA26-" + i)
                .build();
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.clickBtnLogin()
                .typeEmail(user)
                .typePassword(user)
                .typeBoardTitle(board)
                .clickBtnCreateSubmitPositive()
                .isTextInElementPresent_nameBoard(board.getBoardTitle()));
    }
    @Test
    public void createBoardNegative_emptyBoardTitle(){
        int i = new Random().nextInt(1000);
        BoardDTO board = BoardDTO.builder()
                .boardTitle("   ")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin()
                .typeEmail(user)
                .typePassword(user)
                .typeBoardTitle(board)
                .clickBtnCreateSubmitNegative();
    }
}