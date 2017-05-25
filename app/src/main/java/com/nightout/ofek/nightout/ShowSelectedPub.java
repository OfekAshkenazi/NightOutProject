package com.nightout.ofek.nightout;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import Objects.Pub;

public class ShowSelectedPub extends AppCompatActivity {
    TextView name,address,visitH,capacity,age,phone,desc;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_selected_pub);
        name=(TextView) findViewById(R.id.nameTextView);
        address=(TextView) findViewById(R.id.addressTextView);
        visitH = (TextView) findViewById(R.id.visitHTextView);
        capacity=(TextView) findViewById(R.id.capTextV);
        age=(TextView) findViewById(R.id.ageTextV);
        phone=(TextView) findViewById(R.id.phoneNumTextView);
        desc=(TextView) findViewById(R.id.descriptionTextView);
        ratingBar=(RatingBar) findViewById(R.id.ratingbarPub);
        Pub pub=(Pub) getIntent().getExtras().get("pub");
        getIntent().removeExtra("pub");
        setTextViews(pub);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                String phoneText=phone.getText().toString();
                ClipData clip= ClipData.newPlainText("phone",phoneText);
                clipboard.setPrimaryClip(clip);
            }
        });
    }
    public void setTextViews(Pub pub){
        name.setText(pub.getName());
        address.setText(pub.getAddress());
        visitH.setText(pub.getVisitHours());
        capacity.setText(Integer.toString(pub.getCapacity()));
        age.setText(Integer.toString(pub.getAge()));
        phone.setText(pub.getPhone());
        desc.setText(pub.getDesc());
        //ratingBar.setNumStars(pub.getRating());
    }
}
