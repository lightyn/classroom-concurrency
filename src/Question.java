public class Question {
    private QuestionType questionType;
    private long firstNumber;
    private long secondNumber;

    public Question(QuestionType questionType, long firstNumber, long secondNumber) {
        this.questionType = questionType;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public QuestionType getQuestionType(){
        return questionType;
    }

    public long getFirstNumber() {
        return firstNumber;
    }

    public long getSecondNumber(){
        return secondNumber;
    }
}
