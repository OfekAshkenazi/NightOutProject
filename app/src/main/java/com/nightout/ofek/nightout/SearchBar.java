package com.nightout.ofek.nightout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;

import Objects.Pub;

public class SearchBar extends Fragment {
    TextView name,address,visitH,capacity,age,phone,desc;
    List<String> pubsNames;
    DatabaseReference pubsListDatabase;
    Spinner spinner;
    public SearchBar(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_search_bar, container, false);
        name=(TextView) view.findViewById(R.id.nameTextView);
        address=(TextView) view.findViewById(R.id.addressTextView);
        visitH = (TextView) view.findViewById(R.id.visitHTextView);
        capacity=(TextView) view.findViewById(R.id.capTextV);
        age=(TextView) view.findViewById(R.id.ageTextV);
        phone=(TextView) view.findViewById(R.id.phoneNumTextView);
        desc=(TextView) view.findViewById(R.id.descriptionTextView);
        pubsListDatabase= FirebaseDatabase.getInstance().getReference("Pubs");
        pubsNames=new LinkedList<>();
        setPubsArray();
        spinner=(Spinner) view.findViewById(R.id.spinner2);
        setSpinner();
        return view;
    }
    private void setPubsArray(){

        pubsListDatabase.addValueEventListener(new ValueEventListener() {
            int i=0;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    pubsNames.add(postSnapshot.getValue(Pub.class).getName());
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void setSpinner() {
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this.getContext(),R.layout.support_simple_spinner_dropdown_item,pubsNames);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
