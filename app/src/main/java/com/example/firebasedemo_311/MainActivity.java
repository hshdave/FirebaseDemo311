package com.example.firebasedemo_311;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txt_name,txt_watcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt_name = findViewById(R.id.name);
        txt_watcher = findViewById(R.id.watcher);

        FirebaseApp.initializeApp(this);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("items");


        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);



/*
                DataSnapshot snap = dataSnapshot.child("0");

                int watch = Integer.parseInt(snap.child("watchers").getValue().toString());
                String name = snap.child("full_name").getValue().toString();
                String nanme = snap.child("full_name").getValue(String.class);

                txt_name.setText(name);
                txt_watcher.setText(""+watch);
*/



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });





    }
}
