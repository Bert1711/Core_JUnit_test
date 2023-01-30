public class Product {

    private String name;
    private int price;
    private Integer amount;
    private int cost;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        this.amount = 0;
        this.cost = 0;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        this.cost = this.amount * this.price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getCost() {
        return this.cost;
    }
}
