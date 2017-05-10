package com.nightout.ofek.nightout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonS=(Button) findViewById(R.id.Bsearch);
        Intent intent=new Intent(this,SearchActivity.class);
        onClick1(intent);
    }
    public void onClick(View view){
        Intent intent=new Intent(this,AddData.class);
        startActivity(intent);
    }

    public void onClick1(final Intent intent){
        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
