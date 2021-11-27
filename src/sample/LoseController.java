/*
    @LoseController.java
 */

package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Controller for lose.fxml
 *
 * @author Makenna Halvensleben
 * @author Andrew Haddad
 * @author Adelia Rumpel
 *
 * @version 02 May 2021
 */
public class LoseController {

    private GraphicsEngine graphics = null;

    public GraphicsEngine getGraphics() {
        return graphics;
    }

    public void setGraphics(GraphicsEngine graphics) {
        this.graphics = graphics;
    }

    /**
     * Displays the main menu
     *
     * @param event - when Main Menu button is clicked
     */
    @FXML
    void mainMenu(ActionEvent event) {
        if (graphics != null) {
            graphics.displayMainMenu();
            graphics.restartLevel();
        }
    }

    /**
     * Exits the application
     *
     * @param event - when the Quit button is clicked
     */
    @FXML
    void quit(ActionEvent event) {
        Platform.exit();
    }

}
