/*
  @MapController.java
 */

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.TilePane;

/**
 * Controller for map.fxml
 *
 * @author Makenna Halvensleben
 * @author Andrew Haddad
 * @author Adelia Rumpel
 *
 * @version 02 May 2021
 */
public class MapController {

    private GraphicsEngine graphics = null;

    @FXML
    private TilePane tile0;

    @FXML
    private TilePane tile1;

    @FXML
    private TilePane tile2;

    @FXML
    private TilePane tile3;

    @FXML
    private TilePane tile4;

    @FXML
    private TilePane tile5;

    @FXML
    private TilePane tile6;

    @FXML
    private TilePane tile7;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label label0;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    public GraphicsEngine getGraphics() {
        return graphics;
    }

    public void setGraphics(GraphicsEngine graphics) {
        this.graphics = graphics;
    }

    /**
     * Displays the options panel
     *
     * @param event - when Options button is clicked
     */
    @FXML
    void displayOptions(ActionEvent event) {
        if(this.graphics != null)
        {
            graphics.displayOptions();
        }
    }

    /**
     * Displays topic information
     *
     * @param event - when See Topic button is clicked
     */
    @FXML
    void displayTopic(ActionEvent event) {
        if(this.graphics != null)
        {
            graphics.displayTopic();
        }
    }

}
