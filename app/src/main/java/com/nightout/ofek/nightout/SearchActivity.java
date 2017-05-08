package com.nightout.ofek.nightout;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SearchActivity extends AppCompatActivity {
    Spinner spinner;
    String[] Types;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        spinner=(Spinner) findViewById(R.id.spinner);
        Types=new String[]{"Club","Event","Pub/Bar"};
        ok=(Button) findViewById(R.id.ok_button);
        setSpinner(this);
    }
    public void setSpinner(Context context) {
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,Types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
