package main;

import base.DataBase;
import base.IConnection;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {
    public static void main(String[] args) {
        IConnection connection1 = DataBase.getConnectionInstance();
        IConnection connection2 = DataBase.getConnectionInstance();
        IConnection connection3 = DataBase.getConnectionInstance();
        IConnection connection4 = DataBase.getConnectionInstance();
        IConnection connection5 = DataBase.getConnectionInstance();
        IConnection connection6 = DataBase.getConnectionInstance();
        IConnection connection7 = DataBase.getConnectionInstance();
        IConnection connection8 = DataBase.getConnectionInstance();
        IConnection connection9 = DataBase.getConnectionInstance();

        List<IConnection> connectionsA = new LinkedList<>();
        connectionsA.add(connection1);
        connectionsA.add(connection4);
        connectionsA.add(connection7);

        List<IConnection> connectionsB = new LinkedList<>();
        connectionsB.add(connection2);
        connectionsB.add(connection5);
        connectionsB.add(connection8);

        List<IConnection> connectionsC = new LinkedList<>();
        connectionsC.add(connection3);
        connectionsC.add(connection6);
        connectionsC.add(connection9);

        List<DataBase> bases = new LinkedList<>();
        bases.add(connection1.getDataBase());
        bases.add(connection2.getDataBase());
        bases.add(connection3.getDataBase());
        bases.add(connection4.getDataBase());
        bases.add(connection5.getDataBase());
        bases.add(connection6.getDataBase());
        bases.add(connection7.getDataBase());
        bases.add(connection8.getDataBase());
        bases.add(connection9.getDataBase());

        boolean isAllEqualsInCollectionA = connectionsA.isEmpty() || connectionsA.stream().allMatch(connectionsA.get(0)::equals);
        boolean isAllEqualsInCollectionB = connectionsB.isEmpty() || connectionsB.stream().allMatch(connectionsB.get(0)::equals);
        boolean isAllEqualsInCollectionC = connectionsC.isEmpty() || connectionsC.stream().allMatch(connectionsC.get(0)::equals);
        boolean isAllBasesEquals = bases.isEmpty() || bases.stream().allMatch(bases.get(0)::equals);

        assertTrue(isAllBasesEquals);
        assertTrue(isAllEqualsInCollectionA);
        assertTrue(isAllEqualsInCollectionB);
        assertTrue(isAllEqualsInCollectionC);
    }
}
