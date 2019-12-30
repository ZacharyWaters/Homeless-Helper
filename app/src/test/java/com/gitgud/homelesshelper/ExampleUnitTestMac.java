package com.gitgud.homelesshelper;

import org.junit.Test;

import com.gitgud.homelesshelper.model.User;
import com.gitgud.homelesshelper.model.UserAuthentication;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Mac Mattis
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTestMac {
    @Test
    public void testIsValidCombination(){
        ArrayList<User> testList = new ArrayList<>();
        testList.add(new User("abcdefg@", "password", "Mac", "User"));
        testList.add(new User("pass1@", "abcdef", "camillo", "User"));
        testList.add(new User("gaslight@", "propane", "mcpherson", "Admin"));
        testList.add(new User("romansoldier@", "jesuschrist", "mathis", "Admin"));
        testList.add(new User("bluedolphin", "yoyo", "conner", "User"));
        UserAuthentication.setList(testList);



        assertTrue(true == UserAuthentication.isValidCombination("password", "abcdefg@"));
        assertTrue(false == UserAuthentication.isValidCombination( "password", "abcdef@"));
        assertTrue(false == UserAuthentication.isValidCombination("passwor", "abcdefg@"));
        assertTrue(false == UserAuthentication.isValidCombination( "password", "gaslight@"));
        assertTrue(false == UserAuthentication.isValidCombination("jesuschrist", "bluedolphin"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullUsername() {
        ArrayList<User> testList = new ArrayList<>();
        testList.add(new User("abcdefg@", "password", "Mac", "User"));
        testList.add(new User("pass1@", "abcdef", "camillo", "User"));
        testList.add(new User("gaslight@", "propane", "mcpherson", "Admin"));
        testList.add(new User("romansoldier@", "jesuschrist", "mathis", "Admin"));
        testList.add(new User("bluedolphin", "yoyo", "conner", "User"));
        UserAuthentication.setList(testList);

        boolean b = UserAuthentication.isValidCombination(null, "password");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPassword() {
        ArrayList<User> testList = new ArrayList<>();
        testList.add(new User("abcdefg@", "password", "Mac", "User"));
        testList.add(new User("pass1@", "abcdef", "camillo", "User"));
        testList.add(new User("gaslight@", "propane", "mcpherson", "Admin"));
        testList.add(new User("romansoldier@", "jesuschrist", "mathis", "Admin"));
        testList.add(new User("bluedolphin", "yoyo", "conner", "User"));
        UserAuthentication.setList(testList);

        boolean b = UserAuthentication.isValidCombination("abcdefg", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullCombo() {
        ArrayList<User> testList = new ArrayList<>();
        testList.add(new User("abcdefg@", "password", "Mac", "User"));
        testList.add(new User("pass1@", "abcdef", "camillo", "User"));
        testList.add(new User("gaslight@", "propane", "mcpherson", "Admin"));
        testList.add(new User("romansoldier@", "jesuschrist", "mathis", "Admin"));
        testList.add(new User("bluedolphin", "yoyo", "conner", "User"));
        UserAuthentication.setList(testList);

        boolean b = UserAuthentication.isValidCombination(null, null);
    }
}