package scheduler.commandObject;

/**
 * Created by Andy on 6/19/2016.
 */
public class Summoner {

    private final String summonerId;

    private Summoner(String summonerId)
    {
        this.summonerId = summonerId;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public static class SummonerBuilder
    {
        private String summonerId;

        public SummonerBuilder(final String summonerId)
        {
            this.summonerId = summonerId;
        }

        public Summoner build()
        {
            return new Summoner(summonerId);
        }
    }
}
