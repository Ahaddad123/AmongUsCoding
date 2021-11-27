/*
  @InputManager.java
 */

package sample;

import javafx.scene.Node;

/**
 * Relocates the character
 *
 * @author Makenna Halvensleben
 * @author Andrew Haddad
 * @author Adelia Rumpel
 * @author https://gist.github.com/jewelsea/8321740
 *
 * @version 02 May 2021
 */
public class InputManager {

    private Node character;

    /**
     * Initializes the Node
     *
     * @param character - node that holds the image of the character
     */
    public InputManager(Node character)
    {
        this.character = character;
    }

    public Node getCharacter() {
        return character;
    }

    public void setCharacter(Node character) {
        this.character = character;
    }

    /**
     * Method found at https://gist.github.com/jewelsea/8321740
     * Finds the location the character needs to move to
     *
     * @param dx - how much the character should move in the x direction
     * @param dy - how much the character should move in the y direction
     */
    public void moveCharacterBy(int dx, int dy) {
        if ((dx == 0) && (dy == 0)) {
            return;
        }

        final double cx = character.getBoundsInLocal().getWidth()  / 2;
        final double cy = character.getBoundsInLocal().getHeight() / 2;

        double x = cx + character.getLayoutX() + dx;
        double y = cy + character.getLayoutY() + dy;

        moveCharacterTo(x, y);
    }

    /**
     * Method found at https://gist.github.com/jewelsea/8321740
     * Moves the character to the correct location
     *
     * @param x - x-coordinate the character should be relocated to
     * @param y - y-coordinate the character should be relocated to
     */
    public void moveCharacterTo(double x, double y) {
        final double cx = character.getBoundsInLocal().getWidth()  / 2;
        final double cy = character.getBoundsInLocal().getHeight() / 2;

        if ((x - cx >= 0) &&
                (x + cx <= 450) &&
                (y - cy >= 0) &&
                (y + cy <= 450)) {
            character.relocate(x - cx, y - cy);
        }
    }

}

