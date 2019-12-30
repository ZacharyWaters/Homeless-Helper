package com.gitgud.homelesshelper.model;

import android.support.annotation.Nullable;

/**
 * Created by csaet on 2/21/2018.
 * THIS LINE
 */

public class User {

    private String userName;
    private String password;
    @Nullable
    private String email;
    //private String id;
    private String classs;
    private String name;
    private int numFamilyReserved;
    private int numIndividualReserved;
    private String ShelterReserved;
    private boolean hasReservation;
    private static User currentUser;


    /**
     *
     */
    public User() {

    }

    /**
     * @param userName String
     * @param password String
     * @param name String
     * @param Class String
     */
    public User(String userName, String password, String name, String Class) {
        this.userName = userName;
        this.password = password;
        this.classs = Class;
        this.name = name;
        this.email = null;
        ShelterReserved = "";
        //add to firebase
    }

    /**
     * @return String
     */
    public String getuserName() {
        return userName;
    }

    /**
     * @return String
     */
    public String getpassWord() {
        return password;
    }

    /**
     * @return String
     */
    public CharSequence getname() {
        return name;
    }

    /**
     * @return String
     */
    public CharSequence getclasss() {
        return classs;
    }

    /**
     * @return int
     */
    public int getNumFamilyReserved() {
        return numFamilyReserved;
    }

    /**
     * @return int
     */
    public int getNumIndividualReserved() {
        return numIndividualReserved;
    }

    /**
     * @return String
     */
    public String getemail() {
        return email;
    }


    /**
     * @return String
     */
    public String getShelterReserved() {
        return ShelterReserved;
    }

    /**
     * @param s String
     */
    public void setuserName(String s) {
        userName = s;
    }

    /**
     * @param s String
     */
    public void setpassWord(String s) {
        password = s;
    }

    /**
     * @param s String
     */
    public void getname(String s) {
        name = s;
    }

    /**
     * @param s String
     */
    public void setclasss(String s) {
        classs = s;
    }

    /**
     * @param s String
     */
    public void setemail(String s) {
        email = s;
    }

    /**
     * @param s String
     */
    public void setShelterReserved(String s) {
        ShelterReserved = s;
    }

    /**
     * @param numFamilyReserved int
     */
    public void setNumFamilyReserved(int numFamilyReserved) {
        this.numFamilyReserved = numFamilyReserved;
    }

    /**
     * @param numIndividualReserved int
     */
    public void setNumIndividualReserved(int numIndividualReserved) {
        this.numIndividualReserved = numIndividualReserved;
    }

    /**
     * @return User
     */
    public static User getCurrentUser() {
        return currentUser;
    }

    /**
     * @param currentUser User
     */
    public static void setCurrentUser(User currentUser) {
        User.currentUser = currentUser;
    }

    /**
     * @return boolean
     */
    public boolean isHasReservation() {
        return hasReservation;
    }

    /**
     * @param hasReservation boolean
     */
    public void setHasReservation(boolean hasReservation) {
        this.hasReservation = hasReservation;
    }

    //    public String getUserName() {
//        return userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getEmail() { return email; }
//
//    public String getId() { return id; }
//
//    public static void setUserName(String userName) {
//        if (! (usernamelist.contains(userName))) {
//            usernamelist.add(userName);
//        }
//    }
//
//    public static void setPassword(String password) {
//        if (! (passwordlist.contains(password))) {
//            passwordlist.add(password);
//        }
//    }
//
//    public static void setName(String name) {
//        if (! (namelist.contains(name))) {
//            namelist.add(name);
//        }
//    }
//
//    public static void setClassification(String name) {
//        classificationList.add(name);
//    }
//
//    public static vo
//    public static String getName() {
//        return Name;
//    }
//
//    public static String getClasss() {
//        return Class;
//    }
//
//    public static String getClassification(int i) {
//        return classificationList.get(i);
//    }
//    id setClass(int i) {
//        Class = classificationList.get(i);
//    }
//
//    public static void setName(int i) {
//        Name = namelist.get(i);
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public List getUsernameList() {
//        List list = usernamelist;
//        return list;
//    }
//
//    public static boolean isValidUsername(String s) {
//        return  usernamelist.contains(s) && s.length() > 4 &&  s.contains("@");
//    }
//
//    public static boolean isValidPassword(String s) {
//        return  passwordlist.contains(s) && s.length() > 4;
//    }
//
//    public static boolean isEnterablePassword(String s) {
//        return  ! passwordlist.contains(s) && s.length() > 4;
//    }
//
//    public static boolean isEnterableUsername(String s) {
//        return  (! (usernamelist.contains(s))) && s.length() > 4 &&  s.contains("@");
//    }
//
//    public static int indexOfUser(String s) {
//        return usernamelist.indexOf(s);
//    }
//
//
//
//    public static boolean isValidCombination(String s, String t) {
//        return usernamelist.indexOf(s) == passwordlist.indexOf(t);
//    }
}
