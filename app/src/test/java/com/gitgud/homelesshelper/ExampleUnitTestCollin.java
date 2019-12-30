package com.gitgud.homelesshelper;

import com.gitgud.homelesshelper.model.User;
import com.gitgud.homelesshelper.model.UserAuthentication;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Collin Avidano
 */

public class ExampleUnitTestCollin {
    @Test
    public void testIsValidCombination(){
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Hello@", "foobar", "Collin", "User"));
        list.add(new User("Binky@", "HelloWorld", "David", "User"));
        list.add(new User("Sorry@", "Titan", "Ian", "Admin"));
        list.add(new User("Dangit@", "CHRIST", "Dawson", "Admin"));
        UserAuthentication.setList(list);

        assertTrue(UserAuthentication.isValidPassword("fragit") == true);
        assertTrue(UserAuthentication.isValidPassword("switch") == true);
        assertTrue(UserAuthentication.isValidPassword("friggin") == true);
        assertTrue(UserAuthentication.isValidPassword("break") == true);
    }

    @Test
    public void testPartial(){
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Hello@", "foobar", "Collin", "User"));
        list.add(new User("Binky@", "HelloWorld", "David", "User"));
        list.add(new User("Sorry@", "Titan", "Ian", "Admin"));
        list.add(new User("Dangit@", "CHRIST", "Dawson", "Admin"));
        UserAuthentication.setList(list);

        assertTrue(UserAuthentication.isValidPassword("fooba") == true);
        assertTrue(UserAuthentication.isValidPassword("Hello") == true);
        assertTrue(UserAuthentication.isValidPassword("TITAN") == true);
        assertTrue(UserAuthentication.isValidPassword("Christ") == true);
    }

    @Test
    public void testNull() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Hello@", "foobar", "Collin", "User"));
        list.add(new User("Binky@", "HelloWorld", "David", "User"));
        list.add(new User("Sorry@", "Titan", "Ian", "Admin"));
        list.add(new User("Dangit@", "CHRIST", "Dawson", "Admin"));
        UserAuthentication.setList(list);

        assertTrue(UserAuthentication.isValidPassword(null) == false);
    }

    @Test
    public void testShort() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Hello@", "foobar", "Collin", "User"));
        list.add(new User("Binky@", "HelloWorld", "David", "User"));
        list.add(new User("Sorry@", "Titan", "Ian", "Admin"));
        list.add(new User("Dangit@", "CHRIST", "Dawson", "Admin"));
        UserAuthentication.setList(list);

        assertTrue(UserAuthentication.isValidPassword("frag") == false);
        assertTrue(UserAuthentication.isValidPassword("fry") == false);
    }

    @Test
    public void testUnicode() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Hello@", "foobar", "Collin", "User"));
        list.add(new User("Binky@", "HelloWorld", "David", "User"));
        list.add(new User("Sorry@", "Titan", "Ian", "Admin"));
        list.add(new User("Dangit@", "CHRIST", "Dawson", "Admin"));
        UserAuthentication.setList(list);


        assertTrue(UserAuthentication.isValidPassword("h" + "\u00ea" + "llo") == false);
    }

}