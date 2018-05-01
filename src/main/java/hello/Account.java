package hello;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private String owner;
    private List<Transaction> transactions = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getCredits() {
        return transactions.stream()
                .map(t -> t.getCredits())
                .reduce(0, (a,b) -> a+b);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
