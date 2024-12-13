package th.hathikieungan.th_bai6_quizappfullcode;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
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
    private Button nextButton;

    private boolean isAnswered = false;

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

        nextButton = findViewById(R.id.btnnext);

        // Khởi tạo danh sách câu hỏi
        initializeQuestions();

        // Hiển thị câu hỏi đầu tiên
        displayQuestion();

        // Thiết lập sự kiện click cho các CardView
        setCardClickListeners();


            // Thiết lập sự kiện click cho nút Next
            nextButton.setOnClickListener(v -> {
                if (isAnswered) {
                    if (currentQuestionIndex == questionList.size() - 1) {
                        // Nếu là câu hỏi cuối, chuyển sang ResultActivity
                        Intent intent = new Intent(ActivityC.this, ResultActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Chuyển sang câu hỏi tiếp theo
                        currentQuestionIndex++;
                        resetCardColors(); // Đặt lại màu nền CardView
                        displayQuestion();
                        isAnswered = false; // Đặt lại trạng thái câu hỏi mới chưa được trả lời
                    }
                } else {
                    Toast.makeText(this, "Please select an answer first!", Toast.LENGTH_SHORT).show();
                }
            });
    }

    private void initializeQuestions() {
        questionList = new ArrayList<>();
        questionList.add(new Question("Tên biến nào sau đây là hợp lệ trong C?", new String[]{"1bien", "_bien", "bien-1", "bien 1"}, 1));
        questionList.add(new Question("Kết quả của biểu thức `5 / 2` trong C là gì?", new String[]{"2.5", "2", "Lỗi biên dịch", "Không câu nào đúng"}, 1));
        questionList.add(new Question("Thư viện nào cần sử dụng để dùng hàm `printf` trong C?", new String[]{"<stdlib.h>", "<stdio.h>", "<math.h>", "<conio.h>"}, 1));
        questionList.add(new Question("Cách khai báo con trỏ nào sau đây là đúng trong C?", new String[]{"int *ptr;", "int ptr*;", "int* ptr;", "Cả A và C đều đúng"}, 3));
        questionList.add(new Question("Kích thước của kiểu dữ liệu `int` trong C trên hệ thống 32-bit là bao nhiêu?", new String[]{"2 byte", "4 byte", "8 byte", "Tùy thuộc vào hệ thống"}, 1));

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
            nextButton.setEnabled(false);
        }
    }

    private void setCardClickListeners() {
        cardA.setOnClickListener(view -> handleAnswerSelection(0, cardA));
        cardB.setOnClickListener(view -> handleAnswerSelection(1, cardB));
        cardC.setOnClickListener(view -> handleAnswerSelection(2, cardC));
        cardD.setOnClickListener(view -> handleAnswerSelection(3, cardD));
    }

    private void handleAnswerSelection(int selectedIndex, CardView selectedCard) {
        if (!isAnswered) { // Kiểm tra nếu chưa trả lời
            Question currentQuestion = questionList.get(currentQuestionIndex);
            if (selectedIndex == currentQuestion.getCorrectAnswerIndex()) {
                selectedCard.setCardBackgroundColor(Color.GREEN); // Đáp án đúng
            } else {

                selectedCard.setCardBackgroundColor(Color.RED); // Đáp án sai
            }
            isAnswered = true; // Đánh dấu đã trả lời
        }
    }

    private void resetCardColors() {
        cardA.setCardBackgroundColor(Color.WHITE); // Đặt lại màu nền ban đầu
        cardB.setCardBackgroundColor(Color.WHITE);
        cardC.setCardBackgroundColor(Color.WHITE);
        cardD.setCardBackgroundColor(Color.WHITE);
    }
}