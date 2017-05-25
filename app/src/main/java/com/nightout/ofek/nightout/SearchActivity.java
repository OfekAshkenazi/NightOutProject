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

import Objects.Club;
import Objects.Event;
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
    List<Event> eventsList;
    List<String> eventsNames;
    List<Club> clubsList;
    List<String> clubsNames;
    ListView namesList;
    DatabaseReference EventRef,ClubRef,PubRef;
    public ValueEventListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        spinner=(Spinner) findViewById(R.id.spinner);
        Types=new String[]{"Club","Event","Pub/Bar"};
        ok=(Button) findViewById(R.id.ok_button);
        namesList=(ListView) findViewById(R.id.NamesList);
        pubsNames=new LinkedList<>();
        pubsList=new LinkedList<>();
        clubsList=new LinkedList<>();
        clubsNames=new LinkedList<>();
        eventsList=new LinkedList<>();
        eventsNames=new LinkedList<>();
        Pub pub=new Pub();
        textView=(TextView)findViewById(R.id.textView);
        names=new String[counter];
        setSpinner(this);
        context=this;
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getSelectedItem().equals("Event")) {
                    setEventList();
                    namesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            startShowObjects("Event", view);
                        }
                    });
                }
                if (spinner.getSelectedItem().toString().equals("Club")) {
                    setClubList();
                    namesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            startShowObjects("Club", view);
                        }
                    });
                }
                if (spinner.getSelectedItem().toString().equals("Pub/Bar")){
                    setPubsList();
                    namesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            startShowObjects("Pub", view);
                        }
                    });
                }
            }
        });
    }
    private void startShowObjects(String className,View view){
        String text = ((TextView)view).getText().toString();// second method
        if (className.equals("Pub")) {
            Intent intent=new Intent(context,ShowSelectedPub.class);
            Pub pub = findPubByName(text, pubsList);
            intent.putExtra("pub", pub);
            startActivity(intent);
        }
        if (className.equals("Event")){
                Intent intent=new Intent(context,ShowSelectedEvent.class);
                Event event = findEventByName(text, eventsList);
                intent.putExtra("event", event);
                startActivity(intent);
            }
        if (className.equals("Club")){
                Intent intent=new Intent(context,ShowSelectedClub.class);
                Club club = findClubByName(text, clubsList);
                intent.putExtra("club", club);
                startActivity(intent);
            }
    }
    private void setPubsList(){
        PubRef= FirebaseDatabase.getInstance().getReference("Pubs");
        if (!pubsList.isEmpty()||!pubsNames.isEmpty()) {
            pubsNames.clear();
            pubsList.clear();
        }
        PubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    pubsNames.add(postSnapshot.getValue(Pub.class).getName());
                    pubsList.add(postSnapshot.getValue(Pub.class));
                }

                setListView(pubsNames);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast toast=Toast.makeText(context,"Snapshot Error Number 1",Toast.LENGTH_LONG);
            }
        });

    }
    private void setEventList(){
        EventRef= FirebaseDatabase.getInstance().getReference("Events");
        if (!eventsList.isEmpty()||!eventsNames.isEmpty()) {
            eventsList.clear();
            eventsNames.clear();
        }
        EventRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    eventsNames.add(postSnapshot.getValue(Event.class).getName());
                    eventsList.add(postSnapshot.getValue(Event.class));
                }

                setListView(eventsNames);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast toast=Toast.makeText(context,"Snapshot Error Number 1",Toast.LENGTH_LONG);
            }
        });

    }
    private void setClubList(){
        ClubRef= FirebaseDatabase.getInstance().getReference("Clubs");
        if (!clubsList.isEmpty()||!clubsNames.isEmpty()) {
            clubsList.clear();
            clubsNames.clear();
        }
        ClubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    clubsNames.add(postSnapshot.getValue(Club.class).getName());
                    clubsList.add(postSnapshot.getValue(Club.class));
                }

                setListView(clubsNames);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast toast=Toast.makeText(context,"Snapshot Error Number 1",Toast.LENGTH_LONG);
            }
        });

    }
    public void setSpinner(Context context) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, Types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void setListView(List<String> names){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        namesList.setAdapter(adapter);
    }
    public Pub findPubByName(String pubName,List<Pub> pubsList1){
        for (int i=0;i<pubsList1.size();i++){
            if (pubsList1.get(i).getName().equals(pubName)) {
                return pubsList1.get(i);
            }
        }
        return null;
    }
    public Event findEventByName(String pubName,List<Event> eventList1){
        for (int i=0;i<eventList1.size();i++){
            if (eventList1.get(i).getName().equals(pubName)) {
                return eventList1.get(i);
            }
        }
        return null;
    }
    public Club findClubByName(String pubName,List<Club> clubsList1){
        for (int i=0;i<clubsList1.size();i++){
            if (clubsList1.get(i).getName().equals(pubName)) {
                return clubsList1.get(i);
            }
        }
        return null;
    }
}



