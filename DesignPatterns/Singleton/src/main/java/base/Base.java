package base;

public final class Base {
    private char[] array= new char[100];
    private static Base base;

    public static IConnection getConnectionInstance() {
        return Connection.getConnection();
    }

    public synchronized static Base getBaseInstance(){
        if (base==null)
            base=new Base();
        return base;
    }

    public char[] getArray() {
        return array;
    }
}
