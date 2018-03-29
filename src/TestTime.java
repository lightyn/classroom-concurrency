import java.util.TreeSet;

public class TestTime {

    public static void main(String args[]) throws InterruptedException {
        Teacher teacher = new Teacher("Ms. Frizzle");
        TreeSet<Student> students = new TreeSet<Student>();
        students.add(new Student("Arnold", 1, teacher));
        students.add(new Student("Wanda", 2, teacher));
        students.add(new Student("Carlos", 2, teacher));
        students.add(new Student("Dorothy Ann", 3, teacher));
        teacher.rollCall(students);
        teacher.handOutTestCopies();
        teacher.startTest(30000);
    }
}
