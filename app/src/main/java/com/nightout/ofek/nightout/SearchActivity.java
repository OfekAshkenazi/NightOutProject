package com.nightout.ofek.nightout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;

import Objects.Pub;

public class SearchActivity extends AppCompatActivity {
    Spinner spinner;
    String[] Types,names;
    Button ok;
    int counter;
    TextView textView;
    Context context;
    List<Pub> pubsList;
    List<String> pubsNames;
    ListView namesList;
    DatabaseReference MyRef;
    public ValueEventListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        spinner=(Spinner) findViewById(R.id.spinner);
        Types=new String[]{"Club","Event","Pub/Bar"};
        ok=(Button) findViewById(R.id.ok_button);
        namesList=(ListView) findViewById(R.id.NamesList);
        MyRef= FirebaseDatabase.getInstance().getReference("Pubs");
        pubsNames=new LinkedList<>();
        pubsList=new LinkedList<>();
        textView=(TextView)findViewById(R.id.textView);
        setPubsList();
        names=new String[counter];
        setSpinner(this);
        context=this;
        namesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = ((TextView)view).getText().toString();// second method
                Intent intent=new Intent(context,ShowSelectedPub.class);
                Pub pub=findPubByName(text);
                intent.putExtra("pub",pub);
                startActivity(intent);
            }
        });
    }
    private void setPubsList(){
        listener=new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    pubsNames.add(postSnapshot.getValue(Pub.class).getName());
                    pubsList.add(postSnapshot.getValue(Pub.class));
                }

                setListView();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast toast=Toast.makeText(context,"Snapshot Error Number 1",Toast.LENGTH_LONG);
            }
        };
        MyRef.addListenerForSingleValueEvent(listener);

    }
    public void setSpinner(Context context) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, Types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void setListView(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pubsNames);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        namesList.setAdapter(adapter);
    }
    public Pub findPubByName(String pubName){
        for (int i=0;i<pubsList.size();i++){
            if (pubsList.get(i).getName().equals(pubName)) {
                return pubsList.get(i);
            }
        }
        return null;
    }
}



