package com.SWEPJ;

/**
 * Hello world!
 *
 */
public class Form {
    private Boolean fail[];
    private int PID;
    private String DOB, firstName, middleName, lastName, relation;

    public Form(int PID, String DOB, String relation, String firstName, String middleName, String lastName) {
        this.PID = PID;
        this.DOB = DOB;
        this.relation = relation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        fail = new Boolean[7];
        for (int i = 0; i < 7; i++) {
            fail[i] = false;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getPID() {
        return PID;
    }

    public String getRelation() {
        return relation;
    }

    public String getDOB() {
        return DOB;
    }

    public Boolean setDOB(String DOB) {
        String temp = this.DOB;
        this.DOB = DOB;
        if (isValid())
            return true;
        this.DOB = temp;
        return false;
    }

    public Boolean setFirstName(String firstName) {
        String temp = this.firstName;
        this.firstName = firstName;
        if (isValid())
            return true;
        this.firstName = temp;
        return false;
    }

    public Boolean setLastName(String lastName) {
        String temp = this.lastName;
        this.lastName = lastName;
        if (isValid())
            return true;
        this.lastName = temp;
        return false;
    }

    public Boolean setMiddleName(String middleName) {
        String temp = this.middleName;
        this.middleName = middleName;
        if (isValid())
            return true;
        this.middleName = temp;
        return false;
    }

    public Boolean setPID(int PID) {
        int temp = this.PID;
        this.PID = PID;
        if (isValid())
            return true;
        this.PID = temp;
        return false;
    }

    public Boolean setRelatedPID(int relatedPID) {
        int temp = this.relatedPID;
        this.relatedPID = relatedPID;
        if (isValid())
            return true;
        this.relatedPID = temp;
        return false;
    }

    public Boolean setRelation(String relation) {
        String temp = this.relation;
        this.relation = relation;
        if (isValid())
            return true;
        this.relation = temp;
        return false;
    }

    public Boolean isValid() {
        // check PID, if fails index = 0
        /*
         * if (String.valueOf(PID).length() != 9) {
         * fail[0] = true;
         * }
         */
        // needs to also check itself against the database, database not done yet tho
        return true;
    }

}
