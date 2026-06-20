import java.util.Arrays;

public class LibrarySearchExample {
    static class Book { int bookId; String title; String author; Book(int id,String t,String a){bookId=id;title=t;author=a;} public String toString(){return bookId+":"+title+" by "+author;} }

    static int linearSearch(Book[] arr, String title){ for(int i=0;i<arr.length;i++) if(arr[i].title.equals(title)) return i; return -1; }

    static int binarySearch(Book[] arr, String title){ int low=0, high=arr.length-1; while(low<=high){ int mid=(low+high)/2; int cmp = arr[mid].title.compareTo(title); if(cmp==0) return mid; else if(cmp<0) low=mid+1; else high=mid-1; } return -1; }

    public static void main(String[] args){
        Book[] books = new Book[]{ new Book(1,"Algorithms","Cormen"), new Book(2,"Data Structures","Weiss"), new Book(3,"Java","Bloch") };
        System.out.println("Linear index: " + linearSearch(books, "Data Structures"));
        Arrays.sort(books, (a,b)->a.title.compareTo(b.title));
        System.out.println("Binary index: " + binarySearch(books, "Data Structures"));
        System.out.println("Linear: O(n) vs Binary: O(log n) (requires sorted data)");
    }
}
