package main;

import base.Base;
import base.IConnection;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IConnection connection1 = Base.getConnectionInstance();
        IConnection connection2 = Base.getConnectionInstance();
        IConnection connection3 = Base.getConnectionInstance();
        IConnection connection4 = Base.getConnectionInstance();
        IConnection connection5 = Base.getConnectionInstance();
        IConnection connection6 = Base.getConnectionInstance();
        IConnection connection7 = Base.getConnectionInstance();
        IConnection connection8 = Base.getConnectionInstance();
        IConnection connection9 = Base.getConnectionInstance();

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

        List<Base> bases = new LinkedList<>();
        bases.add(connection1.getBase());
        bases.add(connection2.getBase());
        bases.add(connection3.getBase());
        bases.add(connection4.getBase());
        bases.add(connection5.getBase());
        bases.add(connection6.getBase());
        bases.add(connection7.getBase());
        bases.add(connection8.getBase());
        bases.add(connection9.getBase());

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
