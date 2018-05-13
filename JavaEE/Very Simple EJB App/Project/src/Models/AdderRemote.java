package Models;

import javax.ejb.Remote;

@Remote
public interface AdderRemote {
    int  add(int x,int y);
}
