public class EmployeeArrayExample {
    static class Employee { int employeeId; String name; String position; double salary; Employee(int id,String n,String p,double s){employeeId=id;name=n;position=p;salary=s;} public String toString(){return employeeId+":"+name+"("+position+") $"+salary;} }

    static class EmployeeArray {
        private Employee[] arr; private int size=0;
        EmployeeArray(int capacity){ arr = new Employee[capacity]; }
        public boolean add(Employee e){ if(size>=arr.length) return false; arr[size++]=e; return true; }
        public Employee search(int id){ for(int i=0;i<size;i++) if(arr[i].employeeId==id) return arr[i]; return null; }
        public void traverse(){ for(int i=0;i<size;i++) System.out.println(arr[i]); }
        public boolean delete(int id){ for(int i=0;i<size;i++) if(arr[i].employeeId==id){ for(int j=i;j<size-1;j++) arr[j]=arr[j+1]; arr[--size]=null; return true; } return false; }
    }

    public static void main(String[] args){
        EmployeeArray ea = new EmployeeArray(5);
        ea.add(new Employee(1,"Alice","Dev",70000)); ea.add(new Employee(2,"Bob","QA",60000));
        System.out.println("Traverse:"); ea.traverse();
        System.out.println("Search id=2: " + ea.search(2));
        ea.delete(1); System.out.println("After delete:"); ea.traverse();
        System.out.println("Operations: add O(1), search O(n), traverse O(n), delete O(n)");
    }
}
