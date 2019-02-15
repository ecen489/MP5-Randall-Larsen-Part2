package com.example.mp5_randall_larsen_part2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class quiz extends AppCompatActivity {

    private static final String[] WORDS ={"Cool Test","Color Test","Up Test"};
    private static final String[] ANS_array ={"yes","blue","the sky"};
    private static  int index = 0;
    private static  String  pass = "true";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent forwardIntent = getIntent();
        String extra = forwardIntent.getStringExtra("animal");
       // ImageView img = (ImageView) findViewById(R.id.myimg);
        TextView question = findViewById(R.id.question);

        if (extra.equals(WORDS[0])) {
            question.setText("Are cats cool? (yes or no) Hint:yes");
            index = 0;
        }

        if (extra.equals(WORDS[1])) {
            question.setText("What color is the sky? Hint:blue");
            index = 1;
        }

        if (extra.equals(WORDS[2])) {
            question.setText("What's up? Hint:the sky");
            index = 2;
        }
    }

    public void myclick (View view){

        EditText anstxt = (EditText) findViewById(R.id.myans);
        String ans;
        //Returning the answer back to the calling activity
        Intent backIntent = new Intent();
        ans = anstxt.getText().toString();

        if(ans.equals( ANS_array[index]) == true){
            pass = "true";

        }
        else {
            pass = "false";
        }


        backIntent.putExtra("family", pass);
        setResult(RESULT_OK, backIntent);
        finish();
    }
}