package Singleton;

import Domain.ModifiedString;
import Remote.CacheRemote;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class Cache implements CacheRemote {
    private static final Map<String, ModifiedString> cache = new HashMap<>();

    @Override
    public boolean contains(String key) {
        if (cache.containsKey(key)) {
            cache.get(key).startCount();
            return true;
        } else
            return false;

    }

    @Override
    public void add(String key, ModifiedString ms) {
        //this cache dont replace keys new values
        if (contains(key))
            return;
        //start time count
        ms.startCount();
        cache.put(key, ms);

    }

    @Override
    public ModifiedString get(String key) {

        //may return null if cache dont contain key
        ModifiedString ms = cache.get(key);
        if (ms != null) {
            ms.startCount();
            return ms;
        } else
            return ms;

    }

    @Override
    public ModifiedString remove(String key) {
        //returns value associated with key or null if map dont contain this key
        return cache.remove(key);
    }

    //Timer  checks  the time every  2 minutes
    @Schedule(second = "0/20")
    void work() {



        for (String key : cache.keySet()) {
            ModifiedString cs = cache.get(key);


            if (((System.nanoTime() / 1000000000) - cs.getStartTime()) > 120) {

                remove(key);
            }
        }
    }
}
