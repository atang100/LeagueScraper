package scheduler.store;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Andy on 6/19/2016.
 */
public class Store {

    private static SynchronousQueue<SummonerStore> summonerStoreList = new SynchronousQueue<SummonerStore>();

    private Store()
    {

    }

    /**
     * Empty summoner store.  This should be called everytime {@link scheduler.jobs.ResetSummonerStatusJob}
     *
     */
    public static void emptySummonerStore()
    {
        summonerStoreList.clear();
    }

    public static void addSummonerStore(SummonerStore summonerStore)
    {
        summonerStoreList.add(summonerStore);
    }

    @Nullable
    public static SummonerStore dequeueSummonerStore()
    {
        if (!summonerStoreList.isEmpty()) {
            return summonerStoreList.remove();
        }
        else
        {
            return null;
        }
    }

    public static boolean isSummonerStoreEmpty()
    {
        return summonerStoreList.isEmpty();
    }

    public static SummonerStore getSummonerStore()
    {
        if (!summonerStoreList.isEmpty()) {
            return summonerStoreList.peek();
        }
        else
        {
            return null;
        }
    }
}
