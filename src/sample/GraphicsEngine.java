/*
  @GraphicsEngine.java
 */

package sample;

import Tasks.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Random;

/**
 * Contains the methods to display the variety of stages needed in the user interface
 *
 * @author Makenna Halvensleben
 * @author Andrew Haddad
 * @author Adelia Rumpel
 *
 * @version 02 May 2021
 */
public class GraphicsEngine {

    private InputManager input;
    private Level level;
    private Stage taskStage;
    private Stage impostorStage;
    private Stage optionsStage;
    private Stage victoryStage;
    private Stage loseStage;
    private Stage topicStage;
    private Stage mainMenuStage;
    private Group group;
    private Node impostor;
    private Random r = new Random();
    private int dx;
    private int dy;
    private boolean lost;

    /**
     * Initializes the instance variables
     *
     * @param character - node that holds the image of the character
     */
    public GraphicsEngine(Node character, Node impostor)
    {
        taskStage = new Stage();
        impostorStage = new Stage();
        optionsStage = new Stage();
        victoryStage = new Stage();
        loseStage = new Stage();
        topicStage = new Stage();
        mainMenuStage = new Stage();
        group = new Group();
        level = new Level();
        input = new InputManager(character);
        this.impostor = impostor;
        lost = false;
        dx = 4;
        dy = 1;
    }

    public Stage getTaskStage() {
        return taskStage;
    }

    public void setTaskStage(Stage taskStage) {
        this.taskStage = taskStage;
    }

    public InputManager getInput() {
        return input;
    }

    public void setInput(InputManager input) {
        this.input = input;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Node getImpostor() {
        return impostor;
    }

    public void setImpostor(Node impostor) {
        this.impostor = impostor;
    }

    public Stage getImpostorStage() {
        return impostorStage;
    }

    public Stage getTopicStage() {
        return topicStage;
    }

    public void setTopicStage(Stage topicStage) {
        this.topicStage = topicStage;
    }

    public Stage getMainMenuStage() {
        return mainMenuStage;
    }

    public void setMainMenuStage(Stage mainMenuStage) {
        this.mainMenuStage = mainMenuStage;
    }

    public void setImpostorStage(Stage impostorStage) {
        this.impostorStage = impostorStage;
    }

    public Stage getVictoryStage() {
        return victoryStage;
    }

    public void setVictoryStage(Stage victoryStage) {
        this.victoryStage = victoryStage;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Stage getOptionsStage() {
        return optionsStage;
    }

    public void setOptionsStage(Stage optionsStage) {
        this.optionsStage = optionsStage;
    }

    public boolean getLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public Stage getLoseStage() {
        return loseStage;
    }

    public void setLoseStage(Stage loseStage) {
        this.loseStage = loseStage;
    }

    /**
     * Creates the scene with the map.fxml design and character node
     *
     * @return the scene with the map design
     * @throws Exception - needed to load the fxml file
     */
    public Scene displayMap() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("map.fxml"));
        input.getCharacter().setLayoutX(200);
        input.getCharacter().setLayoutY(200);
        Node load = loader.load();
        load.setUserData(loader);
        group.getChildren().add(load);
        group.getChildren().add(input.getCharacter());
        group.getChildren().add(impostor);

        MapController controller = loader.getController();
        controller.setGraphics(this);
        return new Scene(group);
    }

