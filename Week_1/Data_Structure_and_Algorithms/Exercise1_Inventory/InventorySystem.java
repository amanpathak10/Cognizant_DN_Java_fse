import java.util.HashMap;

public class InventorySystem {
    static class Product {
        int productId; String productName; int quantity; double price;
        Product(int id, String name, int qty, double price){ this.productId=id; this.productName=name; this.quantity=qty; this.price=price; }
        public String toString(){ return productId+":"+productName+" qty="+quantity+" price="+price; }
    }

    static class Inventory {
        private final HashMap<Integer, Product> items = new HashMap<>();
        public void addProduct(Product p){ items.put(p.productId, p); }
        public void updateProduct(Product p){ items.put(p.productId, p); }
        public void deleteProduct(int productId){ items.remove(productId); }
        public Product getProduct(int productId){ return items.get(productId); }
    }

    public static void main(String[] args){
        Inventory inv = new Inventory();
        Product p1 = new Product(1, "Widget", 10, 2.5);
        inv.addProduct(p1);
        System.out.println("Added: " + inv.getProduct(1));
        inv.updateProduct(new Product(1, "Widget", 20, 2.5));
        System.out.println("Updated: " + inv.getProduct(1));
        inv.deleteProduct(1);
        System.out.println("After delete: " + inv.getProduct(1));
        System.out.println("Operations (HashMap) average-case: add/update/delete = O(1)");
    }
}
