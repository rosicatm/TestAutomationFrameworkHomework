package pages.trello;

import org.openqa.selenium.WebDriver;

public class BoardPage extends BaseTrelloPage {

    public BoardPage(WebDriver driver) {
        super(driver, "trello.boardPage");
    }

    public void addCardToList(String cardName) {
        //Find the existing board
        actions.waitForElementClickable("trello.boardPage.findBoard");
        actions.clickElement("trello.boardPage.findBoard");


        // Find the "Add Card" button in the list and click it
        actions.waitForElementClickable("trello.boardPage.addCardButton");
        actions.clickElement("trello.boardPage.addCardButton");

        // Input the card name
        actions.waitForElementPresent("trello.boardPage.cardName");
        actions.typeValueInField(cardName, "trello.boardPage.cardName");

        // Click the "Submit" button to create the card
        actions.clickElement("trello.boardPage.submitNewCard");

        // Assert the presence of the new card
        actions.waitForElementPresent("trello.boardPage.cardByName");
    }

    public void moveCardToList(String cardName, String listName) {

        //Find the existing board
        actions.waitForElementClickable("trello.boardPage.findBoard");
        actions.clickElement("trello.boardPage.findBoard");

        // Wait for the presence of the new card
        actions.waitForElementPresent("trello.boardPage.cardByName");
        //Drag the source and drop the location
        actions.selectOptionsFromDragAndDrop("trello.boardPage.sourceLocator", "trello.boardPage.targetLocator");
    }


    public void assertListExists(String listName) {
        actions.waitForElementPresent("trello.boardPage.listByName", listName);
    }

    public void assertAddListExists() {
        actions.waitForElementPresent("trello.boardPage.listWrapper");
    }

    public void assertCardExists() {
        actions.waitForElementPresent("//a[@data-testid='trello-card']");
    }

    public void assertCardIsMoved() {
        actions.waitForElementPresent("//a[@data-testid='trello-card']");
    }

}
