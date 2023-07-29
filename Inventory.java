import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static class Product {
        private String productId;
        private String productName;
        private double price;
        private int stock;

        public Product(String productId, String productName, double price, int stock) {
            this.productId = productId;
            this.productName = productName;
            this.price = price;
            this.stock = stock;
        }

        public String getProductId() {
            return productId;
        }

        @Override
        public String toString() {
            return "Product [ID: " + productId + ", Name: " + productName + ", Price: Rp " + price + ", Stock: " + stock + "]";
        }
    }

    public static class ProductManager {
        private List<Product> products;

        public ProductManager() {
            products = new ArrayList<>();
        }

        public void addProduct(Product product) {
            products.add(product);
        }

        public void removeProduct(String productId) {
            Product productToRemove = null;
            for (Product product : products) {
                if (product.getProductId().equals(productId)) {
                    productToRemove = product;
                    System.out.println("Successfully Remove Product\n");
                    break;
                }
            }

            if (productToRemove != null) {
                products.remove(productToRemove);
            } else {
                System.out.println("Product with ID " + productId + " not found.\n");
            }
        }

        public void displayProducts() {
            System.out.println("List of Products:");
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();

        while (true) {
            System.out.println("=== Online Store ===");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Display Products");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Product Stock: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();
                    Product newProduct = new Product(productId, productName, price, stock);
                    productManager.addProduct(newProduct);
                    System.out.println("Successfully Added New Product\n");
                    break;
                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    String idToRemove = scanner.nextLine();
                    productManager.removeProduct(idToRemove);
                    break;
                case 3:
                    productManager.displayProducts();
                    break;
                case 0:
                    System.out.println("Thank you for using the Online Store App!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}