package th.hathikieungan.th_bai6_quizappfullcode;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ActivityC extends AppCompatActivity {
    private List<Question> questionList;
    private int currentQuestionIndex = 0;

    private TextView questionTextView;
    private TextView optionATextView, optionBTextView, optionCTextView, optionDTextView;
    private CardView cardA, cardB, cardC, cardD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        // Gán view
        questionTextView = findViewById(R.id.textview1); // TextView hiển thị câu hỏi
        optionATextView = findViewById(R.id.anwserA); // Câu trả lời A
        optionBTextView = findViewById(R.id.anwserB); // Câu trả lời B
        optionCTextView = findViewById(R.id.anwserC); // Câu trả lời C
        optionDTextView = findViewById(R.id.anwserD); // Câu trả lời D

        cardA = findViewById(R.id.cardViewA); // CardView chứa đáp án A
        cardB = findViewById(R.id.cardViewB); // CardView chứa đáp án B
        cardC = findViewById(R.id.cardViewC); // CardView chứa đáp án C
        cardD = findViewById(R.id.cardViewD); // CardView chứa đáp án D

        // Khởi tạo danh sách câu hỏi
        initializeQuestions();

        // Hiển thị câu hỏi đầu tiên
        displayQuestion();

        // Thiết lập sự kiện click
        setCardClickListeners();
    }

    private void initializeQuestions() {
        questionList = new ArrayList<>();
        questionList.add(new Question("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Madrid"}, 0));
        questionList.add(new Question("What is 5 + 3?", new String[]{"5", "8", "10", "12"}, 1));
        questionList.add(new Question("Who wrote '1984'?", new String[]{"George Orwell", "J.K. Rowling", "Ernest Hemingway", "Mark Twain"}, 0));
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questionList.size()) {
            Question currentQuestion = questionList.get(currentQuestionIndex);
            questionTextView.setText(currentQuestion.getQuestionText());
            optionATextView.setText(currentQuestion.getOptions()[0]);
            optionBTextView.setText(currentQuestion.getOptions()[1]);
            optionCTextView.setText(currentQuestion.getOptions()[2]);
            optionDTextView.setText(currentQuestion.getOptions()[3]);
        } else {
            Toast.makeText(this, "No more questions!", Toast.LENGTH_SHORT).show();
        }
    }

    private void setCardClickListeners() {
        cardA.setOnClickListener(view -> checkAnswer(0));
        cardB.setOnClickListener(view -> checkAnswer(1));
        cardC.setOnClickListener(view -> checkAnswer(2));
        cardD.setOnClickListener(view -> checkAnswer(3));
    }

    private void checkAnswer(int selectedIndex) {
        Question currentQuestion = questionList.get(currentQuestionIndex);

        if (selectedIndex == currentQuestion.getCorrectAnswerIndex()) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
        }

        // Chuyển sang câu hỏi tiếp theo
        currentQuestionIndex++;
        displayQuestion();
    }
}