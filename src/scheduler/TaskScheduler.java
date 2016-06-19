package scheduler;

import org.quartz.Scheduler;
import scheduler.jobs.LeagueAPIScraperJob;
import org.quartz.JobDetail;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by Andy on 6/18/2016.
 */
public class TaskScheduler {
    public void run() throws Exception
    {
        SchedulerFactory sf = new StdSchedulerFactory();

        Scheduler sched = sf.getScheduler();

        Date runTime = evenMinuteDate(new Date());

        JobDetail job = newJob(LeagueAPIScraperJob.class).withIdentity("job1", "group1").build();

        // Trigger the job to run on the next round minute
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);

        sched.start();
    }
}
