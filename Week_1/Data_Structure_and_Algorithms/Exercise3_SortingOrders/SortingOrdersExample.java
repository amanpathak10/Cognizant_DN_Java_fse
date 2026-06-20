import java.util.Random;

public class SortingOrdersExample {
    static class Order { int orderId; String customerName; double totalPrice; Order(int id,String c,double p){orderId=id;customerName=c;totalPrice=p;} public String toString(){return orderId+":"+customerName+" $"+totalPrice;} }

    // Bubble sort by totalPrice
    static void bubbleSort(Order[] arr){
        int n=arr.length; boolean swapped;
        for(int i=0;i<n-1;i++){
            swapped=false;
            for(int j=0;j<n-1-i;j++){
                if(arr[j].totalPrice > arr[j+1].totalPrice){ Order t=arr[j]; arr[j]=arr[j+1]; arr[j+1]=t; swapped=true; }
            }
            if(!swapped) break;
        }
    }

    static void quickSort(Order[] arr,int low,int high){
        if(low<high){ int p = partition(arr, low, high); quickSort(arr, low, p-1); quickSort(arr, p+1, high); }
    }
    static int partition(Order[] arr,int low,int high){ double pivot = arr[high].totalPrice; int i=low-1; for(int j=low;j<high;j++){ if(arr[j].totalPrice<=pivot){ i++; Order t=arr[i]; arr[i]=arr[j]; arr[j]=t; } } Order t=arr[i+1]; arr[i+1]=arr[high]; arr[high]=t; return i+1; }

    public static void main(String[] args){
        Order[] orders = new Order[6]; Random r=new Random(1);
        for(int i=0;i<orders.length;i++) orders[i]=new Order(i+1,"C"+(i+1), r.nextDouble()*1000);
        System.out.println("Before:"); for(Order o:orders) System.out.println(o);
        Order[] copy = orders.clone(); bubbleSort(copy); System.out.println("After Bubble:"); for(Order o:copy) System.out.println(o);
        copy = orders.clone(); quickSort(copy,0,copy.length-1); System.out.println("After Quick:"); for(Order o:copy) System.out.println(o);
        System.out.println("Bubble: O(n^2), Quick: average O(n log n)");
    }
}
