package JDBC;

public class DataAccessException extends RuntimeException
{
    public DataAccessException() {
    }

    public DataAccessException(Throwable cause) {
        super (cause);
    }
}
