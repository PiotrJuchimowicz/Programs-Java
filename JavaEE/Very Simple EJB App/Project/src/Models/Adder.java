package Models;

import java.util.*;
import javax.ejb.*;
import javax.annotation.PostConstruct;



@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Singleton
public class Adder implements  AdderLocal,AdderRemote {

    private List<Integer> list = null;



    @PostConstruct
    public void initialize()
    {
       list = new ArrayList<>();
    }

    @Lock(LockType.WRITE)
    public int  add(int x, int y)
    {
        list.add(x+y);
        return x+y;
    }

    @Lock(LockType.READ)
    public int getElement(int i)
    {
       return list.get(i);
    }

    public int  example()
    {
        return 1;
    }
}
