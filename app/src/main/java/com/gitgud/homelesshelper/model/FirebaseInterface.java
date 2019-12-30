package com.gitgud.homelesshelper.model;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Mac on 3/23/2018.
 * THIS LINE
 */

class FirebaseInterface {




    //mRef = new Firebase("https://cs-2340-software.firebaseio.com/");
    private static final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static final DatabaseReference mRef =
            database.getReference("https://cs-2340-software.firebaseio.com/");


    //DatabaseReference usersRef = database.child("user");

    public static void addUser(User u){
        DatabaseReference mRefChild = mRef.child(u.getpassWord());
        mRefChild.setValue(u);
    }
}
