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

import Objects.Pub;


/**
created By Ofek 3/5/17
 */
public class AddPub extends Fragment {
    EditText name,address,phone,desc,capacity,age,visitH;
    Button create;
    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_add_pub, container, false);
        name = (EditText) view.findViewById(R.id.name);
        address = (EditText) view.findViewById(R.id.adress);
        capacity = (EditText) view.findViewById(R.id.capacity);
        desc = (EditText) view.findViewById(R.id.description);
        age = (EditText) view.findViewById(R.id.age);
        create = (Button) view.findViewById(R.id.create);
        phone = (EditText) view.findViewById(R.id.phone);
        visitH = (EditText) view.findViewById(R.id.visitHbox);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Pubs");
        createPub();
        return view;
    }
    public void clearEditTexts(){
        name.setText("");
        address.setText("");
        capacity.setText("");
        visitH.setText("");
        desc.setText("");
        phone.setText("");
        age.setText("");
    }
    private boolean isFullyEntered() {
        if (name.getText().toString().matches("")==false && phone.getText().toString().matches("")==false && address.getText().toString().matches("")==false
                && capacity.getText().toString().matches("")==false && visitH.getText().toString().matches("")==false && age.getText().toString().matches("")==false)
            return true;
        else                                                                                        //return true only if all boxes are registered
            return false;
    }
        private void createPub(){
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Phone,Name, Address, VisitH, Desc;
                Pub pub;
                int Price, Capacity,Age;
                if (isFullyEntered()==true) {
                    Name = name.getText().toString();
                    Address = address.getText().toString();
                    Age = Integer.parseInt(age.getText().toString());
                    VisitH=visitH.getText().toString();
                    Capacity = Integer.parseInt(capacity.getText().toString());
                    Phone=phone.getText().toString();
                    pub = new Pub(Name,Address,Capacity,Age,VisitH,Phone);            //insert all text boxes to 'pub'. push 'pub' to firebase
                    if (desc.getText().toString().matches("")==false) {
                        Desc = desc.getText().toString();
                        pub.setDesc(Desc);
                    }
                    myRef.child(Name).setValue(pub);
                    clearEditTexts();
                }
                else {
                    Toast.makeText(getContext(),"please make sure you entered all parameters",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
