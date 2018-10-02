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
        assert connectionA.getBase().equals(connectionB.getBase());
        assert connectionA.getBase().equals(connectionC.getBase());
        assert connectionB.getBase().equals(connectionC.getBase());
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
