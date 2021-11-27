/*
    @MainMenuController.java
 */

package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Controller for MainMenu.fxml
 *
 * @author Makenna Halvensleben
 * @author Andrew Haddad
 * @author Adelia Rumpel
 *
 * @version 02 May 2021
 */
public class MainMenuController {
    private GraphicsEngine graphics = null;

    @FXML
    private Button startButton;

    public GraphicsEngine getGraphics() {
        return graphics;
    }

    public void setGraphics(GraphicsEngine graphics) {
        this.graphics = graphics;
    }

    @FXML
    void startLevel(ActionEvent event) {
        Stage stage = (Stage)startButton.getScene().getWindow();
        graphics.displayTopic();
        stage.close();
    }

}
