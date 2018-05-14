package Singleton;

import javax.ejb.Local;

@Local
public interface CacheLocal {
    void add(String key, Object value);
    Object get(String key);
    boolean contains(String key);
    Object remove(String key);

}
