package com.example.mukesh.mquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int random_no;
    Context context = null;
    int duration = Toast.LENGTH_SHORT;
    CharSequence toast_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=getApplicationContext();


        TextView text = (TextView) findViewById(R.id.Query);
        if(savedInstanceState!=null) {
            super.onRestoreInstanceState(savedInstanceState);
            random_no=savedInstanceState.getInt("Random_no");
            Query(text, random_no, getString(R.string.query_message));
        }
        else{
            random_no=getRandom_no();
            Query(text, random_no, getString(R.string.query_message));
        }

        //Button for Generating new query
        Button next = (Button) findViewById(R.id.Next_ques);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text = (TextView) findViewById(R.id.Query);
                random_no=getRandom_no();
                Query(text, random_no, getString(R.string.query_message));
            }
        });

        //Button for True
        Button correct = (Button) findViewById(R.id.Correct);
        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isprime(random_no)==1)
                    toast_text = getString(R.string.positive_message);
                else
                    toast_text = getString(R.string.negative_message);

                Toast toast = Toast.makeText(context, toast_text, duration);
                toast.show();
            }
        });

        //Button for false
        Button wrong = (Button) findViewById(R.id.Wrong);
        wrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isprime(random_no)==0)
                    toast_text = getString(R.string.positive_message);
                else
                    toast_text = getString(R.string.negative_message);
                Toast toast = Toast.makeText(context, toast_text, duration);
                toast.show();
            }
        });



        Button hint = (Button) findViewById(R.id.Hint);
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(getApplicationContext(),HintActivity.class);
                intent.putExtra("Prime_no",Integer.toString(random_no));
                startActivityForResult(intent, 1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1){
            if(resultCode==RESULT_OK&&data.getStringExtra("Press")!=null){
                Toast toast = Toast.makeText(context, data.getStringExtra("Press"), duration);
                toast.show();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("Random_no", random_no);
        super.onSaveInstanceState(savedInstanceState);
    }

    public static int getRandom_no(){
        return (int)(Math.random()*1000+1);
    }

    public static int isprime(int n){
        if(n==1)
            return 1;

        for(int i=2;i<n/2;i++){
            if(n%i==0){
                return 0;
            }
        }
        return 1;
    }

    public static void Query(TextView text, int random_no, String query){
        String ques=random_no+" "+query;
        text.setText(ques);
    }

}
