package scheduler;

import org.quartz.*;

/**
 * Created by Andy on 6/21/2016.
 */
public class TaskSchedulerListener implements SchedulerListener {

    private final Scheduler scheduler;

    public TaskSchedulerListener(Scheduler scheduler)
    {
        this.scheduler = scheduler;
    }

    @Override
    public void jobScheduled(Trigger trigger)
    {

    }

    @Override
    public void jobUnscheduled(TriggerKey triggerKey)
    {

    }

    @Override
    public void triggerFinalized(Trigger trigger)
    {

    }

    @Override
    public void triggerPaused(TriggerKey triggerKey)
    {

    }

    @Override
    public void triggersPaused(String s)
    {

    }

    @Override
    public void triggerResumed(TriggerKey triggerKey)
    {

    }

    @Override
    public void triggersResumed(String s)
    {

    }

    @Override
    public void jobAdded(JobDetail jobDetail)
    {

    }

    @Override
    public void jobDeleted(JobKey jobKey)
    {

    }

    @Override
    public void jobPaused(JobKey jobKey)
    {

    }

    @Override
    public void jobsPaused(String s)
    {

    }

    @Override
    public void jobResumed(JobKey jobKey)
    {

    }

    @Override
    public void jobsResumed(String s)
    {

    }

    @Override
    public void schedulerError(String s, SchedulerException e)
    {

    }

    @Override
    public void schedulerInStandbyMode()
    {

    }

    @Override
    public void schedulerStarted()
    {

    }

    @Override
    public void schedulerStarting()
    {

    }

    @Override
    public void schedulerShutdown()
    {

    }

    @Override
    public void schedulerShuttingdown()
    {

    }

    @Override
    public void schedulingDataCleared()
    {

    }
}
