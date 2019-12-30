//package com.gitgud.homelesshelper.controllers;
//
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.View;
//import android.widget.TextView;
//
//import com.gitgud.homelesshelper.R;
//import com.gitgud.homelesshelper.model.Shelter;
//
//import org.w3c.dom.Text;
//
//public class ShelterDetailActivity extends AppCompatActivity {
//
//    private TextView name;
//    private TextView capacity;
//    private TextView restriction;
//    private TextView address;
//    private TextView longitude;
//    private TextView latitude;
//    private TextView number;
//    private TextView notes;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_shelter_detail);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        name = findViewById(R.id.ShelterNameLabel);
//        capacity = findViewById(R.id.ShelterCapacityLabel);
//        restriction = findViewById(R.id.ShelterRestrictionLabel);
//        address = findViewById(R.id.ShelterAddressLabel);
//        longitude = findViewById(R.id.ShelterLongitude);
//        latitude = findViewById(R.id.ShelterLatitude);
//        number = findViewById(R.id.ShelterNumberLabel);
//        notes = findViewById(R.id.ShelterNotesLabel);
//
//        String id = getIntent().getStringExtra(Shelter.SHELTER_NAME);
//        Log.e("myApp", id);
//        Shelter shelter = null;
//        if (id != null) {
//            shelter = Shelter.findShelter(id);
//        }
//        name.setText(name.getText() + "  " + shelter.getName());
//        capacity.setText(capacity.getText() + "  " + shelter.getCapacity());
//        restriction.setText(restriction.getText() + "  " + shelter.getRestriction());
//        address.setText(address.getText() + "  " + shelter.getAddress());
//        longitude.setText(longitude.getText() + "  " + shelter.getLongitude());
//        latitude.setText(latitude.getText() + "  " + shelter.getLatitude());
//        number.setText(number.getText() + "  " + shelter.getNumber());
//        notes.setText(notes.getText() + "  " + shelter.getNotes());
//    }
//
//
//}
package com.gitgud.homelesshelper.controllers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.firebase.client.Firebase;
import com.gitgud.homelesshelper.R;
import com.gitgud.homelesshelper.model.Shelter;
import com.gitgud.homelesshelper.model.User;
import java.util.ArrayList;
import java.util.Arrays;

import static com.gitgud.homelesshelper.model.Shelter.getShelterList;

/**
 *
 */
public class ShelterDetailActivity extends AppCompatActivity {

