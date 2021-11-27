/*
    @Topic.java
 */

package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Controller for topic.fxml
 *
 * @author Makenna Halvensleben
 * @author Andrew Haddad
 * @author Adelia Rumpel
 *
 * @version 02 May 2021
 */
public class Topic {

    private GraphicsEngine graphics = null;

    public GraphicsEngine getGraphics() {
        return graphics;
    }

    public void setGraphics(GraphicsEngine graphics) {
        this.graphics = graphics;
    }

    @FXML
    private ScrollPane topic1;

    @FXML
    private Button continueButton;

    @FXML
    void next(ActionEvent event) {
        Stage stage = (Stage)continueButton.getScene().getWindow();
        stage.close();
        Stage map = null;
        try {
            map = (Stage)graphics.getGroup().getScene().getWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.show();
    }
}
