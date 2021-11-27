/*
  @AlignEngines.java
 */

package Tasks;

/**
 * Child of Task class
 *
 * @author Makenna Halvensleben
 * @author Andrew Haddad
 * @author Adelia Rumpel
 *
 * @version 02 May 2021
 */
public class AlignEngines extends Task{

    /**
     * Initializes the mode, name, and correctAnswer of the task
     *
     * @param mode - Crewmate or Impostor setting
     */
    public AlignEngines(String mode) { super("int", mode, "Align Engines"); }

    @Override
    public String displayQuestion() {
        return "To align the engines with a positive whole number, what variable is a number?";
    }
}
