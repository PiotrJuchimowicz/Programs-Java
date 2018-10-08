package base;

public interface IConnection {
    char get(int index);

    void set(int index, char c);

    int length();

    DataBase getDataBase();
}
