package TImer;

import CountedString.CountedString;
import Singleton.Cache;

import javax.ejb.Schedule;
import java.util.Map;

public class Timer {


    //Timer  checks  the time every minute
    @Schedule(minute = "0/2",persistent = false)
    void check()
    {
        Map<String,Object> map = Cache.getCache();



        for (String key : map.keySet())
        {
             Object value = map.get(key);

             CountedString cs = (CountedString) value;
            if(((System.nanoTime()/1000000000) - cs.getStart())>120)
            {
                map.remove(key);
            }
        }
    }


}
