package Singleton;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class Cache implements  CacheLocal,CacheRemote {
     private Map<String,Object> cache;

    public Cache()
    {
        cache = new HashMap<>();
    }


    @Override
    public void add(String key, Object value) {
        cache.put(key, value);

    }

    @Override
    public Object get(String key) {

        return cache.get(key);
    }

    @Override
    public boolean contains(String key) {
        return cache.containsKey(key);
    }

    @Override
    public Object remove(String key) {
        Object object = cache.get(key);
        cache.remove(key);
        return object;
    }
}
