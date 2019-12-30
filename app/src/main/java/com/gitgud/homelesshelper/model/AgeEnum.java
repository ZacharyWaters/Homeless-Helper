package com.gitgud.homelesshelper.model;

/**
 * Created by Zach Waters on 3/12/2018.
 * THIS LINE
 */

public enum AgeEnum {
    NO_RESTRICTIONS ("No Restrictions"),
    ANYONE ("Anyone"),
    FAMILIES_AND_NEWBORNS ("Family/Newborn"),
    CHILDREN ("Children"),
    YOUNG_ADULTS ("Young Adults");
    private final String text;
    AgeEnum(String text){
        this.text=text;
    }

    /**
     * @return text
     */
    public String getText(){
        return text;
    }
}
