package com.example.mukesh.mquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static TextView text;
    public static int ran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.Query);
        if(savedInstanceState!=null) {
            super.onRestoreInstanceState(savedInstanceState);
            ran=savedInstanceState.getInt("store");
            Query(ran);


        }
        else{
            ran=(int)(Math.random()*1000+1);
            Query(ran);
        }
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ran=(int)(Math.random()*1000+1);
                Query(ran);
            }
        });


        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                CharSequence text;
                if(prime(ran)==0)
                    text = "congo";
                else
                    text = "sorry";

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });


        Button button2 = (Button) findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                CharSequence text;
                if(prime(ran)==1)
                    text = "congo";
                else
                    text = "sorry";

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

    }



    public static int prime(int n){
        if(n==1)
            return 1;

        for(int i=2;i<n/2;i++){
            if(n%i==0){
                return 0;
            }

        }
        return 1;
    }
    public static void Query(int ran){

        text.setText(ran+"query");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt("store", ran);
        super.onSaveInstanceState(savedInstanceState);
    }

}
