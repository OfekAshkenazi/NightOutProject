package com.nightout.ofek.nightout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Objects.Event;

public class AddEvent extends Fragment {
        Spinner type;
        EditText name;
        EditText price;
        EditText address;
        EditText capacity;
        EditText date;
        EditText desc;
        EditText time;
        EditText age;
        Button create;
        FirebaseDatabase database;
        DatabaseReference myRef;
        String[] arr;
        @Nullable
        @Override

        public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
                View view=inflater.inflate(R.layout.fragment_event_add, container, false);
                arr=new String[]{"Bachelor","private party","public party"};
                type = (Spinner) view.findViewById(R.id.type_spinner);
                name = (EditText) view.findViewById(R.id.name);
                price = (EditText) view.findViewById(R.id.price);
                address = (EditText) view.findViewById(R.id.adress);
                capacity = (EditText) view.findViewById(R.id.capacity);
                date = (EditText) view.findViewById(R.id.date);
                desc = (EditText) view.findViewById(R.id.description);
                time = (EditText) view.findViewById(R.id.time);
                age = (EditText) view.findViewById(R.id.age);
                create = (Button) view.findViewById(R.id.create);
                database = FirebaseDatabase.getInstance();
                myRef = database.getReference("EventList");
                setSpinner();
                createEvent();
                return view;


        }
        public void setSpinner() {
                ArrayAdapter adapter =new ArrayAdapter(this.getContext(),android.R.layout.simple_spinner_item,arr);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                type.setAdapter(adapter);

        }
        public void clearEditTexts(){
                name.setText("");
                price.setText("");
                address.setText("");
                capacity.setText("");
                date.setText("");
                desc.setText("");
                time.setText("");
                age.setText("");
        }
        public boolean isFullyEntered(){
                return (name.getText()!=null&&price.getText()!=null&&address.getText()!=null&&capacity.getText()!=null&&date.getText()!=null&&time.getText()!=null&&age.getText()!=null);
        }
        public boolean isDescribed(){
                return (desc.getText()!=null);
        }
        public void createEvent(){
                create.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                String Type,Name, Address, Date, Time, Desc;
                                Event event;
                                int Price, Capacity,Age;
                                if (isFullyEntered()==true) {
                                        Type = type.getSelectedItem().toString();
                                        Name = name.getText().toString();
                                        Address = address.getText().toString();
                                        Date = date.getText().toString();
                                        Time = time.getText().toString();
                                        Age = Integer.parseInt(age.getText().toString());
                                        Price = Integer.parseInt(price.getText().toString());
                                        Capacity = Integer.parseInt(capacity.getText().toString());
                                        event = new Event(Type, Name, Address, Date, Capacity, Age, Price);
                                        if (isDescribed()==true) {
                                                Desc = desc.getText().toString();
                                                event.setDesc(Desc);
                                        }
                                        myRef.setValue(event);
                                        clearEditTexts();
                                }
                                else {
                                        Toast.makeText(getContext(),"please make sure you enterd all parameters",Toast.LENGTH_LONG).show();
                                }


                        }
                });
        }

}
