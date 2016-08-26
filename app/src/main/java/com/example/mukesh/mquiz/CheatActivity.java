package com.example.mukesh.mquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    public static boolean cheat_used;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        cheat_used=false;
        final TextView help_view=(TextView)findViewById(R.id.help_view_cheat);
        help_view.setText(getString(R.string.Welcome_msg));

        Button button1=(Button)findViewById(R.id.ShowCheat);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                cheat_used=true;
                String help_view_text=null;
                Intent intent=getIntent();
                int a=Integer.parseInt(intent.getStringExtra("Prime_no"));
                if(isprime(a)==1){
                    help_view_text=a+getString(R.string.cheat_msg_yes);
                }
                else{
                    help_view_text=a+getString(R.string.cheat_msg_no);
                }
                help_view.setText(help_view_text);
            }
        });

    }
    @Override
    public void onBackPressed() {
        String help_taken=null;
        Intent intent=getIntent();
        if(cheat_used)
            help_taken=getString(R.string.help_taken_cheat);
        intent.putExtra("Press",help_taken);
        setResult(RESULT_OK,intent);
        super.onBackPressed();
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
}
