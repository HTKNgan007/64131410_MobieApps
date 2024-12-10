package th.hathikieungan.th_bai6_quizappfullcode;

public class Question {
    private String questionText;
    private String[] options;
    private int correctAnswerIndex; //Vị trí đáp án đúng

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
