package cashless.vo;

import java.util.ArrayList;
import java.util.List;

public class AccountVO {
    private int id;
    private String owner;
    private int credits;
    private List<TransactionVO> transactions = new ArrayList<>();
    private List<TransactionVO> orders = new ArrayList<>();

    @Override
    public String toString() {
        return owner + ": " + credits + " credits";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public List<TransactionVO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionVO> transactions) {
        this.transactions = transactions;
    }

    public List<TransactionVO> getOrders() {
        return orders;
    }

    public void setOrders(List<TransactionVO> orders) {
        this.orders = orders;
    }
}
