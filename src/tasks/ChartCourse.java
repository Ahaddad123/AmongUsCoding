/*
  @ChartCourse.java
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
public class ChartCourse extends Task{

    /**
     * Initializes the mode, name, and correctAnswer of the task
     *
     * @param mode - Crewmate or Impostor setting
     */
    public ChartCourse(String mode){ super("string", mode, "Chart Course"); }

    @Override
    public String displayQuestion() {
        return "To chart the course you must use a location, what variable would you use to define a city?";
    }
}
