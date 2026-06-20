import java.util.Arrays;

public class SearchExample {
    static class Product { int productId; String productName; String category; Product(int id,String n,String c){productId=id;productName=n;category=c;} public String toString(){return productId+":"+productName+"("+category+")";} }

    // Linear search
    static int linearSearch(Product[] arr, String name){
        for(int i=0;i<arr.length;i++) if(arr[i].productName.equals(name)) return i;
        return -1;
    }

    // Binary search on sorted array by productName
    static int binarySearch(Product[] arr, String name){
        int low=0, high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            int cmp = arr[mid].productName.compareTo(name);
            if(cmp==0) return mid;
            else if(cmp<0) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }

    public static void main(String[] args){
        Product[] products = new Product[]{ new Product(1,"Apple","Fruit"), new Product(2,"Banana","Fruit"), new Product(3,"Carrot","Veg") };
        // linear
        System.out.println("Linear search index: " + linearSearch(products, "Banana"));
        // binary requires sorted by name
        Arrays.sort(products, (a,b)->a.productName.compareTo(b.productName));
        System.out.println("Binary search index: " + binarySearch(products, "Banana"));
        System.out.println("Linear: O(n), Binary (sorted): O(log n)");
    }
}
