import java.util.ArrayList;
import java.util.TreeSet;

public class Teacher {
    private volatile Boolean startTest;
    private String name;
    private TreeSet<Student> students;
    private Test masterTest;
    private ArrayList<Thread> testTakers;

    public Teacher(String name){
        this.name = name;
        students = new TreeSet<Student>();
        startTest = false;
        makeTest();
        testTakers = new ArrayList<Thread>();
    }

    public String getName(){
        return name;
    }

    private void makeTest(){
        masterTest = new Test();
        masterTest.addQuestion(new Question(QuestionType.ADD, 1,1));
        masterTest.addQuestion(new Question(QuestionType.SUBTRACT, 2000, 1000));
        masterTest.addQuestion(new Question(QuestionType.MULTIPLY, 15,15));
        masterTest.addQuestion(new Question(QuestionType.DIVIDE, 400, 3));
    }

    public void rollCall(TreeSet<Student> students) {
        System.out.println("Roll call!");
        this.students = students;
        for (Student student : students) {
            student.shoutName();
        }
    }

    public void handOutTestCopies() {
        for (Student student : students) {
            student.receiveTest(new Test(masterTest));
            Thread s = new Thread(student);
            s.start();
            testTakers.add(s);
        }
    }

    public Boolean getStartTest() {
        return startTest;
    }

    public void startTest(int timeToFinish) {
        startTest = true;
        System.out.println("You may now start!");
        long startTime = System.currentTimeMillis();

        while (!testTakers.isEmpty()) {
            if(timeToFinish<(System.currentTimeMillis() - startTime)) {
                for (Thread thread : testTakers) {
                    thread.interrupt();
                }
                break;
            }
            testTakers.removeIf(thread -> !thread.isAlive());
        }
        System.out.println("Time's up!");
    }
}
