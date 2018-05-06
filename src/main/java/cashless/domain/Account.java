package cashless.domain;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private String owner;
    private List<Transaction> transactions = new ArrayList<>();
    private List<Transaction> orders = new ArrayList<>();

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
        return sum(transactions) + sum(orders);
    }

    private Integer sum(List<Transaction> transactions) {
        return transactions.stream()
                .map(t -> t.getCredits())
                .reduce(0, (a,b) -> a+b);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transaction> value) {
        transactions = value;
    }

    public List<Transaction> getOrders() {
        return orders;
    }

    public void setOrders(List<Transaction> orders) {
        this.orders = orders;
    }
}
