import base.Connection;
import base.IConnection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestClass {
    private IConnection connectionA = Connection.getConnection();
    private IConnection connectionB = Connection.getConnection();
    private IConnection connectionC = Connection.getConnection();

    @Test
    void sameBaseExistence() {
        assert connectionA.getDataBase().equals(connectionB.getDataBase());
        assert connectionA.getDataBase().equals(connectionC.getDataBase());
        assert connectionB.getDataBase().equals(connectionC.getDataBase());
    }

    @Test
    void threeConnectionsExistence(){
        IConnection connection = Connection.getConnection();
        assert connection.equals(connectionA);
    }

    @Test
    void threeDifferentConnectionsExistence() {
        IConnection connection = Connection.getConnection();
        assertNotEquals(connection,connectionB);
    }
}
