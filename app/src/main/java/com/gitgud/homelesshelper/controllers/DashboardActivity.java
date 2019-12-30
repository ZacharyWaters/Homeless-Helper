package com.gitgud.homelesshelper.controllers;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.firebase.client.Firebase;
import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.CSVParser;
import com.gitgud.homelesshelper.model.Shelter;


import static com.gitgud.homelesshelper.controllers.LoginActivity.currentUser;

/**
 * Created by collin on 2/13/18.
 * THIS LINE
 */

public class DashboardActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //Database Stuff
        Firebase.setAndroidContext(this);
        Firebase mRef = new Firebase("https://cs-2340-software.firebaseio.com/");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        TextView type = findViewById(R.id.textView3);
        type.setText(currentUser.getclasss());
        TextView name = findViewById(R.id.textView4);
        name.setText(currentUser.getname());

        Button logoutButton = findViewById(R.id.buttonLogout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button viewShelterButton = findViewById(R.id.buttonViewShelter);
        viewShelterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, ShelterViewActivity.class));
            }
        });

        Button viewSearchButton = findViewById(R.id.gotosearch);
        viewSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, ShelterSearchActivity.class));
            }
        });

        CSVParser stuff = new CSVParser(DashboardActivity.this);
        Firebase mRefChild = mRef.child("Shelter");
        mRefChild.setValue(Shelter.getShelterList());
    }
}
