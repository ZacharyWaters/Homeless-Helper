package com.gitgud.homelesshelper.model;

import com.firebase.client.Firebase;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Conner Mathis on 3/23/2018.
 * THIS LINE
 */

public class UserAuthentication {
    private Firebase mRef;
    //static FirebaseDatabase database = FirebaseDatabase.getInstance();
    //Firebase passwordRef = database.getReference("https://cs-2340-software.firebaseio.com/");
    //database.on
    //mRef = new Firebase("https://cs-2340-software.firebaseio.com/");
    private static ArrayList<User> permanence;
    public static final ArrayList<String> legalClassification =
            new ArrayList<>(Arrays.asList("User", "Admin"));

    /**
     * @param s String
     * @param t String
     * @return boolean
     */
    public static boolean isValidUser(String s, CharSequence t) {

        return isValidUsername(s) && isValidPassword(t);
    }

    /**
     * @param s String
     * @return boolean
     */
    public static boolean isValidUsername(String s) {
        //need a firebase already has tbis username in it
        boolean isValid = true;
        for(User user : permanence) {
            //Log.d("username", user.getuserName());
            if(user.getuserName().equals(s)) {
                isValid = false;
            }
        }
        String test = "false";
        if(isValid) {
            test = "true";
        }
        //Log.d("validity", test);
        return isValid && (s.length() > 4) && s.contains("@");
    }

    /**
     * @param s String
     * @return boolean
     */
    public static boolean isValidPassword(CharSequence s) {
        //need a firebase already has this password
        //Firebase.setAndroidContext(this);
        //final DatabaseReference dinosaursRef = database.getReference(s);
        boolean isValid = true;
        for(User user : permanence) {
            //Log.d("password", user.getpassWord());
            if(user.getpassWord().equals(s)) {
                isValid = false;
            }
        }



        return isValid && (s.length() > 4);
    }

    /**
     * @param l array list of users
     */
    public static void setList(ArrayList<User> l) {
        permanence = l;
    }

    /**
     * @return arraylist of users
     */
    public static ArrayList<User> getList() {
        return permanence;
    }

    /**
     * @param s String
     * @param t String
     * @return boolean
     */
    public static boolean isValidCombination(String s, String t) {
        if ((s == null) || (t == null)) {
            throw new IllegalArgumentException("the password and username cannot be null");
        }
        //need a firebase on same user line
        boolean isValid = false;
        for(User user : permanence) {
            if(user.getpassWord().equals(s) && user.getuserName().equals(t)) {
                isValid = true;
            }
        }
        return isValid;
    }

    /**
     * @param s String
     * @return user
     */
    public static User getCurrentUser(String s) {
        for (User user : permanence) {
            if(user.getuserName().equals(s)) {
                return user;
            }
        }
        return null;
    }
}
