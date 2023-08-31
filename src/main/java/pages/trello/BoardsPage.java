package pages.trello;

import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class BoardsPage extends BaseTrelloPage {

    public BoardsPage(WebDriver driver) {
        super(driver, "trello.boardsPage");
    }

    public void createBoard() {

        String boardName = getUIMappingByKey("trello.boardName");

        actions.waitForElementClickable("trello.header.create.menuButton");
        actions.clickElement("trello.header.create.menuButton");

        actions.waitForElementClickable("trello.header.createBoard.dropDownButton");
        actions.clickElement("trello.header.createBoard.dropDownButton");

        actions.waitForElementClickable("trello.createBoard.titleInput");
        actions.typeValueInField(boardName, "trello.createBoard.titleInput");

        actions.waitForElementClickable("trello.create.board.submitButton");
        actions.clickElement("trello.create.board.submitButton");

    }

    public void clickOnBoard(String boardName) {
        actions.waitForElementVisible("trello.boardsPage.boardByTeamAndName", boardName);
        actions.clickElement("trello.boardsPage.boardByTeamAndName", boardName);
    }

    public void deleteBoard() {

        //Find and click on the existing board
        actions.waitForElementClickable("trello.boardPage.findBoard");
        actions.clickElement("trello.boardPage.findBoard");

        // Hover over the Board container
        actions.hoverOverElement("trello.boardsPage.boardContainer");

        actions.waitForElementClickable("trello.boardsPage.boardMenuOptions");

        actions.clickElement("trello.boardsPage.boardMenuOptions");
        //Click Close Board
        actions.waitForElementPresent("trello.boardsPage.closeBoardButton");
        actions.clickElement("trello.boardsPage.closeBoardButton");

        //Confirm Close
        actions.waitForElementPresent("trello.boardsPage.closeBoardButtonConfirm");
        actions.clickElement("trello.boardsPage.closeBoardButtonConfirm");
        //Wait for the Delete form to appear
        actions.waitForElementPresent("trello.boardsPage.closeBoardMessage");

//Click Permanently Delete
        actions.clickElement("trello.boardsPage.PermanentlyDeleteButton");
    }

    public void assertBoardIsDeleted() {
        actions.waitForElementNotPresent("trello.boardsPage.boardByTeamAndName", 10, "trello.boardPage.findBoard");

    }
}
