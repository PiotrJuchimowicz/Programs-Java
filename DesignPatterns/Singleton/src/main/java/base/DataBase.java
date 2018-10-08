package base;

public final class DataBase {
    private char[] array = new char[100];
    private static DataBase dataBase;

    private DataBase(){

    }

    public static IConnection getConnectionInstance() {
        return Connection.getConnection();
    }

    public synchronized static DataBase getBaseInstance() {
        if (dataBase == null)
            dataBase = new DataBase();
        return dataBase;
    }

    public char[] getArray() {
        return array;
    }
}
