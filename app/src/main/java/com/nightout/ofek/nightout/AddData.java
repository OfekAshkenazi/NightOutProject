package com.nightout.ofek.nightout;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class AddData extends AppCompatActivity {
    Spinner spinner;
    String[] Types;
    Button commit;
    RelativeLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        defaultFragment();
        spinner=(Spinner) findViewById(R.id.data_picker);
        container=(RelativeLayout) findViewById(R.id.frag_container);
        Types=new String[]{"Club","Event","Pub/Bar"};
        setSpinner(this);
        commit=(Button) findViewById(R.id.commit);
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=spinner.getSelectedItem().toString();
                container.removeAllViews();
                setFragment(str);

            }
        });
    }
    public void defaultFragment(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        AddClub addClub=new AddClub();
        fragmentTransaction.add(R.id.frag_container,addClub);
        fragmentTransaction.commit();
    }
    public void setSpinner(Context context) {
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,Types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    public void setFragment(String type){
        if (type.equals("Club")){
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            AddClub addClub=new AddClub();
            fragmentTransaction.add(R.id.frag_container,addClub);
            fragmentTransaction.commit();
        }
        if (type.equals("Event")){
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            AddEvent addEvent=new AddEvent();
            fragmentTransaction.add(R.id.frag_container,addEvent);
            fragmentTransaction.commit();
        }
        if (type.equals("Pub/Bar"))
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            AddPub addPub=new AddPub();
            fragmentTransaction.add(R.id.frag_container,addPub);
            fragmentTransaction.commit();
        }
    }
}
