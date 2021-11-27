/*
  @UploadData.java
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
public class UploadData extends Task{

    /**
     * Initializes the mode, name, and correctAnswer of the task
     *
     * @param mode - Crewmate or Impostor setting
     */
    public UploadData(String mode){ super("list", mode, "Upload Data"); }

    @Override
    public String displayQuestion(){
        return "In order to upload the data, you need to put it all together on something, what would that be?";
    }
}
