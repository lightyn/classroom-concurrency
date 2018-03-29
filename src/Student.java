import org.omg.PortableInterceptor.INACTIVE;

public class Student implements Runnable, Comparable{
    private String name;
    private Test test;
    private Integer intelligence;
    private long answer;
    private Teacher teacher;

    public Student(String name, Integer intelligence, Teacher teacher){
        this.name = name;
        this.intelligence = intelligence;
        this.teacher = teacher;
    }

    private void answerQuestions() throws InterruptedException {
        for (Question question : test.getQuestions()) {
            Thread.sleep(10000/intelligence);
            if (question.getQuestionType() == QuestionType.ADD) {
                answer = question.getFirstNumber() + question.getSecondNumber();
            } else if (question.getQuestionType() == QuestionType.SUBTRACT) {
                answer = question.getFirstNumber() - question.getSecondNumber();
            } else if (question.getQuestionType() == QuestionType.MULTIPLY) {
                answer = question.getFirstNumber() * question.getSecondNumber();
            } else if (question.getQuestionType() == QuestionType.DIVIDE) {
                answer = question.getFirstNumber() / question.getSecondNumber();
            }
            String response = "I, " + name + ", found the answer to question " +
                    Integer.toString(test.getQuestions().indexOf(question)+1) + " to be " +
                    Long.toString(answer) + "!";
            System.out.println(response);
        }
    }

    public void shoutName() {
        System.out.println(name + " is here!");
    }

    public void receiveTest(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        try {
            while (!teacher.getStartTest()) {
                System.out.println(name + " is waiting for test to start.");
                Thread.sleep(10);
            }
            answerQuestions();
            System.out.println("I, " + name + ", am done with the test!");
        } catch (InterruptedException e) {
            System.out.println(name + " wasn't finished yet!");
        }
    }

    @Override
    public int compareTo(Object o) {
        return (this.name.compareTo(((Student) o).name));
    }
}
