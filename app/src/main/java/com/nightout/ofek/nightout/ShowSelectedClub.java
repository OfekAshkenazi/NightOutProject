package com.nightout.ofek.nightout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

import Objects.Club;

public class ShowSelectedClub extends AppCompatActivity {
    TextView name,line,address,capacity,age,price,desc;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_selected_club);
        name = (TextView) findViewById(R.id.nameTextVC);
        address = (TextView) findViewById(R.id.addressTextVC);
        line = (TextView) findViewById(R.id.lineTextVC);
        capacity = (TextView) findViewById(R.id.capTextVC);
        age = (TextView) findViewById(R.id.ageTextVC);
        price = (TextView) findViewById(R.id.priceTextVC);
        desc = (TextView) findViewById(R.id.descriptionTextVC);
        ratingBar = (RatingBar) findViewById(R.id.ratingbarClub);
        Club club = (Club) getIntent().getExtras().get("club");
        getIntent().removeExtra("club");
    }
    public void setTextViews(Club club){
        name.setText(club.getName());
        address.setText(club.getAddress());
        line.setText(club.getLine());
        capacity.setText(Integer.toString(club.getCapacity()));
        age.setText(Integer.toString(club.getAge()));
        price.setText(Integer.toString(club.getPrice()));
        desc.setText(club.getDesc());
        ratingBar.setNumStars(club.getRating());
    }
}
