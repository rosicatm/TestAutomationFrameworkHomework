package test.cases.trello;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BoardTest extends BaseTest {

    @Test
    public void createBoardWhenCreateBoardClicked() {
        login();

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.assertAddListExists();
        boardPage.assertListExists("To Do");
    }

    @Test
    public void createNewCardInExistingBoardWhenCreateCardClicked() {
        login();

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.clickOnBoard("My First Board");

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.addCardToList("My new Card");
        boardPage.assertCardExists();
    }

    @Test
    public void createdCardMovedBetweenStatesWhenDragAndDropIsUsed() {
        login();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.moveCardToList("My new Card", "Doing");
        boardPage.assertCardIsMoved("Doing", "My new Card");
    }

    @Test
    public void deleteBoardWhenDeleteButtonIsClicked() {
        login();
        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.deleteBoard();
        boardsPage.assertBoardIsDeleted();
    }
}
