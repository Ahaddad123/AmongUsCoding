/*
  @Level.java
 */

package sample;

import Tasks.*;

/**
 * Maintains an array of Solvable objects
 *
 * @author Makenna Halvensleben
 * @author Andrew Haddad
 * @author Adelia Rumpel
 *
 * @version 02 May 2021
 */
public class Level {

    private Solvable[] tasks;

    /**
     * Initializes the tasks in the Solvable array
     */
    public Level()
    {
        tasks = new Solvable[8];

        tasks[0] = new AlignEngines("Crewmate");
        tasks[1] = new ChartCourse("Crewmate");
        tasks[2] = new CleanO2("Crewmate");
        tasks[3] = new DownloadData("Crewmate");
        tasks[4]  = new FixWiring("Crewmate");
        tasks[5] = new FuelEngines("Crewmate");
        tasks[6] = new StartReactor("Crewmate");
        tasks[7] = new UploadData("Crewmate");
    }

    public Solvable[] getTasks() {
        return tasks;
    }

    public void setTasks(Solvable[] tasks) {
        this.tasks = tasks;
    }

    //methods to be completed

    public void getTopic(){}

    public void getTaskList(){}

    public void fillProgressBar(){}


}
