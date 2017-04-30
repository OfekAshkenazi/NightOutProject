package com.nightout.ofek.nightout;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddData extends AppCompatActivity {
    Spinner spinner;
    String[] Types;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        defaultFragment();
        Types=new String[]{"Club","Event","Pub/Bar"};
        setSpinner(spinner);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setFragment(spinner.getSelectedItem().toString());
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

    public void setSpinner(Spinner spinner) {
        ArrayAdapter<CharSequence> adapter=new ArrayAdapter<CharSequence>(this,R.layout.support_simple_spinner_dropdown_item,Types);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
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
    }
}
