public class MVCPatternExample {
    static class Student { private String name; private int id; private double grade; Student(String n,int i,double g){name=n;id=i;grade=g;} public String getName(){return name;} public int getId(){return id;} public double getGrade(){return grade;} public void setGrade(double g){grade=g;} }
    static class StudentView { void displayStudentDetails(String name,int id,double grade){ System.out.println("Student: " + name + " (" + id + ") Grade: " + grade); } }
    static class StudentController { private Student model; private StudentView view; StudentController(Student m,StudentView v){model=m;view=v;} public void setStudentGrade(double g){ model.setGrade(g); } public void updateView(){ view.displayStudentDetails(model.getName(), model.getId(), model.getGrade()); } }

    public static void main(String[] args){
        Student model = new Student("Alice", 1, 85.0);
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
        controller.setStudentGrade(90.5);
        controller.updateView();
    }
}
