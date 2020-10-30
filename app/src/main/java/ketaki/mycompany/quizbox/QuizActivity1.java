package ketaki.mycompany.quizbox;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity1 extends AppCompatActivity {
  private Button nextButton;
  private TextView Question,noIndicator,ans,timer;
  private RadioGroup radiogroup;
  private RadioButton rb1,rb2,rb3,rb4,rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        nextButton = findViewById(R.id.nextButton);
        Question = findViewById(R.id.textView2);
        noIndicator = findViewById(R.id.textView1);
        radiogroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        timer = findViewById(R.id.textView);
         ans = findViewById(R.id.textViewAns);
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

                ans.setText("TimeUp! Correct answer is Bjarne Stroustrup");
                ans.setVisibility(ans.VISIBLE);

            }
        }.start();


         Question.setText("Who invented C++ ?" );
         rb1.setText("Bill Gates");
        rb2.setText("James Gosling");
        rb3.setText("Bjarne Stroustrup");
        rb4.setText("None of the Above");


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cdt.cancel();


               int select = radiogroup.getCheckedRadioButtonId();
               rb = findViewById(select);
               String s = rb.getText().toString();
               String str="";

               if(s=="Bjarne Stroustrup")
               {
                   str = "Hurray! Your submitted answer is Right!";
               }
               else
               {
                   str = "Oh! Your submitted answer is wrong, Try Again!";
               }
                ans.setText(str);
               ans.setVisibility(ans.VISIBLE);




            }
        });



    }



}