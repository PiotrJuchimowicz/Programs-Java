package Models;

import javax.ejb.Local;

@Local
public interface AdderLocal {
   int add(int x, int y);
}
