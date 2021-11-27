/*
  @CleanO2.java
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
public class CleanO2 extends Task{

    /**
     * Initializes the mode, name, and correctAnswer of the task
     *
     * @param mode - Crewmate or Impostor setting
     */
    public CleanO2(String mode){ super("float",mode,"Clean O2"); }

    @Override
    public String displayQuestion(){
        return "To clean the O2 you need to enter a number with decimals, what variable would that be?";
    }
}
