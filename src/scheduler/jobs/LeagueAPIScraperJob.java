package scheduler.jobs;

import com.sun.istack.internal.NotNull;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scheduler.commandObject.Summoner;
import scheduler.store.Store;
import scheduler.store.SummonerStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    }

    private void scrapeLeagueAPI()
    {
        List<Summoner> summonerList = getSummonerList();

        for (Summoner summoner : summonerList)
        {
            String arguments = summoner.getSummonerId();
            try {
                Process p = Runtime.getRuntime().exec(new String[]{SCRIPT_LANGUAGE, SCRIPT_NAME, arguments});
                //TODO: Create mechanism to handle determine if scritps executed successfully.
            } catch (Exception e) {

            }
        }
    }

    private List<Summoner> getSummonerList()
    {
        if (Store.isSummonerStoreEmpty())
        {
            return Collections.emptyList();
        }

        SummonerStore summonerStore = Store.dequeueSummonerStore();
        return summonerStore.getSummoners();
    }
}
