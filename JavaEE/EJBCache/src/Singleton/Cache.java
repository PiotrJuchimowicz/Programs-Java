package Singleton;

import CountedString.CountedString;
import Remote.CacheRemote;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import java.util.HashMap;
import java.util.Map;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class Cache implements CacheLocal, CacheRemote {
    private Map<String, Object> cache = null;

    @PostConstruct
    public void initialize() {
        cache = new HashMap<>();
    }


    public Map<String, Object> getCache() {
        return cache;
    }


    @Lock(LockType.WRITE)
    @Override
    public void add(String key, Object value) {
        System.out.println("adding");
        if (cache.containsKey(key))
            return;

        CountedString cs = (CountedString) value;
        cs.startCount();
        cache.put(key, value);

    }

    @Lock(LockType.READ)
    @Override
    public Object get(String key) {

        if (!cache.containsKey(key))
            return null;

        Object o = cache.get(key);
        CountedString cs = (CountedString) o;
        cs.startCount();

        return cache.get(key);
    }

    @Lock(LockType.READ)
    @Override
    public boolean contains(String key) {
        Object o = cache.get(key);
        if (o != null) {
            CountedString cs = (CountedString) o;
            cs.startCount();
        }

        return cache.containsKey(key);

    }

    @Lock(LockType.WRITE)
    @Override
    public Object remove(String key) {
        if (!cache.containsKey(key))
            return null;

        Object object = cache.get(key);
        cache.remove(key);
        return object;
    }

    @Schedule(minute = "1/2", persistent = false)
    public void timer()
    {
        Map<String, Object> map = getCache();


        for (String key : map.keySet()) {
            Object value = map.get(key);

            CountedString cs = (CountedString) value;
            if (((System.nanoTime() / 1000000000) - cs.getStart()) > 120) {
                map.remove(key);
            }
        }
    }


}
