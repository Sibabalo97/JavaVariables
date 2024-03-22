public class Product {
    private String name;
    private int initialStock;
    private int currentStock;
    private int threshold;

    public Product(String name, int initialStock, int threshold) {
        this.name = name;
        this.initialStock = initialStock;
        this.currentStock = initialStock;
        this.threshold = threshold;
    }

    public String getName() {
        return name;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void sell(int quantity) {
        if (quantity <= currentStock) {
            currentStock -= quantity;
        } else {
            System.out.println("Error: Not enough stock of " + name + " to sell.");
        }
    }

    public boolean needsRestocking() {
        return currentStock < threshold;
    }

    public void restock(int quantity) {
        currentStock += quantity;
        System.out.println("Restocked " + quantity + " items of " + name + ".");
    }
}
