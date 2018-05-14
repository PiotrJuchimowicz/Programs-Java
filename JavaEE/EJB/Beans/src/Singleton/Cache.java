package Singleton;

import CuntedString.CountedString;
import Remote.CacheRemote;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.HashMap;
import java.util.Map;

@Singleton
@Startup
public class Cache implements CacheLocal, CacheRemote {
    private static final Map<String, Object> cache = new HashMap<>();


    public static Map<String, Object> getCache() {
        return Cache.cache;
    }


    @Override
    public void add(String key, Object value) {
        CountedString cs = (CountedString) value;
        cs.startCount();
        cache.put(key, value);

    }

    @Override
    public Object get(String key) {

        Object o = cache.get(key);
        CountedString cs = (CountedString)o;
        cs.startCount();

        return cache.get(key);
    }

    @Override
    public boolean contains(String key) {
        Object o = cache.get(key);
        if(o!=null)
        {
            CountedString cs = (CountedString)o;
            cs.startCount();
        }

        return cache.containsKey(key);

    }

    @Override
    public Object remove(String key) {
        Object object = cache.get(key);
        cache.remove(key);
        return object;
    }
}
