package base;

import java.util.LinkedList;
import java.util.List;

public final class Connection implements IConnection {
    private Base base = Base.getBaseInstance();
    private static List<Connection> connections = new LinkedList<>();
    private static Integer orderOfConnections = 0;

    public synchronized static IConnection getConnection() {
        if (connections.size() < 3)
            connections.add(new Connection());
        orderOfConnections++;
        return connections.get((orderOfConnections-1)%3);
    }

    @Override
    public char get(int index) {
        return base.getArray()[index];
    }

    @Override
    public void set(int index, char c) {
        base.getArray()[index] = c;
    }

    @Override
    public int length() {
        return base.getArray().length;
    }

    public Base getBase() {
        return base;
    }
}
