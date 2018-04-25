package hello;

public class Account {
    private final int id;
    private final String owner;

    public Account(int id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }
}
