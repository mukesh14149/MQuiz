package com.example.mukesh.mquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class HintActivity extends AppCompatActivity {

    public static boolean hint_used;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        hint_used=false;

        final TextView help_view=(TextView)findViewById(R.id.help_view_hint);
        help_view.setText(getString(R.string.Welcome_msg));


        Button button=(Button)findViewById(R.id.ShowHint);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                hint_used=true;
                help_view.setTextSize(20);
                help_view.setText(getString(R.string.hint_msg));
            }
        });




    }

    @Override
    public void onBackPressed() {
        String help_taken=null;
        Intent intent=getIntent();
        if(hint_used)
            help_taken=getString(R.string.help_taken_hint);
        intent.putExtra("Press",help_taken);
        setResult(RESULT_OK,intent);
        super.onBackPressed();
    }



}
