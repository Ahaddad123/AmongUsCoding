/*
  @TaskController.java
 */

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller for task.fxml
 *
 * @author Makenna Halvensleben
 * @author Andrew Haddad
 * @author Adelia Rumpel
 *
 * @version 02 May 2021
 */
public class TaskController {

    @FXML
    private Label name;

    @FXML
    private TextField answer;

    @FXML
    private Button submitButton;

    @FXML
    private Label correctAnswer;

    @FXML
    private Label incorrect;

    @FXML
    private TextArea question;

    /**
     * If the user put the correct answer into the text field,
     * after clicking submit the task window will close.
     * Otherwise, a wrong answer message will display.
     *
     * @param event - if button clicked
     */
    @FXML
    void submit(ActionEvent event) {
        Stage stage = (Stage) submitButton.getScene().getWindow();

        if(answer.getText().equals(correctAnswer.getText()))
        {
            incorrect.setVisible(false);
            stage.close();
        }
        else
        {
            incorrect.setVisible(true);
        }
    }
}