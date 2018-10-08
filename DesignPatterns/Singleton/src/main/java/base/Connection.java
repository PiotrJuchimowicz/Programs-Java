package base;

import java.util.LinkedList;
import java.util.List;

public final class Connection implements IConnection {
    private DataBase dataBase = DataBase.getBaseInstance();
    private static List<Connection> connections = new LinkedList<>();
    private static Integer orderOfConnections = 0;

    private Connection(){

    }

    public synchronized static IConnection getConnection() {
        if (connections.size() < 3)
            connections.add(new Connection());
        orderOfConnections++;
        return connections.get((orderOfConnections - 1) % 3);
    }

    @Override
    public char get(int index) {
        return dataBase.getArray()[index];
    }

    @Override
    public void set(int index, char c) {
        dataBase.getArray()[index] = c;
    }

    @Override
    public int length() {
        return dataBase.getArray().length;
    }

    public DataBase getDataBase() {
        return dataBase;
    }
}
