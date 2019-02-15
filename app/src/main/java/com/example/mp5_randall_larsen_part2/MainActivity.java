package com.example.mp5_randall_larsen_part2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private static final String[] WORDS ={"Cool Test","Color Test","Up Test"};
    private static final int REQ_CODE_ANS = 2468;
     public static  int score_int = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //attach reference list to mylist
        ListView list = (ListView) findViewById(R.id.mylist);

        final Intent forwardIntent = new Intent(this,quiz.class);

        //Create adapter and attach to WORDS
        ArrayAdapter<String> myadapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,WORDS);

        //Use myadapter as input to list
        list.setAdapter(myadapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String word = parent.getItemAtPosition(position).toString();
                forwardIntent.putExtra("animal",word);

                //Since I want a result to come back
                startActivityForResult(forwardIntent,REQ_CODE_ANS);
            }

        });

    }
    public void reset(View view) {
        score_int = 0;
    }

    //BackIntent returns control back here
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        TextView score = findViewById(R.id.score);
        if(requestCode==REQ_CODE_ANS) {
            String ret_ans = intent.getStringExtra("family");
            if(ret_ans.equals("true") == true){
                score_int = score_int + 1;
            }
            score.setText(Integer.toString(score_int));
            Toast.makeText(MainActivity.this, ret_ans, Toast.LENGTH_SHORT).show();
        }
    }
}
