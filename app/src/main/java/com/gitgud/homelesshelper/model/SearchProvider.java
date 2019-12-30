package com.gitgud.homelesshelper.model;

import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by collin on 3/13/18.
 * THIS LINE
 */

public class SearchProvider {
    private static ArrayList<Shelter> result;
    static boolean ischanged=false;

    /**
     * @param list Arraylist of Shelter
     * @param nameField String
     * @param genderField String
     * @param ageField String
     */
    public static void search
            (ArrayList<Shelter> list, String nameField, String genderField, String ageField) {
        //variables
        result = new ArrayList<>(list);
        @Nullable String genderString = null;
        String ageString = "";

        if (genderField.contains("MALE")) {
            genderString = "Men";
        }
        if (genderField.contains("FEMALE")) {
            genderString = "Women";
        }
        if (genderField.contains("ANYONE")) {
            genderString = null;
        }

        if(ageField.contains("NO_RESTRICTIONS")){
            ageString = "";
        }
        if (ageField.contains("ANYONE")) {
            ageString = "anyone";
        }
        if (ageField.contains("CHILDREN")) {
            ageString = "children";
        }
        if (ageField.contains("YOUNG_ADULTS")) {
            ageString = "young";
        }
        if (ageField.contains("FAMILIES_AND_NEWBORNS")) {
            ageString = "families";
        }

        //for loop to go through array
        for (Shelter obj : list) {
                if (!(nameField == null)) {
                    String obj1 = obj.getName();
                    String obj2 = obj1.toLowerCase();
                    String nameField2 = nameField.toLowerCase();
                    if (!((obj2).contains(nameField2))) {
                        result.remove(obj);
                    }
                }
                if (!(genderString == null)) {
                    String restriction2 = obj.getRestriction();
                    if (!((restriction2).contains(genderString))) {
                        result.remove(obj);
                    }
                }
                if (!(ageString == null)) {
                    String restriction3 = obj.getRestriction();
                    String restriction4 = restriction3.toLowerCase();
                    String ageString2 = ageString.toLowerCase();
                    if (!((restriction4).contains(ageString2))) {
                        result.remove(obj);
                    }
                }

        }
    }


    /**
     * @return result
     */
    public static ArrayList<Shelter> getSearchResult() {
        return result;
    }

}
