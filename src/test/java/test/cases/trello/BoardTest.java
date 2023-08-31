package test.cases.trello;

import org.junit.Test;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;

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
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {
        login();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.moveCardToList("My new Card", "Doing");
        boardPage.assertCardIsMoved();

    }

    @Test
    public void deleteBoardWhenDeleteButtonIsClicked() {
        login();
        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.deleteBoard();

    }
}
