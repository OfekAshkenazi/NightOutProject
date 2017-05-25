package com.nightout.ofek.nightout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Objects.Club;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddClub extends Fragment {
    EditText name;
    EditText line;
    EditText price;
    EditText address;
    EditText capacity;
    EditText desc;
    EditText age;
    Button create;
    FirebaseDatabase database;
    DatabaseReference myRef;

    public AddClub() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_add_club, container, false);
        name = (EditText) view.findViewById(R.id.name);
        price = (EditText) view.findViewById(R.id.price);
        address = (EditText) view.findViewById(R.id.adress);
        capacity = (EditText) view.findViewById(R.id.capacity);
        desc = (EditText) view.findViewById(R.id.description);
        age = (EditText) view.findViewById(R.id.age);
        line = (EditText) view.findViewById(R.id.line);
        create = (Button) view.findViewById(R.id.create);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Clubs");
        createClub();

        return view;
    }
    public void clearEditTexts(){
        name.setText("");
        price.setText("");
        address.setText("");
        capacity.setText("");
        desc.setText("");               //clear all text boxes
        age.setText("");
        line.setText("");
    }
    public boolean isFullyEntered(){
        if (name.getText().toString().matches("")==false && price.getText().toString().matches("")==false && address.getText().toString().matches("")==false
                && capacity.getText().toString().matches("")==false && line.getText().toString().matches("")==false && age.getText().toString().matches("")==false)
            return true;                                                                                                                        //return true only if all boxes are registered
        else
            return false;
    }

    public void createClub(){
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Line,Name, Address, Date, Time, Desc;
                Club club;
                int Price, Capacity,Age;
                if (isFullyEntered()){
                    Name=name.getText().toString();
                    Address=address.getText().toString();
                    Line=line.getText().toString();
                    Price = Integer.parseInt(price.getText().toString());
                    Capacity = Integer.parseInt(capacity.getText().toString());                                            //insert all text boxes to 'club'. push 'club' to firebase
                    Age = Integer.parseInt(age.getText().toString());
                    Club club1=new Club(Name,Line,Address,Capacity,Age,Price);
                    if (desc.getText().toString().matches("")==false){
                        Desc=desc.getText().toString();
                        club1.setDesc(Desc);
                    }
                    myRef.child(Name).setValue(club1);
                    clearEditTexts();
                }
                else
                    Toast.makeText(getContext(),"please make sure you entered all parameters",Toast.LENGTH_LONG).show();

            }
        });
    }



}
