package com.something.nightcoreapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class About_me extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        Button btn=findViewById(R.id.bttn);

        final TextView tv=findViewById(R.id.mutlitext);
        final TextView linker=findViewById(R.id.clickable);
       // aboutMe="My name is Mimo";

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Goback();
            }
        });
        FirebaseDatabase fb=FirebaseDatabase.getInstance();
        DatabaseReference aboutref= fb.getReference("aboutme");
        DatabaseReference link=fb.getReference("URL");
        aboutref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 tv.setText( dataSnapshot.getValue(String.class));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
      //  tv.setText(aboutMe);
        link.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                linker.setText(Html.fromHtml(dataSnapshot.getValue(String.class)));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void Goback()
    {
        /*Intent it0=new Intent(this,MainActivity.class);
        startActivity(it0);*/
        finish();
    }
}
