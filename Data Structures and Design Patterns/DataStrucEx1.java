import java.util.*;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int id, String name, int qty, double price) {
        this.productId = id;
        this.productName = name;
        this.quantity = qty;
        this.price = price;
    }
}

public class DataStrucEx1 {
    static Map<Integer, Product> inventory = new HashMap<>();

    public static void addProduct(Product p) {
        inventory.put(p.productId, p);
    }

    public static void updateProduct(int id, int qty, double price) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = qty;
            p.price = price;
        }
    }

    public static void deleteProduct(int id) {
        inventory.remove(id);
    }

    public static void main(String[] args) {
        addProduct(new Product(101, "Pen", 100, 5.0));
        updateProduct(101, 150, 5.5);
        deleteProduct(101);
    }
}
