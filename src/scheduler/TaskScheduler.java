package scheduler;

import org.quartz.Scheduler;
import scheduler.jobs.LeagueAPIScraperJob;
import org.quartz.JobDetail;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import scheduler.jobs.ResetSummonerStatusJob;
import scheduler.jobs.RetrieveOutdatedSummonerListJob;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.*;
/**
 * Created by Andy on 6/18/2016.
 */
public class TaskScheduler {
    public void run() throws Exception
    {
        SchedulerFactory sf = new StdSchedulerFactory();

        Scheduler sched = sf.getScheduler();

        JobDetail leagueAPIScraperJob = newJob(LeagueAPIScraperJob.class).withIdentity("job1", "group1").build();
        Trigger leagueAPIScraperJobTrigger = newTrigger().withIdentity("trigger1", "group1").build();

        JobDetail resetSummonerStatusJob = newJob(ResetSummonerStatusJob.class).withIdentity("job2", "group2").build();
        Trigger resetSummonerStatusJobTrigger = newTrigger()
                .withIdentity("trigger2", "group2")
                .withSchedule(simpleSchedule()
                        .withIntervalInHours(24)
                        .repeatForever())
                .build();

        JobDetail retrieveOutdatedSummonerListJob = newJob(RetrieveOutdatedSummonerListJob.class).withIdentity("job3", "group1").build();
        Trigger retrieveOutdatedSummonerListJobTrigger = newTrigger()
                .withIdentity("trigger3", "group1")
                .withSchedule(simpleSchedule()
                        .withIntervalInMinutes(10)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(leagueAPIScraperJob, leagueAPIScraperJobTrigger);
        sched.scheduleJob(resetSummonerStatusJob, resetSummonerStatusJobTrigger);
        sched.scheduleJob(retrieveOutdatedSummonerListJob, retrieveOutdatedSummonerListJobTrigger);

        sched.start();
    }
}
