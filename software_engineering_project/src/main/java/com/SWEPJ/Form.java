package com.SWEPJ;

/**
 * Hello world!
 *
 */
public class Form {
    private Boolean fail[];
    private long PID;
    private long[] relatedPID;
    private String DOB, DOD, firstName, middleName, lastName, email;
    private String[] relation;

    public Form(long PID, String DOB, String DOD, String[] relation, String firstName, String middleName,
            String lastName, String email, long[] relatedPID) {
        this.PID = PID;
        this.DOB = DOB;
        this.DOD = DOD;
        this.relation = relation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.relatedPID = relatedPID;
        fail = new Boolean[9];
        for (int i = 0; i < 9; i++)
            fail[i] = false; // PID DOB relation firstName middleName lastName email
        isValid();// Will require user classes to manually check fail[] array
    }

    public String getDOD() {
        return DOD;
    }

    public long[] getRelatedPID() {
        return relatedPID;
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

    public long getPID() {
        return PID;
    }

    public String[] getRelation() {
        return relation;
    }

    public String getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }

    public Boolean[] getFail() {
        return fail;
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

    public Boolean setDOD(String DOD) {
        String temp = this.DOD;
        this.DOD = DOD;
        if (isValid())
            return true;
        this.DOD = temp;
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

    public Boolean setPID(long PID) {
        long temp = this.PID;
        this.PID = PID;
        if (isValid())
            return true;
        this.PID = temp;
        return false;
    }

    public Boolean setRelatedPID(long[] relatedPID) {
        long[] temp = this.relatedPID;
        this.relatedPID = relatedPID;
        if (isValid())
            return true;
        this.relatedPID = temp;
        return false;
    }

    public Boolean setRelation(String[] relation) {
        String[] temp = this.relation;
        this.relation = relation;
        if (isValid())
            return true;
        this.relation = temp;
        return false;
    }

    public boolean setEmail(String email) {
        String temp = this.email;
        this.email = email;
        if (isValid())
            return true;
        this.email = temp;
        return false;
    }

    // WIP
    public Boolean isValid() {
        // reset fail array
        for (int i = 0; i < 8; i++)
            fail[i] = false;

        // checks for PID
        if (String.valueOf(PID).length() != 9) {
            fail[0] = true;
        }

        // checks for DOB
        /* */
        String[] birthdate = DOB.split("/", 3);
        int month = Integer.parseInt(birthdate[0]);
        int day = Integer.parseInt(birthdate[1]);
        int year = Integer.parseInt(birthdate[2]);

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31 || day < 1)
                    fail[1] = true;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30 || day < 1)
                    fail[1] = true;
                break;
            case 2:
                if (year % 4 == 0) {
                    if (day > 29 || day < 1)
                        fail[1] = true;
                } else {
                    if (day > 28 || day < 1)
                        fail[1] = true;
                }
                break;
            default:
                fail[1] = true;
                break;
        }
        if (year < 1900 || year > 2023)
            fail[1] = true;

        // checks for relation
        // if (relation.length() > 35 || relation.length() < 1)
        // fail[3] = true;

        // checks for firstName
        if (firstName.length() > 35 || firstName.length() < 1)
            fail[4] = true;

        // checks for middleName
        if (middleName.length() > 35)
            fail[5] = true;

        // checks for lastName
        if (lastName.length() > 35 || lastName.length() < 1)
            fail[6] = true;

        // check if any field failed
        for (int i = 0; i < 8; i++) {
            if (fail[i] == true)
                return false;
        }
        return true;
    }

}