    private TextView name;
    private TextView capacity;
    private TextView restriction;
    private TextView address;
    private TextView longitude;
    private TextView latitude;
    private TextView number;
    private TextView notes;
    private TextView family;
    private TextView individual;
    private Spinner familySpinner;
    private Spinner individualSpinner;
    private Button reserveButton;
    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail);
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://cs-2340-software.firebaseio.com/");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = findViewById(R.id.ShelterNameLabel);
        capacity = findViewById(R.id.ShelterCapacityLabel);
        restriction = findViewById(R.id.ShelterRestrictionLabel);
        address = findViewById(R.id.ShelterAddressLabel);
        longitude = findViewById(R.id.ShelterLongitude);
        latitude = findViewById(R.id.ShelterLatitude);
        number = findViewById(R.id.ShelterNumberLabel);
        notes = findViewById(R.id.ShelterNotesLabel);
        family = findViewById(R.id.ShelterFamily);
        individual = findViewById(R.id.ShelterSingles);
        familySpinner = findViewById(R.id.FamilySpinner);
        individualSpinner = findViewById(R.id.IndividualSpinner);
        reserveButton = findViewById(R.id.ReserveButton);

        Intent intentgetstring = getIntent();
        String id = intentgetstring.getStringExtra(Shelter.SHELTER_NAME);
        Log.e("myApp", id);
        final Shelter shelter;
            shelter = Shelter.findShelter(id);

        final ArrayAdapter<String> familyAdapter;
        String[] sheltergetFamilyArray;
        sheltergetFamilyArray = shelter.getFamilyArray();
        familyAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                Arrays.asList(sheltergetFamilyArray));
        familyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        familySpinner.setAdapter(familyAdapter);

        String[] sheltergetIndividualArray;
        sheltergetIndividualArray = shelter.getIndividualArray();
        final ArrayAdapter<String> individualAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        Arrays.asList(sheltergetIndividualArray));
        individualAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        individualSpinner.setAdapter(individualAdapter);
        String sheltergetName;
        sheltergetName = shelter.getName();
        String sheltergetCapacity;
        sheltergetCapacity = shelter.getCapacity();
        String sheltergetRestriction;
        sheltergetRestriction = shelter.getRestriction();
        String sheltergetAddress;
        sheltergetAddress = shelter.getAddress();
        String sheltergetLongitude;
        sheltergetLongitude = shelter.getLongitude();
        String sheltergetLatitude;
        sheltergetLatitude = shelter.getLatitude();
        String sheltergetNumber;
        sheltergetNumber = shelter.getNumber();
        String sheltergetNotes;
        sheltergetNotes = shelter.getNotes();
        int sheltergetFamily;
        sheltergetFamily = shelter.getFamily();
        int sheltergetIndividual;
        sheltergetIndividual = shelter.getIndividual();

        this.name.setText(this.name.getText() + "  " + sheltergetName);
        this.capacity.setText(this.capacity.getText() + "  " + sheltergetCapacity);
        this.restriction.setText(this.restriction.getText() + "  " + sheltergetRestriction);
        this.address.setText(this.address.getText() + "  " + sheltergetAddress);
        longitude.setText(longitude.getText() + "  " + sheltergetLongitude);
        this.latitude.setText(this.latitude.getText() + "  " + sheltergetLatitude);
        this.number.setText(this.number.getText() + "  " + sheltergetNumber);
        this.notes.setText(this.notes.getText() + "  " + sheltergetNotes);
        this.family.setText(this.family.getText() + "  " + sheltergetFamily);
        this.individual.setText(this.individual.getText() + "  " + sheltergetIndividual);

        final User currentUser1 = User.getCurrentUser();
        boolean currentUser1HasReservation = currentUser1.isHasReservation();
        reserveButton.setText((currentUser1HasReservation)? "Cancel Reservation": "Reserve");

        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!currentUser1.isHasReservation()) {
                    int familyReservations
                            = Integer.parseInt(((familySpinner.
                            getSelectedItem() == null) ? "0" : familySpinner.
                            getSelectedItem().toString()));
                    int individualReservations =
                            Integer.parseInt(((individualSpinner.
                                    getSelectedItem() == null) ? "0" : individualSpinner.
                                    getSelectedItem().toString()));
                    shelter.reserveIndividual(individualReservations);
                    shelter.reserveFamily(familyReservations);

                    ShelterDetailActivity.this.family.setText("Family capacity " + shelter.getFamily());
                    ShelterDetailActivity.this.individual.setText("Singles capacity " + shelter.getIndividual());
                    currentUser1.setShelterReserved(shelter.getId());
                    currentUser1.setHasReservation(true);
                    currentUser1.setNumFamilyReserved(familyReservations);
                    currentUser1.setNumIndividualReserved(individualReservations);

//                    ArrayList<User> userlist = UserAuthentication.getList();
//                    for (User use: userlist) {
//                        if (use.getname().equals(User.getCurrentUser().getname())) {
//                            use = User.getCurrentUser();
//                        }
//                    }

                    mRef = new Firebase("https://cs-2340-software.firebaseio.com/");
                    Firebase mRef2 = mRef.child("Users");
                    Firebase mRefChild = mRef2.child(currentUser1.getpassWord());
                    mRefChild.setValue(User.getCurrentUser());

                    ArrayList<Shelter> list = getShelterList();
                    for (Shelter shell: list) {
                        String s = shell.getName();
                        String sheltername2 = shelter.getName();
                        if (s.equals(sheltername2)) {
                            shell = shelter;

                        }
                    }
                    Shelter.setShelterList(list);
                    mRefChild = mRef.child("Shelter");
                    mRefChild.setValue(getShelterList());
                    reserveButton.setText((currentUser1.
                            isHasReservation())? "Cancel Reservation": "Reserve");

                } else {
                    int familyReservations = currentUser1.getNumFamilyReserved() * -1;
                    int individualReservation =
                            currentUser1.getNumIndividualReserved() * -1;
                    Shelter reservedShelter =
                            Shelter.findShelter(currentUser1.getShelterReserved());
                    reservedShelter.reserveFamily(familyReservations);
                    reservedShelter.reserveIndividual(individualReservation);

                    ShelterDetailActivity.this.family.setText("Family capacity " + shelter.getFamily());
                    ShelterDetailActivity.this.individual.setText("Singles capacity " + shelter.getIndividual());
                    User currentUser3 = User.getCurrentUser();
                    currentUser3.setHasReservation(false);
                    currentUser3.setNumFamilyReserved(0);
                    currentUser3.setNumIndividualReserved(0);
                    currentUser3.setShelterReserved("");
                    mRef = new Firebase("https://cs-2340-software.firebaseio.com/");
                    Firebase mRef2 = mRef.child("Users");
                    Firebase mRefChild = mRef2.child(currentUser3.getpassWord());
                    mRefChild.setValue(User.getCurrentUser());

                    ArrayList<Shelter> list = getShelterList();
                    for (Shelter shell: list) {
                        String shellName = shell.getName();
                        String shelterName = shelter.getName();
                        if (shellName.equals(shelterName)) {
                            shell = shelter;

                        }
                    }
                    Shelter.setShelterList(list);
                    mRefChild = mRef.child("Shelter");

                    mRefChild.setValue(getShelterList());
                    reserveButton.setText((currentUser3.
                            isHasReservation())? "Cancel Reservation": "Reserve");

                }
            }
        });
    }


    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            Resources resourcestoget = getResources();
            int shortAnimTime = resourcestoget.getInteger(android.R.integer.config_shortAnimTime);

            name.setVisibility(show ? View.GONE : View.VISIBLE);
            ViewPropertyAnimator propertyAnimator = name.animate();
            ViewPropertyAnimator propertyAnimator1 = propertyAnimator.setDuration(shortAnimTime);
            ViewPropertyAnimator propertyAnimator2 = propertyAnimator1.alpha(show ? 0 : 1);
            ViewPropertyAnimator propertyAnimator3 = propertyAnimator2.setListener
                    (new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    name.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            /*
            name.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    name.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });
             */

            capacity.setVisibility(show ? View.VISIBLE : View.GONE);
            ViewPropertyAnimator viewPropertyAnimator = capacity.animate();
            ViewPropertyAnimator viewPropertyAnimator1 = viewPropertyAnimator.
                    setDuration(shortAnimTime);
            ViewPropertyAnimator viewPropertyAnimator2 = viewPropertyAnimator1.alpha(show ? 1 : 0);
            ViewPropertyAnimator viewPropertyAnimator3 = viewPropertyAnimator2.setListener
                    (new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    capacity.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
            /*
            capacity.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    capacity.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
             */

            restriction.setVisibility(show ? View.GONE : View.VISIBLE);
            ViewPropertyAnimator viewPropertyAnimator4 = restriction.animate();
            ViewPropertyAnimator viewPropertyAnimator5 = viewPropertyAnimator4.
                    setDuration(shortAnimTime);
            ViewPropertyAnimator viewPropertyAnimator6 = viewPropertyAnimator5.alpha(show ? 0 : 1);
            ViewPropertyAnimator viewPropertyAnimator7 = viewPropertyAnimator6.setListener
                    (new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    restriction.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });
            /*
            restriction.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    restriction.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });
            */

            address.setVisibility(show ? View.VISIBLE : View.GONE);
            ViewPropertyAnimator viewPropertyAnimator8 = address.animate();
            ViewPropertyAnimator viewPropertyAnimator9 = viewPropertyAnimator8.
                    setDuration(shortAnimTime);
            ViewPropertyAnimator viewPropertyAnimator10 = viewPropertyAnimator9.alpha(show ? 1 : 0);
            ViewPropertyAnimator viewPropertyAnimator11 = viewPropertyAnimator10.setListener
                    (new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            address.setVisibility(show ? View.VISIBLE : View.GONE);
                        }
                    });
            /*
            address.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    address.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
             */

            longitude.setVisibility(show ? View.GONE : View.VISIBLE);
            ViewPropertyAnimator viewPropertyAnimator12 = longitude.animate();
            ViewPropertyAnimator viewPropertyAnimator13 = viewPropertyAnimator12.setDuration(shortAnimTime);
            ViewPropertyAnimator viewPropertyAnimator14 = viewPropertyAnimator13.alpha(show ? 0 : 1);
            ViewPropertyAnimator viewPropertyAnimator15 = viewPropertyAnimator14.setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    longitude.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });
            /*
            longitude.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    longitude.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });
             */

            latitude.setVisibility(show ? View.VISIBLE : View.GONE);
            ViewPropertyAnimator animator = latitude.animate();
            ViewPropertyAnimator animator1 = animator.setDuration(shortAnimTime);
            ViewPropertyAnimator animator2 = animator1.alpha(show ? 1 : 0);
            ViewPropertyAnimator animator3 = animator2.setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    latitude.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
            /*
            latitude.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    latitude.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
             */

            number.setVisibility(show ? View.VISIBLE : View.GONE);
            ViewPropertyAnimator animator4 = number.animate();
            ViewPropertyAnimator animator5 = animator4.setDuration(shortAnimTime);
            ViewPropertyAnimator animator6 = animator5.alpha(show ? 1 : 0);
            ViewPropertyAnimator animator7 = animator6.setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    number.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
            /*
            number.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    number.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
             */

            notes.setVisibility(show ? View.VISIBLE : View.GONE);
            ViewPropertyAnimator propertyAnimator4 = notes.animate();
            ViewPropertyAnimator propertyAnimator5 = propertyAnimator4.setDuration(shortAnimTime);
            ViewPropertyAnimator propertyAnimator6 = propertyAnimator5.alpha(show ? 1 : 0);
            ViewPropertyAnimator propertyAnimator7 = propertyAnimator6.setListener
                    (new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    notes.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
            /*
            notes.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    notes.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
             */

            family.setVisibility(show ? View.VISIBLE : View.GONE);
            ViewPropertyAnimator animator8 = family.animate();
            ViewPropertyAnimator animator9 = animator8.setDuration(shortAnimTime);
            ViewPropertyAnimator animator10 = animator9.alpha(show ? 1 : 0);
            ViewPropertyAnimator animator11 = animator10.setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    family.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
            /*
            family.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    family.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
             */

            individual.setVisibility(show ? View.VISIBLE : View.GONE);
            ViewPropertyAnimator animator12 = individual.animate();
            ViewPropertyAnimator animator13 = animator12.setDuration(shortAnimTime);
            ViewPropertyAnimator animator14 = animator13.alpha(show ? 1 : 0);
            ViewPropertyAnimator animator15 = animator14.setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    individual.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
            /*
            individual.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    individual.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
             */
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            name.setVisibility(show ? View.VISIBLE : View.GONE);
            name.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

}
