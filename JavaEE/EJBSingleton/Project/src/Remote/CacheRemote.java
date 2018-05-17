package Remote;

import Domain.ModifiedString;

import javax.ejb.Remote;

@Remote
public interface CacheRemote {
    boolean contains(String key);
    void add(String s1, ModifiedString ms);
    ModifiedString get(String  key);
    ModifiedString remove(String key);

}