    /**
     * Displays the taskStage with task.fxml as the template
     *
     * @param task - Solvable object that contains information needed to display and complete the task
     */
    public void displayTask(Solvable task) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("task.fxml"));
        Group m = new Group();
        try {
            m.getChildren().add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(m, 600, 400);

        taskStage.setScene(scene);
        taskStage.setTitle("Task");

        TextArea question = (TextArea)m.getChildren().get(0).lookup("#question");
        question.setText(task.displayQuestion());
        Label correctAnswer = (Label)m.getChildren().get(0).lookup("#correctAnswer");
        correctAnswer.setText(task.getCorrectAnswer());
        Label name = (Label)m.getChildren().get(0).lookup("#name");
        name.setText(task.getName());

        taskStage.setOnCloseRequest((event)->event.consume());
        taskStage.show();
    }

    /**
     * Displays the impostorStage with impostorTask.fxml as the template
     */
    public void displayImpostorTask(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("impostorTask.fxml"));
        Group root = new Group();
        try {
            root.getChildren().add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        impostorStage.setScene(scene);
        impostorStage.setTitle("Task");
        impostorStage.setOnCloseRequest((event)->event.consume());
        impostorStage.show();

        ImpostorTaskController controller = loader.getController();
        controller.setGraphics(this);
    }

    /**
     * Displays the optionsStage with options.fxml as the template
     */
    public void displayOptions(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("options.fxml"));
        Group root = new Group();
        try {
            root.getChildren().add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        optionsStage.setScene(scene);
        optionsStage.show();

        OptionsController controller = loader.getController();
        controller.setGraphics(this);
    }

    /**
     * Displays the victoryStage with victory.fxml as the template
     */
    public void displayVictoryMessage(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("victory.fxml"));
        Group root = new Group();
        try {
            root.getChildren().add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        victoryStage.setScene(scene);
        victoryStage.show();

        VictoryController controller = loader.getController();
        controller.setGraphics(this);
    }

    /**
     * Displays the loseStage with lose.fxml as the template
     */
    public void displayLoseMessage()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("lose.fxml"));
        Group root = new Group();
        try {
            root.getChildren().add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        loseStage.setScene(scene);
        loseStage.show();

        LoseController controller = loader.getController();
        controller.setGraphics(this);
    }

    /**
     * Displays the mainMenuStage with mainMenu.fxml as the template
     */
    public void displayMainMenu(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Group root = new Group();
        try {
            root.getChildren().add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        mainMenuStage.setScene(scene);
        mainMenuStage.setTitle("Main Menu");
        mainMenuStage.show();

        MainMenuController controller = loader.getController();
        controller.setGraphics(this);

        //when at the main menu, all other stages should be closed
        taskStage.close();
        impostorStage.close();
        optionsStage.close();
        victoryStage.close();
        loseStage.close();
        topicStage.close();
        if(group.getScene().getWindow() != null)
        {
            Stage primaryStage = (Stage)group.getScene().getWindow();
            primaryStage.close();
        }
    }

    /**
     * Displays the topicStage with topic.fxml as the template
     */
    public void displayTopic(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Topic.fxml"));
        Group root = new Group();
        try {
            root.getChildren().add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        topicStage.setScene(scene);
        topicStage.setTitle("Topic");
        topicStage.show();

        Topic controller = loader.getController();
        controller.setGraphics(this);
    }

    /**
     * Relocates the impostor and resets the movement paths so that it bounces off the walls
     */
    public void moveImpostor()
    {
        final double cx = impostor.getBoundsInLocal().getWidth()  / 2;
        final double cy = impostor.getBoundsInLocal().getHeight() / 2;

        double x = cx + impostor.getLayoutX() + dx;
        double y = cy + impostor.getLayoutY() + dy;

        if ((x - cx >= 0) &&
                (x + cx <= 450) &&
                (y - cy >= 0) &&
                (y + cy <= 450)) {
            impostor.relocate(x - cx, y - cy);
        }
        else if (x - cx < 0)
        {
            dx = (r.nextInt(4) + 1);
            dy = -1*(r.nextInt(4) + 1);
        }
        else if(x + cx > 450)
        {
            dx = -1*(r.nextInt(4) + 1);
            dy = (r.nextInt(4) + 1);
        }
        else if(y - cy < 0)
        {
            dx = (r.nextInt(4) + 1);
            dy = (r.nextInt(4) + 1);
        }
        else
        {
            dx = -1*(r.nextInt(4) + 1);
            dy = -1*(r.nextInt(4) + 1);
        }
    }

    /**
     * Checks to see if the character and impostor run into each other
     *
     * @return if the two nodes collide
     */
    public boolean collided()
    {
        double charX = input.getCharacter().getLayoutX();
        double charY = input.getCharacter().getLayoutY();
        double impX = impostor.getLayoutX();
        double impY = impostor.getLayoutY();

        //Adapted from the CollidedWith function in Arghya Das's MyObject.cpp file
        return (charX + 50) >= impX
                && (impX + 50) >= charX
                && (charY + 60) >= impY
                && (impY + 50) >= charY;
    }

    /**
     * Restarts the level by setting all completed tasks back to the incomplete state
     */
    public void restartLevel()
    {
        for(int i = 0; i < 8; i++)
        {
            level.getTasks()[i].setCompleted(false);
            level.getTasks()[i].setAccessed(false);
            TilePane tile = (TilePane) group.getChildren().get(0).lookup("#tile" + i);
            tile.getStyleClass().clear();
            tile.getStyleClass().add("task" + i);
            Label label = (Label) group.getChildren().get(0).lookup("#label" + i);
            label.lookup(".text").setStyle("-fx-strikethrough: false");
        }
        ProgressBar b = (ProgressBar)this.getGroup().getChildren().get(0).lookup("#progressBar");
        b.setProgress(0);
        input.getCharacter().setLayoutY(200);
        input.getCharacter().setLayoutX(200);
        impostor.setLayoutX(0);
        impostor.setLayoutY(0);
    }

    /**
     * Checks to see if any stages are open, used to stop character motion in Main.java
     *
     * @return if a stage is showing
     */
    public boolean stageIsShowing()
    {
        if(mainMenuStage.isShowing())
        {
            return true;
        }
        else if(impostorStage.isShowing())
        {
            return true;
        }
        else if(optionsStage.isShowing())
        {
            return true;
        }
        else if(topicStage.isShowing())
        {
            return true;
        }
        return false;
    }

}
