/*
  @FixWiring.java
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
public class FixWiring extends Task {

    /**
     * Initializes the mode, name, and correctAnswer of the task
     *
     * @param mode - Crewmate or Impostor setting
     */
    public FixWiring(String mode)
    {
        super("tuple", mode, "Fix Wiring");
    }

    @Override
    public String displayQuestion()
    {
        return "The wires are specific and have exact locations, we need a more permanent list, which would be?";
    }
}