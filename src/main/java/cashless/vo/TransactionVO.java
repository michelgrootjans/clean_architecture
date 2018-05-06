package cashless.vo;

public class TransactionVO {
    private int productId;
    private int credits;
    private String description;

    @Override
    public String toString() {
        return "" + credits + " credits: " + description;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
