package ketaki.mycompany.quizbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity2 extends AppCompatActivity {
    private Button nextButton;
    private TextView Question,noIndicator,ans,timer;
    private RadioGroup radiogroup;
    private RadioButton rb1,rb2,rb3,rb4,rb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        nextButton = findViewById(R.id.nextButton);
        Question = findViewById(R.id.textView2);
        noIndicator = findViewById(R.id.textView1);
        radiogroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        ans = findViewById(R.id.textViewAns);
        timer = findViewById(R.id.textView);
        ans.setVisibility(ans.INVISIBLE);
        CountDownTimer cdt = new CountDownTimer(30000 ,1000 ) {
            @Override
            public void onTick(long millisUntilFinished) {


                int t = (int) (millisUntilFinished / 1000);
                String string, string1;
                string = Integer.toString(t);
                if (t >= 10) {

                    string1 = "00:" + string;
                } else {
                    string1 = "00:0" + string;

                }
                timer.setText(string1);

            }

            @Override
            public void onFinish() {

                ans.setText("TimeUp! Correct answer is James Gosling");
                ans.setVisibility(ans.VISIBLE);

            }
        }.start();

        Question.setText("Who invented Java?" );
        rb1.setText("Bill Gates");
        rb2.setText("James Gosling");
        rb3.setText("Bjarne Stroustrup");
        rb4.setText("None of the Above");
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cdt.cancel();

                int select = radiogroup.getCheckedRadioButtonId();
                rb5 = findViewById(select);
                String s1 = rb5.getText().toString();
                String str1="";

                if(s1=="James Gosling")
                {
                    str1 = "Hurray! Your submitted answer is Right!";
                }
                else
                {
                    str1 = "Oh! Your submitted answer is wrong, Try Again!";
                }
                ans.setText(str1);
                ans.setVisibility(ans.VISIBLE);




            }
        });

    }
}