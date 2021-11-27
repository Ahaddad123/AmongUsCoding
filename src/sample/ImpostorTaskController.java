/*
  @ImpostorTaskController.java
 */

package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Controller for impostorTask.fxml
 *
 * @author Makenna Halvensleben
 * @author Andrew Haddad
 * @author Adelia Rumpel
 *
 * @version 02 May 2021
 */
public class ImpostorTaskController {

    private GraphicsEngine graphics = null;

    public GraphicsEngine getGraphics() {
        return graphics;
    }

    public void setGraphics(GraphicsEngine graphics) {
        this.graphics = graphics;
    }

    //controls the progress bar
    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            bar.setProgress(bar.getProgress() + 0.0005);
            if(bar.getProgress() >= 1)
            {
                if(graphics != null)
                {
                    stop();
                    bar.setProgress(0);
                    graphics.setLost(true);
                    Stage stage = (Stage)bar.getScene().getWindow();
                    stage.close();
                }
            }
        }
    };

    private int numberCorrect;
    private Random r = new Random();
    private int left;
    private int right;

    @FXML
    private ProgressBar bar;

    @FXML
    private Label question;

    @FXML
    private TextField answerText;

    @FXML
    private Label correct;

    @FXML
    private Label count;

    /**
     * Starts timer and displays question and answer box
     *
     * @param event - when start button is clicked
     */
    @FXML
    void startTask(ActionEvent event) {
        newQuestion();
        question.setText(left + " x " + right);
        numberCorrect = 0;
        question.setVisible(true);
        answerText.setVisible(true);
        correct.setVisible(true);
        count.setVisible(true);
        timer.start();
    }

    /**
     * Displays a new multiplication question
     */
    public void newQuestion()
    {
        left = r.nextInt(11);
        right = r.nextInt(11);
    }

    /**
     * Checks to see if the multiplication problem was answered correctly
     * Increments number correct and displays new question
     *
     * @param event - when enter key is typed
     */
    @FXML
    void enter(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER)
        {
            if(answerText.getText().equals(left * right + ""))
            {
                numberCorrect++;
                count.setText(numberCorrect + "");
                answerText.setText("");
                newQuestion();
                question.setText(left + " x " + right);
                if(numberCorrect == 10)
                {
                    timer.stop();
                    bar.setProgress(0);
                    Stage stage = (Stage)bar.getScene().getWindow();
                    stage.close();
                }
            }
        }
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}
