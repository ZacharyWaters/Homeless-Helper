package com.gitgud.homelesshelper.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.firebase.client.Firebase;
import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.User;
import com.gitgud.homelesshelper.model.UserAuthentication;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Collection;


/**
 *
 */
public class RegisterActivity extends AppCompatActivity {

    private EditText emailAddress;
    private EditText password;
    private EditText name;
    private Spinner classification;

    private View mProgressView;
    private View mLoginFormView;

    private final LoginActivity.UserLoginTask mAuthTask = null;

    private final Collection<User> tempList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        FirebaseApp.initializeApp(this);

        Firebase.setAndroidContext(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();
        databaseReference.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                for(DataSnapshot child: children) {
                    if(child != null) {
                        User user = child.getValue(User.class);
                        tempList.add(user);
                    }
                }
                UserAuthentication.setList((ArrayList<User>) tempList);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        emailAddress = findViewById(R.id.EmailAddress);
        password = findViewById(R.id.password);
        Button regButton = findViewById(R.id.registerButton);
        Button backButton = findViewById(R.id.backButton);
        name = findViewById(R.id.name);
        classification = findViewById(R.id.classificationSpinner);
        TextView type = findViewById(R.id.textView2);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegistration();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        UserAuthentication.legalClassification);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classification.setAdapter(adapter);


    }

    @SuppressWarnings("FeatureEnvy")
    private void attemptRegistration() {
        Editable emailAddressText = emailAddress.getText();
        String stringemailAddressText = emailAddressText.toString();
        Editable passwordText = password.getText();
        String stringpasswordText = passwordText.toString();
        Editable nameText = name.getText();
        String stringnameText = nameText.toString();
        if ((UserAuthentication.isValidUser(stringemailAddressText,
                stringpasswordText)&& !"name".equals(stringnameText))){

            Firebase.setAndroidContext(this);
            Firebase mRef = new Firebase("https://cs-2340-software.firebaseio.com/");
            Firebase mRef2 = mRef.child("Users");

            Editable emailAddressText2 = emailAddress.getText();
            String stringemailAddressText2 = emailAddressText.toString();
            Editable passwordText2 = password.getText();
            String stringpasswordText2 = passwordText.toString();
            Editable nameText2 = name.getText();
            String stringnameText2 = nameText.toString();
            Object classificationSelectedItem = classification.getSelectedItem();
            String stringclassSelectedItem = classificationSelectedItem.toString();

            User s = new User(stringemailAddressText2,
                    stringpasswordText2,
                    stringnameText2,
                    stringclassSelectedItem);
            //FirebaseInterface.addUser(s);
            Firebase mRefChild = mRef2.child(s.getpassWord());
            mRefChild.setValue(s);



            //startActivity(new Intent(RegisterActivity.this, LoadingScreenActivity.class));
            emailAddress.setText("validated");
            name.setText("validated");
            password.setText("validated");

            Editable emailAddressText3 = emailAddress.getText();
            String stringemailAddressText3 = emailAddressText3.toString();
            Editable nameText3 = name.getText();
            String stringnameText3 = nameText3.toString();
            Editable passwordText3 = password.getText();
            String stringpasswordText3 = passwordText3.toString();

            if ("validated".equals(stringemailAddressText3)
                    && "validated".equals(stringnameText3)
                    && "validated".equals(stringpasswordText3)) {
                finish();
            }


        } else {
            Editable passwordText4 = password.getText();
            String stringpasswordText4 = passwordText4.toString();
            if (! UserAuthentication.isValidPassword(stringpasswordText4)) {
               password.setText("Invalid Password");

           }
            Editable emailAddressText4 = emailAddress.getText();
            String stringemailAddressText4 = emailAddressText4.toString();
            if (! UserAuthentication.isValidUsername(stringemailAddressText4)){
               emailAddress.setText("Invalid Username");
           }
            Editable nameText4 = name.getText();
            String stringnameText4 = nameText4.toString();
            if ("name".equals(stringnameText4)) {
               name.setText("Invalid Name");
           }

        }

    }
}
