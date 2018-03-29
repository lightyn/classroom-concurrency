import java.util.ArrayList;

public class Test {
    private ArrayList<Question> questions;

    public Test() {
        questions = new ArrayList<>();
    }

    public Test(Test test) {
        this.questions = test.questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getQuestionNumber(int number) {
        return questions.get(number);
    }

    public ArrayList<Question> getQuestions(){
        return questions;
    }
}
