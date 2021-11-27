/*
  @StartReactor.java
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
public class StartReactor extends Task{

    /**
     * Initializes the mode, name, and correctAnswer of the task
     *
     * @param mode - Crewmate or Impostor setting
     */
    public StartReactor(String mode){ super("boolean", mode, "Start Reactor"); }

    @Override
    public String displayQuestion() {
        return "To start the reactor you need to set it true or false, what variable is this?";
    }
}
