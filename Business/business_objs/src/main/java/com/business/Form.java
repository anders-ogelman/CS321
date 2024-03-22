package com.business;

/**
 * Hello world!
 *
 */
public class Form {
    private int PID, relatedPID;
    private String DOB, firstName, middleName, lastName, relation;

    public Form(int PID, int relatedPID, String DOB, String relation, String firstName, String middleName,
            String lastName) {
        this.PID = PID;
        this.DOB = DOB;
        this.relatedPID = relatedPID;
        this.relation = relation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
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

    public int getRelatedPID() {
        return relatedPID;
    }

    public String getRelation() {
        return relation;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public void setRelatedPID(int relatedPID) {
        this.relatedPID = relatedPID;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

}
