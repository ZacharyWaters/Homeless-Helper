//package com.gitgud.homelesshelper.model;
//
//import android.support.annotation.NonNull;
//import android.util.Log;
//
//import java.util.ArrayList;
//
///**
// * Created by csaet on 2/24/2018.
// */
//
//public class Shelter implements Comparable<Shelter>{
//
//
//
//    private static ArrayList<Shelter> shelterList = new ArrayList<>();
//    public static String SHELTER_NAME = "shelter_name";
//
//    private String id;
//    private String name;
//    private String capacity;
//    private int vacancy;
//    private String restriction;
//    private String longitude;
//    private String latitude;
//    private String address;
//    private String notes;
//    private String number;
//
//    public Shelter(String id, String name, String capacity, String restriction, String longitude,
//                   String latitude, String address, String notes, String number){
//        this.id = id;
//        if (name == null) {
//            this.name = "N/a";
//        } else{
//            this.name = name;
//        }
//        this.name = name;
//        if (capacity == null) {
//            this.capacity = "N/a";
//        } else{
//            this.capacity = capacity;
//        }
//        this.restriction = restriction;
//        this.longitude = longitude;
//        this.latitude = latitude;
//        this.address = address;
//        this.notes = notes;
//        this.number = number;
//        if (capacity == null) {
//        //    this.vacancy = 0;
//        } else {
//        //    this.vacancy = Integer.parseInt(capacity);
//        }
//        if(!shelterList.contains(this)) {
//            shelterList.add(this);
//        }
//        Log.e("myApp", "length is " + shelterList.size());
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    //public int getVacancy() { return vacancy;}
//
//    public String getName() {
//        return name;
//    }
//
//    public String getCapacity() {
//        return capacity;
//    }
//
//    public String getRestriction() {
//        return restriction;
//    }
//
//    public String getLongitude() {
//        return longitude;
//    }
//
//    public String getLatitude() {
//        return latitude;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public String getNotes() {
//        return notes;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public static ArrayList<Shelter> getShelterList() {
//        return shelterList;
//    }
//
//
//    public static Shelter findShelter(String id) {
//        return shelterList.get(Integer.parseInt(id));
//    }
//
//    public boolean equals(Object o) {
//        Shelter k = (Shelter) o;
//        return this.name.equals(k.getName());
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }
//
//    @Override
//    public int compareTo(@NonNull Shelter o) {
//        return this.getName().compareTo(o.getName());
//    }
//}

package com.gitgud.homelesshelper.model;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by csaet on 2/24/2018.
 * THIS LINE
 */

public class Shelter implements Comparable<Shelter>{



    private static ArrayList<Shelter> shelterList = new ArrayList<>();
    public static final String SHELTER_NAME = "shelter_name";

    private final String id;
    private String name;
    private final String capacity;
    private final String restriction;
    private final String longitude;
    private final String latitude;
    private final String address;
    private final String notes;
    private final String number;
    private int individual;
    private int family;
    private int[] familyArray = new int[] {1, 2, 3};
    private int[] individualArray = new int[] {1, 2, 3};

    /**
     * @param id String
     * @param name String
     * @param capacity String
     * @param restriction String
     * @param longitude String
     * @param latitude String
     * @param address String
     * @param notes String
     * @param number String
     */
    public Shelter(String id, String name, String capacity, String restriction, String longitude,
                   String latitude, String address, String notes, String number){
        this.id = id;
        if (name == null) {
            this.name = "N/A";
        } else{
            this.name = name;
        }
        this.name = name;
        if (capacity == null) {
            this.capacity = "N/A";
        } else{
            this.capacity = capacity;
        }
        this.restriction = restriction;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.notes = notes;
        this.number = number;
        capacityCheck();
        reserveFamily(0);
        reserveIndividual(0);
         if (!shelterList.contains(this)) {
             shelterList.add(this);
         }
        Log.e("myApp", "length is " + shelterList.size());
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return String
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * @return String
     */
    public String getRestriction() {
        return restriction;
    }

    /**
     * @return String
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @return String
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return String
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @return String
     */
    public String getNumber() {
        return number;
    }

    /**
     * @return family
     */
    public int getFamily() {
        return family;
    }

    /**
     * @return int
     */
    public int getIndividual() {
        return individual;
    }

    /**
     * @return ArrayList<Shelter>
     */
    public static ArrayList<Shelter> getShelterList() {
        return shelterList;
    }

    /**
     * @param l Arraylist of Shelters
     */
    public static void setShelterList(ArrayList<Shelter> l) {
        shelterList = l;
    }

    public boolean equals(Object o) {
        Shelter d = (Shelter) o;
        return this.name.equals(d.getName());
    }

    /**
     * @return String[]
     */
    public String[] getFamilyArray() {
        String[] temp = new String[familyArray.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.toString(familyArray[i]);
        }
        return temp;
    }

    /**
     * @return String[]
     */
    public String[] getIndividualArray() {
        String[] temp = new String[individualArray.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.toString(individualArray[i]);
        }
        return temp;
    }

    /**
     * @param id String
     * @return ShelterList
     */
    public static Shelter findShelter(String id) {
        return shelterList.get(Integer.parseInt(id));
    }

    private void capacityCheck() {
        if ("N/A".equals(capacity)) {
            this.individual = 0;
            this.family = 0;
        } else if (capacity.length() < 4) {
            this.individual = Integer.parseInt(capacity);
        } else {
            String[] capacities = capacity.split(",");
            for (String capacity1 : capacities) {
                Log.e("myApp", "runs");
                StringBuilder num = new StringBuilder();
                for (int j = 0; j < capacity1.length(); j++) {
                    if ((capacity1.charAt(j) < 58) && (capacity1.charAt(j) > 47)) {
                        num.append(capacity1.charAt(j));
                    }
                }
                Log.e("numnum", "The array element is" + capacity1);

                Log.e("numnum", "The capacity is" + num);

                if (capacity1.contains("fam") || capacity1.contains("apart")) {
                    this.family = Integer.parseInt(num.toString());
                } else if (capacity1.contains("sing")) {
                    this.individual = Integer.parseInt(num.toString());
                }
            }
        }
    }

    /**
     * @param amount int
     */
    public final void reserveFamily(int amount) {
        this.family -= amount;
        if (this.family < 3) {
            int[] temp = new int[family];
            for (int i = 1; i < temp.length; i++) {
                temp[i] = i;
            }
            familyArray = temp;
        }
    }

    /**
     * @param amount int
     */
    public final void reserveIndividual(int amount) {
        this.individual -= amount;
        if (this.individual < 3) {
            int[] temp = new int[individual];
            for (int i = 1; i < temp.length; i++) {
                temp[i] = i;
            }
            individualArray = temp;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(@NonNull Shelter o) {
        String nameo = o.getName();
        String thisname = this.getName();
        return thisname.compareTo(nameo);
    }
}