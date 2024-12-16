package th.hathikieungan.th_bai8_quizappgui2fullcode;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    private TextView tvQuestion, tvKQ;
    private CardView cardA, cardB, cardC, cardD;
    private TextView answerA, answerB, answerC, answerD;

    private List<Question> questionList;
    private int currentQuestionIndex = 0;
    private boolean isAnswered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        tvQuestion = findViewById(R.id.textview1);
        tvKQ = findViewById(R.id.tvKQ);

        cardA = findViewById(R.id.cardViewA);
        cardB = findViewById(R.id.cardViewB);
        cardC = findViewById(R.id.cardViewC);
        cardD = findViewById(R.id.cardViewD);

        answerA = findViewById(R.id.anwserA);
        answerB = findViewById(R.id.anwserB);
        answerC = findViewById(R.id.anwserC);
        answerD = findViewById(R.id.anwserD);

        // Tạo danh sách câu hỏi
        questionList = getQuestionList();

        // Hiển thị câu hỏi đầu tiên
        displayQuestion();

        // Xử lý khi chọn đáp án
        cardA.setOnClickListener(v -> checkAnswer(0, cardA));
        cardB.setOnClickListener(v -> checkAnswer(1, cardB));
        cardC.setOnClickListener(v -> checkAnswer(2, cardC));
        cardD.setOnClickListener(v -> checkAnswer(3, cardD));

        // Xử lý khi bấm nút Next
        findViewById(R.id.btnnext).setOnClickListener(v -> {
            if (!isAnswered) {
                // Nếu chưa trả lời, báo lỗi trong tvKQ
                tvKQ.setText("Hãy chọn câu trả lời");
                return;
            }
            if (currentQuestionIndex < questionList.size() - 1) {
                currentQuestionIndex++;
                resetState(); // Reset lại trạng thái
                displayQuestion();
            } else {
                tvKQ.setText("Đã hết câu hỏi!");
                tvKQ.setTextColor(getResources().getColor(R.color.black));
            }
        });
    }

    // Hiển thị câu hỏi
    private void displayQuestion() {
        Question question = questionList.get(currentQuestionIndex);
        tvQuestion.setText(question.getQuestionText());
        answerA.setText(question.getOptions().get(0));
        answerB.setText(question.getOptions().get(1));
        answerC.setText(question.getOptions().get(2));
        answerD.setText(question.getOptions().get(3));
    }

    // Kiểm tra đáp án
    private void checkAnswer(int selectedIndex, CardView selectedCard) {
        if (isAnswered) return; // Không cho phép chọn lại nếu đã trả lời

        isAnswered = true;
        Question currentQuestion = questionList.get(currentQuestionIndex);

        // Kiểm tra nếu đúng
        if (selectedIndex == currentQuestion.getCorrectAnswerIndex()) {
            selectedCard.setCardBackgroundColor(getResources().getColor(R.color.green));
            tvKQ.setText("Correct..");
            tvKQ.setTextColor(getResources().getColor(R.color.green));
        } else {
            selectedCard.setCardBackgroundColor(getResources().getColor(R.color.red));
            tvKQ.setText("Wrong..");
            tvKQ.setTextColor(getResources().getColor(R.color.red));
            // Hiển thị đáp án đúng với màu xanh
            highlightCorrectAnswer(currentQuestion.getCorrectAnswerIndex());
        }
    }

    private void highlightCorrectAnswer(int correctIndex) {
        switch (correctIndex) {
            case 0:
                cardA.setCardBackgroundColor(getResources().getColor(R.color.green));
                break;
            case 1:
                cardB.setCardBackgroundColor(getResources().getColor(R.color.green));
                break;
            case 2:
                cardC.setCardBackgroundColor(getResources().getColor(R.color.green));
                break;
            case 3:
                cardD.setCardBackgroundColor(getResources().getColor(R.color.green));
                break;
        }
    }

    // Reset trạng thái khi bấm Next
    private void resetState() {
        isAnswered = false;
        tvKQ.setText("");

        // Đặt lại màu nền mặc định cho các CardView
        cardA.setCardBackgroundColor(getResources().getColor(R.color.card_bg_color));
        cardB.setCardBackgroundColor(getResources().getColor(R.color.card_bg_color));
        cardC.setCardBackgroundColor(getResources().getColor(R.color.card_bg_color));
        cardD.setCardBackgroundColor(getResources().getColor(R.color.card_bg_color));
    }

    // Tạo danh sách câu hỏi mẫu
    private List<Question> getQuestionList() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Java được phát triển bởi công ty nào?",
                Arrays.asList("Google", "Sun Microsystems", "Oracle", "Microsoft"), 1));
        questions.add(new Question("Kiểu dữ liệu nào trong Java để lưu số thực?",
                Arrays.asList("int", "float", "boolean", "char"), 1));
        questions.add(new Question("Phương thức chính trong Java được định nghĩa như thế nào?",
                Arrays.asList("main()", "public static void main()", "void main()", "public void main()"), 1));
        questions.add(new Question("Lớp nào được sử dụng để xử lý chuỗi trong Java?",
                Arrays.asList("String", "int", "float", "boolean"), 0));
        questions.add(new Question("Câu lệnh nào để in ra màn hình console trong Java?",
                Arrays.asList("print()", "echo()", "System.out.println()", "cout<<"), 2));
        return questions;
    }
}