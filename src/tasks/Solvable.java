/*
  @Solvable.java
 */

package Tasks;

/**
 * Interface the contains the methods necessary to solve tasks
 *
 * @author Makenna Halvensleben
 * @author Andrew Haddad
 * @author Adelia Rumpel
 *
 * @version 02 May 2021
 */
public interface Solvable {
    /**
     * Holds the question to be answered
     *
     * @return the question for the task
     */
    String displayQuestion();

    /**
     * Gets the correct answer to the task's question
     *
     * @return the correct answer
     */
    String getCorrectAnswer();

    /**
     * Gets the name of the task (such as AlignEngines, ChartCourse, etc.)
     * Used in the task list and when displaying the task
     *
     * @return the name of the task
     */
    String getName();

    /**
     * Gets if the task has been answered correctly
     *
     * @return if the task is completed
     */
    boolean getCompleted();

    /**
     * Sets the task as complete or incomplete
     *
     * @param value - if the task is completed
     */
    void setCompleted(boolean value);

    /**
     * Gets if the task has been displayed already
     *
     * @return if the task has been accessed
     */
    boolean getAccessed();

    /**
     * Sets if the task has been displayed
     *
     * @param value - if the task has been accessed
     */
    void setAccessed(boolean value);
}
