package ketaki.mycompany.quizbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Selection extends AppCompatActivity {
    CheckBox cb1, cb2, cb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);



        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);

        Button proceedButton = (Button) findViewById(R.id.nextButton);
           proceedButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                    boolean flag = false;
                   if(cb1.isChecked() && cb2.isChecked()==false && cb3.isChecked()==false) {
                       openActivity1();
                       flag = true;
                   }
                  if(cb2.isChecked() && cb1.isChecked()==false && cb3.isChecked()==false) {
                      openActivity2();
                      flag = true;
                  }
                  if(cb3.isChecked() && cb1.isChecked()==false && cb2.isChecked()==false){
                       openActivity3();
                       flag = true;
                  }
                    if(flag == false) {
                        Toast.makeText(Selection.this, "Please Select Only One Language!", Toast.LENGTH_SHORT).show();
                    }



               }
           });
    }

     public void openActivity1()
     {
         Intent intent = new Intent(this, QuizActivity1.class);

         startActivity(intent);
     }
    public void openActivity2()
    {
        Intent intent = new Intent(this, QuizActivity2.class);

        startActivity(intent);
    }
    public void openActivity3()
    {
        Intent intent = new Intent(this, QuizActivity3.class);

        startActivity(intent);
    }


}