package company.com.shopapplication.model;

public class IdGenerator {
    private static Long position=0L;

    public  static Long generate(){
        return  position++;
    }
}
