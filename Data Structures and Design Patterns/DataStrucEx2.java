import java.util.Arrays;
import java.util.Comparator;

class ProductSearch {
    int productId;
    String productName;
    String category;

    ProductSearch(int id, String name, String cat) {
        this.productId = id;
        this.productName = name;
        this.category = cat;
    }
}

class DataStrucEx2 {
    static ProductSearch[] products = {
        new ProductSearch(1, "Phone", "Electronics"),
        new ProductSearch(2, "Shoes", "Fashion"),
        new ProductSearch(3, "Laptop", "Electronics")
    };

    public static ProductSearch linearSearch(String name) {
        for (ProductSearch p : products) {
            if (p.productName.equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    public static ProductSearch binarySearch(String name, ProductSearch[] sorted) {
        int l = 0, r = sorted.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int cmp = sorted[m].productName.compareToIgnoreCase(name);
            if (cmp == 0) return sorted[m];
            if (cmp < 0) l = m + 1; else r = m - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName));
        System.out.println(linearSearch("Laptop").category);
        System.out.println(binarySearch("Laptop", products).category);
    }
}
