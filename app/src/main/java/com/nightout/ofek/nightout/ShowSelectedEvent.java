package com.nightout.ofek.nightout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import Objects.Event;

public class ShowSelectedEvent extends AppCompatActivity {
    TextView name,address,publicity,capacity,age,price,desc,type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_selected_event);
        name=(TextView) findViewById(R.id.nameTextVE);
        address=(TextView) findViewById(R.id.addressTextVE);
        publicity = (TextView) findViewById(R.id.publicityTextVE);
        capacity=(TextView) findViewById(R.id.capTextVE);
        age=(TextView) findViewById(R.id.ageTextVE);
        price=(TextView) findViewById(R.id.priceTextVE);
        desc=(TextView) findViewById(R.id.descriptionTextVE);
        type=(TextView) findViewById(R.id.typeTextVE);
        Event event=(Event) getIntent().getExtras().get("event");
        getIntent().removeExtra("event");
        setTextViews(event);
    }
    private void setTextViews(Event event){
        name.setText(event.getName());
        address.setText(event.getAddress());
        publicity.setText(event.getPublicity());
        capacity.setText(event.getCapacity());
        age.setText(event.getAge());
        price.setText(event.getPrice());
        desc.setText(event.getDesc());
        type.setText(event.getType());
    }
}
