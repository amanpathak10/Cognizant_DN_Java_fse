public class TaskLinkedListExample {
    static class Task { int taskId; String taskName; String status; Task next; Task(int id,String name,String status){this.taskId=id;this.taskName=name;this.status=status;} public String toString(){return taskId+":"+taskName+"("+status+")";} }

    static class TaskList {
        private Task head;
        public void add(int id,String name,String status){ Task n=new Task(id,name,status); n.next=head; head=n; }
        public Task search(int id){ Task cur=head; while(cur!=null){ if(cur.taskId==id) return cur; cur=cur.next; } return null; }
        public void traverse(){ Task cur=head; while(cur!=null){ System.out.println(cur); cur=cur.next; } }
        public boolean delete(int id){ Task cur=head, prev=null; while(cur!=null){ if(cur.taskId==id){ if(prev==null) head=cur.next; else prev.next=cur.next; return true; } prev=cur; cur=cur.next; } return false; }
    }

    public static void main(String[] args){
        TaskList tl = new TaskList();
        tl.add(1,"Setup","open"); tl.add(2,"Implement","in-progress"); tl.add(3,"Test","open");
        System.out.println("Traverse:"); tl.traverse();
        System.out.println("Search id=2: " + tl.search(2));
        tl.delete(2); System.out.println("After delete:"); tl.traverse();
        System.out.println("Linked list ops: add O(1), search O(n), delete O(n)");
    }
}
