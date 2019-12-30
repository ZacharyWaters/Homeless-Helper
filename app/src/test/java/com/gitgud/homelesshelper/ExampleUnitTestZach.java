package com.gitgud.homelesshelper;

import org.junit.Test;

import com.gitgud.homelesshelper.model.SearchProvider;
import com.gitgud.homelesshelper.model.Shelter;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTestZach {
    @Test
    public void testGenderField() {
        ArrayList<Shelter> testList = new ArrayList<>();
        testList.add(new Shelter("1","name1","12","Men","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));

        SearchProvider.search(testList, "", "MALE", "");
        assertEquals(  1, SearchProvider.getSearchResult().size());
    }
    @Test
    public void testNotGenderField() {
        ArrayList<Shelter> testList = new ArrayList<>();
        testList.add(new Shelter("1","name2","12","Men","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));

        SearchProvider.search(testList, "", "FEMALE", "");
        assertEquals(0,SearchProvider.getSearchResult().size());
    }
    @Test
    public void testAnyGenderField() {
        ArrayList<Shelter> testList = new ArrayList<>();
        testList.add(new Shelter("1","name1","12","Men","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("1","name2","12","Women","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));

        SearchProvider.search(testList, "", "ANYONE", "");
        assertEquals(2,SearchProvider.getSearchResult().size());
    }
    @Test
    public void testNoRestricAgeField() {
        ArrayList<Shelter> testList = new ArrayList<>();
        testList.add(new Shelter("1","name1","12","anyone","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("2","name2","12","children","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("3","name3","12","young adults","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("4","name4","12","families","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));

        SearchProvider.search(testList, "", "", "NO_RESTRICTIONS");
        assertEquals(  4, SearchProvider.getSearchResult().size());
    }
    @Test
    public void testAnyAgeField() {
        ArrayList<Shelter> testList = new ArrayList<>();
        testList.add(new Shelter("1","name1","12","anyone","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("2","name2","12","children","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("3","name3","12","young adults","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("4","name4","12","families","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));

        SearchProvider.search(testList, "", "", "ANYONE");
        assertEquals(  1, SearchProvider.getSearchResult().size());
    }
    @Test
    public void testChildrenAgeField() {
        ArrayList<Shelter> testList = new ArrayList<>();
        testList.add(new Shelter("1","name1","12","anyone","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("2","name2","12","children","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("3","name3","12","young adults","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("4","name4","12","families","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));

        SearchProvider.search(testList, "", "", "CHILDREN");
        assertEquals(  1, SearchProvider.getSearchResult().size());
    }
    @Test
    public void testYoungAdultsAgeField() {
        ArrayList<Shelter> testList = new ArrayList<>();
        testList.add(new Shelter("1","name1","12","anyone","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("2","name2","12","children","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("3","name3","12","young adults","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("4","name4","12","families","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));

        SearchProvider.search(testList, "", "", "YOUNG_ADULTS");
        assertEquals(  1, SearchProvider.getSearchResult().size());
    }

    @Test
    public void testFamiliesAgeField() {
        ArrayList<Shelter> testList = new ArrayList<>();
        testList.add(new Shelter("1","name1","12","anyone","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("2","name2","12","children","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("3","name3","12","young adults","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("4","name4","12","families","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));

        SearchProvider.search(testList, "", "", "FAMILIES_AND_NEWBORNS");
        assertEquals(  1, SearchProvider.getSearchResult().size());
    }

    @Test
    public void testNameField() {
        ArrayList<Shelter> testList = new ArrayList<>();
        testList.add(new Shelter("1","name1","12","anyone","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("2","name2","12","children","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("3","name3","12","young adults","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));
        testList.add(new Shelter("4","name4","12","families","3513.1",
                "3513.1","6530 fairgreen drive","nothing","23"));

        SearchProvider.search(testList, "name1", "", "NO_RESTRICTIONS");
        assertEquals(  1, SearchProvider.getSearchResult().size());
    }
}