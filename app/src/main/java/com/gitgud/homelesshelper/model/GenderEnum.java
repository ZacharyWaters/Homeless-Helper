package com.gitgud.homelesshelper.model;

/**
 * Created by Zach Waters on 3/12/2018.
 * THIS LINE
 */

public enum GenderEnum {
    ANYONE ("Anyone"),
    MALE ("Male"),
    FEMALE ("Female");
    private final String text;
    GenderEnum(String text){
        this.text=text;
    }

    /**
     * @return text
     */
    public String getText(){
        return text;
    }
}
