package scheduler.store;

import scheduler.commandObject.Summoner;

import java.util.ArrayList;

/**
 * Created by Andy on 6/19/2016.
 */
public class SummonerStore {

    private ArrayList<Summoner> summoners;

    public SummonerStore(ArrayList<Summoner> summoners)
    {
        this.summoners = summoners;
    }

    public ArrayList<Summoner> getSummoners()
    {
        return summoners;
    }

    public void setSummoners(ArrayList<Summoner> summoners)
    {
        this.summoners = summoners;
    }

    public boolean isEmpty()
    {
        return summoners.isEmpty();
    }
}
