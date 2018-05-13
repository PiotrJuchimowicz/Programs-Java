package Models;

import javax.ejb.Stateless;

@Stateless
public class Adder implements  AdderLocal,AdderRemote {
    public int  add(int x, int y)
    {
        return x+y;
    }
}
