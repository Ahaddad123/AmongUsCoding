/*
  @FuelEngines.java
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
public class FuelEngines extends Task{

    /**
     * Initializes the mode, name, and correctAnswer of the task
     *
     * @param mode - Crewmate or Impostor setting
     */
    public FuelEngines(String mode){ super("set", mode, "Fuel Engines"); }

    @Override
    public String displayQuestion(){
        return "To fuel the engines you need a specific type of oil and the right amount for each different engine, what is best to use?";
    }
}
