import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Phone", "Electronics"),
            new Product(101, "Shoes", "Footwear"),
            new Product(103, "Laptop", "Electronics"),
            new Product(102, "Watch", "Accessories")
        };

        Product result1 = SearchUtility.linearSearch(products, 103);
        System.out.println("Linear Search Result: " + result1);

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        Product result2 = SearchUtility.binarySearch(products, 103);
        System.out.println("Binary Search Result: " + result2);
    }
}
