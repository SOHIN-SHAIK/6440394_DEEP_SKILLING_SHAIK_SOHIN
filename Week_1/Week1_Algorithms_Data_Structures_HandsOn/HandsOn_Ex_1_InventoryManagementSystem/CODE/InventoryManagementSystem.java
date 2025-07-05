import java.util.*;

class Product {
    private final String productId;
    private final String name;
    private int quantity;
    private double price;

    public Product(String productId, String name, int quantity, double price) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public void updateQuantity(int quantity) { this.quantity = quantity; }
    public void updatePrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return productId + " | " + name + " | Qty: " + quantity + " | $" + price;
    }
}

interface InventoryOperations {
    void addProduct(Product product);
    void updateProduct(String productId, int quantity, double price);
    boolean deleteProduct(String productId);
    Product getProduct(String productId);
    List<Product> listAllProducts();
}

class InventoryRepository implements InventoryOperations {
    private final Map<String, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.putIfAbsent(product.getProductId(), product);
    }

    public void updateProduct(String productId, int quantity, double price) {
        Product p = inventory.get(productId);
        if (p != null) {
            p.updateQuantity(quantity);
            p.updatePrice(price);
        }
    }

    public boolean deleteProduct(String productId) {
        return inventory.remove(productId) != null;
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public List<Product> listAllProducts() {
        return new ArrayList<>(inventory.values());
    }
}

class InventoryService {
    InventoryOperations repository;

    public InventoryService(InventoryOperations repository) {
        this.repository = repository;
    }

    public void displayInventory() {
        for (Product p : repository.listAllProducts()) {
            System.out.println(p);
        }
    }

    public void addSampleData() {
        repository.addProduct(new Product("P101", "Wireless Mouse", 30, 20.50));
        repository.addProduct(new Product("P102", "Keyboard", 15, 45.00));
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryService service = new InventoryService(new InventoryRepository());
        service.addSampleData();
        System.out.println("Initial Inventory:");
        service.displayInventory();

        service.repository.updateProduct("P101", 50, 18.99);
        service.repository.deleteProduct("P102");

        System.out.println("\nAfter Update and Delete:");
        service.displayInventory();
    }
}
