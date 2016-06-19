package scheduler.jobs;

import com.sun.istack.internal.NotNull;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Andy on 6/18/2016.
 */
public class LeagueAPIScraperJob implements Job
{
    private static Logger _log = LoggerFactory.getLogger(LeagueAPIScraperJob.class);

    private final static String SCRIPT_LANGUAGE = "python";
    private final static String SCRIPT_NAME = "script.py";

    /**
     * <p>
     * Empty constructor for job initilization
     * </p>
     * <p>
     * Quartz requires a public empty constructor so that the
     * scheduler can instantiate the class whenever it needs.
     * </p>
     */
    public LeagueAPIScraperJob()
    {

    }

    /**
     * <p>
     * Called by the <code>{@link org.quartz.Scheduler}</code> when a
     * <code>{@link org.quartz.Trigger}</code> fires that is associated with
     * the <code>Job</code>.
     * </p>
     *
     * @throws JobExecutionException
     *             if there is an exception while executing the job.
     */
    public void execute(JobExecutionContext context)
            throws JobExecutionException
    {
        scrapeLeagueAPI();
        System.out.println("test");
    }

    private void scrapeLeagueAPI()
    {
        String arguments = "";
        try {
            Process p = Runtime.getRuntime().exec(new String[]{SCRIPT_LANGUAGE, SCRIPT_NAME, arguments});
        }
        catch (Exception e)
        {

        }
    }
}
