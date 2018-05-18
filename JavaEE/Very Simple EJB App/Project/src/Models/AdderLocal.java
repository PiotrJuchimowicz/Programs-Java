package Models;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AdderLocal {
   int add(int x, int y);

    int getElement(int i);
}
