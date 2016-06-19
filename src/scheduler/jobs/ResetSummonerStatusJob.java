package scheduler.jobs;

/**
 * Created by Andy on 6/19/2016.
 */

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ResetSummonerStatusJob:
 * - reset summoner IS_UPDATED to "false"
 * - job is executed daily (every 24 hours)
 * - while this job is executed, all other jobs should be paused
 */
public class ResetSummonerStatusJob implements Job {
    private static Logger _log = LoggerFactory.getLogger(LeagueAPIScraperJob.class);

    /**
     * <p>
     * Empty constructor for job initilization
     * </p>
     * <p>
     * Quartz requires a public empty constructor so that the
     * scheduler can instantiate the class whenever it needs.
     * </p>
     */
    public ResetSummonerStatusJob()
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
        System.out.println("test");
    }

}
