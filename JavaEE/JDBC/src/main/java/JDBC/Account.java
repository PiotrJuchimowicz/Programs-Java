package JDBC;

public class Account
{
    private int id;
    private String notes;
    private long balance;
    private int id_client;

    public Account()
    {

    }

    public Account(int id, String notes, long balance, int id_client) {
        this.id = id;
        this.notes = notes;
        this.balance = balance;
        this.id_client = id_client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
}
