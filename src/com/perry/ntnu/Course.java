package com.perry.ntnu;

import java.lang.reflect.Array;

public class Course {

    private String name, code, credit, studyLevelName;
    private Array[] infoType;

    public Course(String name, String code, Array[] infoType){
        super();
        this.name = name;
        this.code = code;
        this.infoType = infoType;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getStudyLevelName() {
        return studyLevelName;
    }

    public void setStudyLevelName(String studyLevelName) {
        this.studyLevelName = studyLevelName;
    }

    public Array[] getInfoType() {
        return infoType;
    }

    public void setInfoType(Array[] infoType) {
        this.infoType = infoType;
    }
}
