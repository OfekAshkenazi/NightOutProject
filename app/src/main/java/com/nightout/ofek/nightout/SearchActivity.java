package com.nightout.ofek.nightout;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Stack;

import Objects.Pub;

public class SearchActivity extends AppCompatActivity {
    Spinner spinner;
    String[] Types,names;
    Button ok;
    int counter;
    TextView textView;
    Stack<String> pubsNames;
    ListView namesList;
    DatabaseReference MyRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        spinner=(Spinner) findViewById(R.id.spinner);
        Types=new String[]{"Club","Event","Pub/Bar"};
        ok=(Button) findViewById(R.id.ok_button);
        namesList=(ListView) findViewById(R.id.NamesList);
        MyRef= FirebaseDatabase.getInstance().getReference("Pubs");
        pubsNames=new Stack<>();
        textView=(TextView)findViewById(R.id.textView);
        setPubsList();
        names=new String[counter];
        setSpinner(this);
    }
    private void setPubsList(){
        counter=0;
        MyRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    pubsNames.push(postSnapshot.getValue(Pub.class).getName());
                    counter++;
                    setListView();
                }
                textView.setText("Snap Loaded");
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                textView.setText("database error");
            }
        });

    }
    public void setSpinner(Context context) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, Types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
  /*  public void
  setDefaultFragment(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        SearchBar searchBar=new SearchBar();
        fragmentTransaction.add(R.id.frag_container1,searchBar);
        fragmentTransaction.commit();
    }*/
    private void setListView(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pubsNames);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        namesList.setAdapter(adapter);
    }
    /*private void toArray(){
        for (int i=0;i<names.length;i++){
            names[i] = pubsNames.pop().getName();
            textView.setText("casted to array");
        }
    }
    */
}



