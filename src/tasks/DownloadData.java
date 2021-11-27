/*
  @DownloadData.java
 */

package Tasks;

/**
 * Child of Task Class
 *
 * @author Makenna Halvensleben
 * @author Andrew Haddad
 * @author Adelia Rumpel
 *
 * @version 02 May 2021
 */
public class DownloadData extends Task{

    /**
     * Initializes the mode, name, and correctAnswer of the task
     *
     * @param mode - Crewmate or Impostor setting
     */
    public DownloadData(String mode)
    {
        super("list", mode, "Download Data");
    }

    @Override
    public String displayQuestion() {
        return "You need to download the data in something that can hold lots of numbers that can be changed, what would that be?";
    }
}
