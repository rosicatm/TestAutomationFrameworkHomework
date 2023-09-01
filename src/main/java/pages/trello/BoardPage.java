package pages.trello;

import org.openqa.selenium.WebDriver;

public class BoardPage extends BaseTrelloPage {

    public BoardPage(WebDriver driver) {
        super(driver, "trello.boardPage");
    }

    public void addCardToList(String cardName) {

        actions.waitForElementClickable("trello.boardPage.findBoard");
        actions.clickElement("trello.boardPage.findBoard");

        actions.waitForElementClickable("trello.boardPage.addCardButton");
        actions.clickElement("trello.boardPage.addCardButton");

        actions.waitForElementPresent("trello.boardPage.cardName");
        actions.typeValueInField(cardName, "trello.boardPage.cardName");

        actions.clickElement("trello.boardPage.submitNewCard");

        actions.waitForElementPresent("trello.boardPage.cardByName");
    }

    public void moveCardToList(String cardName, String listName) {

        actions.waitForElementClickable("trello.boardPage.findBoard");
        actions.clickElement("trello.boardPage.findBoard");

        actions.waitForElementPresent("trello.boardPage.cardByName");
        //Drag the  and drop the location - to "Doing" and then "Done"
        actions.selectOptionsFromDragAndDrop("trello.boardPage.sourceLocator", "trello.boardPage.targetLocator");
    }

    public void assertListExists(String listName) {
        actions.waitForElementPresent("trello.boardPage.listByName", listName);
    }

    public void assertAddListExists() {
        actions.waitForElementPresent("trello.boardPage.listWrapper");
    }

    public void assertCardExists() {
        actions.waitForElementPresent("trello.boardPage.cardByName");
    }

    public void assertCardIsMoved(String listName, String cardName) {
        actions.waitForElementPresent("trello.boardPage.cardByName", listName, cardName);
    }
}
