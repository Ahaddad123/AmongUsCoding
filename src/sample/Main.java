/*
  @Main.java
 */

package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Child class of Application, where the program is launched and controlled
 *
 * @author Makenna Halvensleben
 * @author Andrew Haddad
 * @author Adelia Rumpel
 * @author https://gist.github.com/jewelsea/8321740
 *
 * @version 02 May 2021
 */
public class Main extends Application {

    private boolean goUp;
    private boolean goDown;
    private boolean goLeft;
    private boolean goRight;
    private GraphicsEngine graphics;
    private GameEngine game;
    private boolean runTimer;

    /**
     * Overrides the start method of Application
     * Deals with arrow key input and character location
     *
     * @param primaryStage - stage where the map is shown
     * @throws Exception - needed to call displayMap()
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Node character = new ImageView(new Image("green.png"));
        Node impostor = new ImageView(new Image("impostor.png"));
        graphics = new GraphicsEngine(character, impostor);
        game = new GameEngine(graphics);
        runTimer = true;
        Scene scene = graphics.displayMap();

        primaryStage.setTitle("Map");
        primaryStage.setScene(scene);
        graphics.displayMainMenu();

        // Found at: https://gist.github.com/jewelsea/8321740
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP -> goUp = true;
                    case DOWN -> goDown = true;
                    case LEFT -> goLeft = true;
                    case RIGHT -> goRight = true;
                }
            }
        });

        //Found at: https://gist.github.com/jewelsea/8321740
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP -> goUp = false;
                    case DOWN -> goDown = false;
                    case LEFT -> goLeft = false;
                    case RIGHT -> goRight = false;
                }
            }
        });

        //Found at: https://gist.github.com/jewelsea/8321740
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(game.levelCompleted())
                {
                    graphics.displayVictoryMessage();
                    primaryStage.close();
                    graphics.restartLevel();
                }
                else if(graphics.stageIsShowing())
                {
                    runTimer = false;
                }
                else if(game.inTaskLocation() == -1)
                {
                    runTimer = true;
                }
                else
                {
                    if(!goUp && !goDown && !goLeft && !goRight)
                    {
                        //if in the location of a task, display the task window and then check for completion
                        game.accessTask();
                        runTimer = game.getTaskCompleted();
                    }
                }

                //if in the location of an incomplete task, character cannot move
                if(runTimer) {
                    int dx = 0, dy = 0;

                    if (goUp) {
                        dy -= 5;
                    }
                    if (goDown) {
                        dy += 5;
                    }
                    if (goRight) {
                        dx += 5;
                    }
                    if (goLeft) {
                        dx -= 5;
                    }

                    graphics.getInput().moveCharacterBy(dx, dy);
                    graphics.moveImpostor();
                }

                if(graphics.collided() || graphics.getLost())
                {
                    graphics.displayLoseMessage();
                    primaryStage.close();
                    graphics.setLost(false);
                    goDown = false;
                    goUp = false;
                    goLeft = false;
                    goRight = false;
                }
            }
        };
        timer.start();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
