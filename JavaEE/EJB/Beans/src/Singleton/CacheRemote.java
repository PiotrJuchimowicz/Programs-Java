package Singleton;

import javax.ejb.Remote;

@Remote
public interface CacheRemote {
    void add(String key,Object value);
    Object get(String key);
    boolean contains(String key);
    Object remove(String key);

}
